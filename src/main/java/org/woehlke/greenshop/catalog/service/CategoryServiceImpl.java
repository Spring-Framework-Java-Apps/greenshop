package org.woehlke.greenshop.catalog.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.catalog.repositories.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

/**
 * Created by tw on 30.01.15.
 */
@Named("categoryService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class CategoryServiceImpl implements CategoryService {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private CategoryDescriptionRepositoryDao categoryDescriptionRepositoryDao;

    @Inject
    private ManufacturerRepository manufacturerRepository;

    @Inject
    private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;

    @Inject
    private SpecialRepository specialRepository;

    @Inject
    private CategoryDescriptionRepository categoryDescriptionRepository;


    @Override
    public CategoriesBean getAllCategories(Language language) {
        CategoriesBean categoriesBean = new CategoriesBean();
        List<CategoryDescription> categories = new ArrayList<CategoryDescription>();
        Map<CategoryDescription,Integer> category2level = new HashMap<CategoryDescription,Integer>();
        List<CategoryDescription> rootCategories = categoryDescriptionRepositoryDao.findRootCategories(language);
        for(CategoryDescription categoryDescription :rootCategories){
            categories.add(categoryDescription);
            category2level.put(categoryDescription,0);
            addChildCategories(categoryDescription,1,categories,category2level);
        }
        categoriesBean.setCategories(categories);
        categoriesBean.setCategory2level(category2level);
        return categoriesBean;
    }

    private void addChildCategories(
            CategoryDescription parent,
            int level,
            List<CategoryDescription> categories,
            Map<CategoryDescription,Integer> category2level){
        List<CategoryDescription> categoryDescriptions =
                categoryDescriptionRepositoryDao.findCategoriesByParentId(parent.getCategory().getId(),parent.getLanguage());
        for(CategoryDescription categoryDescription : categoryDescriptions){
            categories.add(categoryDescription);
            category2level.put(categoryDescription,level);
            addChildCategories(categoryDescription,level+1,categories,category2level);
        }
    }

    @Override
    public CategoryTreeNode findCategoryById(long categoryId, Language language) {
        CategoryDescription thisCategory = categoryDescriptionRepositoryDao.findByCategoryId(categoryId, language);
        CategoryTreeNode categoryTreeNode = new CategoryTreeNode();
        categoryTreeNode.setCategoryDescription(thisCategory);
        List<CategoryDescription> thisLevelCategories = categoryDescriptionRepositoryDao.findCategoriesByParentId(categoryId, language);
        categoryTreeNode.setHasChildCategories(!thisLevelCategories.isEmpty());
        categoryTreeNode.setNumberOfChildCategories(thisLevelCategories.size());
        int level = 0;
        CategoryDescription oneCategory = thisCategory;
        while(oneCategory.getCategory().getParentId()!=0L){
            oneCategory = categoryDescriptionRepositoryDao.findByCategoryId(oneCategory.getCategory().getParentId(), language);
            level++;
        }
        categoryTreeNode.setLevel(level);
        return categoryTreeNode;
    }

    @Override
    public CategoryTree getCategoriesTree(long categoryId,Language language){
        CategoryTree categoryTree = new CategoryTree();
        categoryTree = getNumberOfProductsPerCategory(categoryTree);
        categoryTree.setThisCategoryId(categoryId);
        if(categoryId==0L){
            categoryTree.setThisCategory(null);
            List<CategoryTreeNode> categoriesMenuList = new ArrayList<CategoryTreeNode>();
            List<CategoryDescription> thisLevelCategories = categoryDescriptionRepositoryDao.findCategoriesByParentId(0L, language);
            for(CategoryDescription oneCategory:thisLevelCategories){
                CategoryTreeNode node = new CategoryTreeNode();
                node.setLevel(0);
                node.setCategoryDescription(oneCategory);
                categoriesMenuList.add(node);
            }
            categoryTree.setCategoriesMenuList(categoriesMenuList);
        } else {
            CategoryDescription thisCategory = categoryDescriptionRepositoryDao.findByCategoryId(categoryId, language);
            categoryTree.setThisCategory(thisCategory);
            Stack<CategoryDescription> stack = new Stack<CategoryDescription>();
            Stack<CategoryDescription> stackBreadcrumb = new Stack<CategoryDescription>();
            stack.push(thisCategory);
            stackBreadcrumb.push(thisCategory);
            long parentId = thisCategory.getCategory().getParentId();
            while(parentId != 0){
                thisCategory = categoryDescriptionRepositoryDao.findByCategoryId(parentId, language);
                stack.push(thisCategory);
                stackBreadcrumb.push(thisCategory);
                parentId = thisCategory.getCategory().getParentId();
            }
            int level=0;
            List<CategoryTreeNode> categoriesMenuList = traverseCategoryTree(stack,level);
            categoryTree.setCategoriesMenuList(categoriesMenuList);
            List<CategoryDescription> breadcrumb = new ArrayList<CategoryDescription>();
            while(!stackBreadcrumb.empty()){
                breadcrumb.add(stackBreadcrumb.pop());
            }
            categoryTree.setBreadcrumb(breadcrumb);
        }
        List<CategoryTreeNode> categoriesMenuList = new ArrayList<CategoryTreeNode>();
        for(CategoryTreeNode node:categoryTree.getCategoriesMenuList()){
            long catId = node.getCategoryDescription().getCategory().getId();
            boolean hasChildCategories = categoryTree.getHasChildrenMap().get(catId);
            long numberOfProducts = categoryTree.getCategoryIdToNumberOfProducts().get(catId);
            node.setHasChildCategories(hasChildCategories);
            node.setNumberOfProducts(numberOfProducts);
            categoriesMenuList.add(node);
        }
        categoryTree.setCategoriesMenuList(categoriesMenuList);
        return categoryTree;
    }

    private List<CategoryTreeNode> traverseCategoryTree(Stack<CategoryDescription> stack,int level){
        List<CategoryTreeNode> result = new ArrayList<CategoryTreeNode>();
        if(!stack.empty()){
            CategoryDescription pathCategory = stack.pop();
            List<CategoryDescription> thisLevelCategories = categoryDescriptionRepositoryDao.findCategoriesByParentId(pathCategory.getCategory().getParentId(), pathCategory.getLanguage());
            for(CategoryDescription oneCategory:thisLevelCategories){
                CategoryTreeNode node = new CategoryTreeNode();
                node.setLevel(level);
                node.setCategoryDescription(oneCategory);
                result.add(node);
                if(pathCategory.equals(oneCategory)){
                    if(!stack.empty()){
                        result.addAll(traverseCategoryTree(stack,level+1));
                    } else {
                        List<CategoryDescription> subLevelCategories = categoryDescriptionRepositoryDao.findCategoriesByParentId(pathCategory.getCategory().getId(), pathCategory.getLanguage());
                        for(CategoryDescription oneSubCategory:subLevelCategories){
                            CategoryTreeNode subnode = new CategoryTreeNode();
                            subnode.setLevel(level+1);
                            subnode.setCategoryDescription(oneSubCategory);
                            subnode.setNumberOfChildCategories(subLevelCategories.size());
                            result.add(subnode);
                        }
                    }
                }
            }
        }
        return result;
    }

    public CategoryTree getNumberOfProductsPerCategory(CategoryTree tree){
        List<Category> allCategories = categoryRepository.findAll();
        Map<Long,Category> allCategoriesMap = new HashMap<Long,Category>();
        Map<Long,Long> categoryIdToNumberOfProducts = new HashMap<Long,Long>();
        Map<Long,Boolean> hasChildrenMap = new HashMap<Long,Boolean>();
        for(Category cat:allCategories){
            long id = cat.getId();
            allCategoriesMap.put(id, cat);
        }
        for(long id:allCategoriesMap.keySet()){
            Category cat = allCategoriesMap.get(id);
            long numberOfProducts = cat.getProducts().size();
            categoryIdToNumberOfProducts.put(id, numberOfProducts);
        }
        for(long id:allCategoriesMap.keySet()){
            Category cat = allCategoriesMap.get(id);
            long parentId=cat.getParentId();
            long numberOfProducts = cat.getProducts().size();
            while(parentId!=0){
                long numberOfProductsParent = categoryIdToNumberOfProducts.get(parentId);
                numberOfProductsParent += numberOfProducts;
                categoryIdToNumberOfProducts.remove(parentId);
                categoryIdToNumberOfProducts.put(parentId, numberOfProductsParent);
                if(!hasChildrenMap.containsKey(parentId)){
                    hasChildrenMap.put(parentId, true);
                }
                Category catParent = allCategoriesMap.get(parentId);
                parentId = catParent.getParentId();
            }
        }
        for(long id:allCategoriesMap.keySet()){
            if(!hasChildrenMap.containsKey(id)){
                hasChildrenMap.put(id, false);
            }
        }
        tree.setHasChildrenMap(hasChildrenMap);
        tree.setCategoryIdToNumberOfProducts(categoryIdToNumberOfProducts);
        return tree;
    }

    @Override
    public ProductsByCategory getProductsByCategoryAndManufacturer(
            long categoryId, long manufacturerId, Language language) {
        ProductsByCategory productsByCategory = new ProductsByCategory();
        productsByCategory.setManufacturerId(manufacturerId);
        Category category = categoryRepository.findOne(categoryId);
        Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
        List<SpecialProduct> products = new ArrayList<SpecialProduct>();
        List<ProductDescription> productDescriptions=productDescriptionRepositoryDao.findByCategoryAndManufacturer(category,manufacturer,language);
        for(ProductDescription productDescription:productDescriptions){
            SpecialProduct specialProduct = new SpecialProduct();
            specialProduct.setProductDescription(productDescription);
            Special special = specialRepository.findByProduct(productDescription.getProduct());
            specialProduct.setSpecial(special);
            products.add(specialProduct);
        }
        productsByCategory.setProducts(products);
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        for(ProductDescription pd:productDescriptions){
            if(!manufacturers.contains(pd.getProduct().getManufacturer())){
                manufacturers.add(pd.getProduct().getManufacturer());
            }
        }
        productsByCategory.setManufacturers(manufacturers);
        CategoryDescriptionId categoryDescriptionId = new CategoryDescriptionId();
        categoryDescriptionId.setLanguage(language);
        categoryDescriptionId.setCategory(category);
        CategoryDescription thisCategory = categoryDescriptionRepository.findOne(categoryDescriptionId);
        productsByCategory.setThisCategory(thisCategory);
        List<CategoryDescription> childCategories = categoryDescriptionRepositoryDao.findCategoriesByParentId(categoryId, language);
        productsByCategory.setChildCategories(childCategories);
        return productsByCategory;
    }

    @Override
    public ProductsByCategory getProductsByCategory(long categoryId,Language language){
        ProductsByCategory productsByCategory = new ProductsByCategory();
        Category category = categoryRepository.findOne(categoryId);
        List<SpecialProduct> products = new ArrayList<SpecialProduct>();
        List<ProductDescription> productDescriptions=productDescriptionRepositoryDao.findByCategory(category, language);
        for(ProductDescription productDescription:productDescriptions){
            SpecialProduct specialProduct = new SpecialProduct();
            specialProduct.setProductDescription(productDescription);
            Special special = specialRepository.findByProduct(productDescription.getProduct());
            specialProduct.setSpecial(special);
            products.add(specialProduct);
        }
        productsByCategory.setProducts(products);
        List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
        for(ProductDescription pd:productDescriptions){
            if(!manufacturers.contains(pd.getProduct().getManufacturer())){
                manufacturers.add(pd.getProduct().getManufacturer());
            }
        }
        productsByCategory.setManufacturers(manufacturers);
        CategoryDescriptionId categoryDescriptionId = new CategoryDescriptionId();
        categoryDescriptionId.setLanguage(language);
        categoryDescriptionId.setCategory(category);
        CategoryDescription thisCategory = categoryDescriptionRepository.findOne(categoryDescriptionId);
        productsByCategory.setThisCategory(thisCategory);
        List<CategoryDescription> childCategories = categoryDescriptionRepositoryDao.findCategoriesByParentId(categoryId, language);
        productsByCategory.setChildCategories(childCategories);
        return productsByCategory;
    }
}
