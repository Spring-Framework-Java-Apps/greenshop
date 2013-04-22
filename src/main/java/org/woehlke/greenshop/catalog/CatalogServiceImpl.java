package org.woehlke.greenshop.catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Sort;
import org.woehlke.greenshop.catalog.entities.Category;
import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.CategoryDescriptionId;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ProductAttribute;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ProductOption;
import org.woehlke.greenshop.catalog.entities.ProductOptionId;
import org.woehlke.greenshop.catalog.entities.ProductOptionValue;
import org.woehlke.greenshop.catalog.entities.ProductOptionValueId;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.CategoryTreeNode;
import org.woehlke.greenshop.catalog.model.Manufacturers;
import org.woehlke.greenshop.catalog.model.ProductAttributes;
import org.woehlke.greenshop.catalog.model.ProductOptionAttribute;
import org.woehlke.greenshop.catalog.model.ProductsByCategory;
import org.woehlke.greenshop.catalog.model.ProductsByManufacturer;
import org.woehlke.greenshop.catalog.repositories.CategoryDescriptionRepository;
import org.woehlke.greenshop.catalog.repositories.CategoryDescriptionRepositoryDao;
import org.woehlke.greenshop.catalog.repositories.CategoryRepository;
import org.woehlke.greenshop.catalog.repositories.LanguageRepository;
import org.woehlke.greenshop.catalog.repositories.ManufacturerRepository;
import org.woehlke.greenshop.catalog.repositories.ProductAttributeRepository;
import org.woehlke.greenshop.catalog.repositories.ProductDescriptionRepository;
import org.woehlke.greenshop.catalog.repositories.ProductDescriptionRepositoryDao;
import org.woehlke.greenshop.catalog.repositories.ProductOptionRepository;
import org.woehlke.greenshop.catalog.repositories.ProductOptionValueRepository;

@Named
public class CatalogServiceImpl implements CatalogService {

	@Inject
	private ProductDescriptionRepository productDescriptionRepository;
	
	@Inject
	private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;
	
	@Inject
	private LanguageRepository languageRepository;
	
	@Inject
	private ManufacturerRepository manufacturerRepository;
	
	@Inject
	private ProductAttributeRepository productAttributeRepository;
	
	@Inject
	private ProductOptionRepository productOptionRepository;
	
	@Inject
	private ProductOptionValueRepository productOptionValueRepository;
	
	@Inject
	private CategoryDescriptionRepository categoryDescriptionRepository;
	
	@Inject
	private CategoryDescriptionRepositoryDao categoryDescriptionRepositoryDao;
	
	@Inject
	private CategoryRepository categoryRepository;
	
	@Override
	public List<ProductDescription> recommenderNewProducts(Language language) {
		int limit = 9;
		return productDescriptionRepositoryDao.findByLanguage(language,limit);
	}

	@Override
	public Language findLanguageByCode(String code) {
		return languageRepository.findByCode(code);
	}

	@Override
	public Manufacturers findManufacturers() {
		Sort sort = new Sort(Sort.Direction.ASC,"name");
		List<Manufacturer> manufacturers = manufacturerRepository.findAll(sort);
		Manufacturers m = new Manufacturers();
		m.setManufacturers(manufacturers);
		return m;
	}

	@Override
	public Manufacturer findManufacturerById(Long manufacturerId) {
		return manufacturerRepository.findOne(manufacturerId);
	}

	@Override
	public ProductsByManufacturer findProductsByManufacturer(
			Manufacturer manufacturer, Language language) {
		List<ProductDescription> products = productDescriptionRepositoryDao.findByManufacturer(manufacturer, language);
		ProductsByManufacturer productsByManufacturer = new ProductsByManufacturer();
		productsByManufacturer.setProducts(products);
		List<Category> categories = new ArrayList<Category>();
		for(ProductDescription product:products){
			 List<Category> categoriesOfOneProduct = product.getProduct().getCategories();
			 for(Category categoryOfOneProduct:categoriesOfOneProduct){
				 if(!categories.contains(categoryOfOneProduct)){
					 categories.add(categoryOfOneProduct);
				 }
			 }
		}
		List<CategoryDescription> categoriesOfProducts=new ArrayList<CategoryDescription>();
		for(Category category:categories){
			CategoryDescriptionId id = new CategoryDescriptionId();
			id.setCategory(category);
			id.setLanguage(language);
			CategoryDescription cd = categoryDescriptionRepository.findOne(id);
			categoriesOfProducts.add(cd);
		}
		productsByManufacturer.setCategoriesOfProducts(categoriesOfProducts);
		return productsByManufacturer;
	}

	@Override
	public ProductsByManufacturer findProductsByManufacturerAndCategory(
			Manufacturer manufacturer, long categoryId, Language language) {
		Category thisCategory=categoryRepository.findOne(categoryId);
		List<ProductDescription> products = productDescriptionRepositoryDao.findByCategoryAndManufacturer(thisCategory,manufacturer,language);
		ProductsByManufacturer productsByManufacturer = new ProductsByManufacturer();
		productsByManufacturer.setProducts(products);
		List<Category> categories = new ArrayList<Category>();
		for(ProductDescription product:products){
			 List<Category> categoriesOfOneProduct = product.getProduct().getCategories();
			 for(Category categoryOfOneProduct:categoriesOfOneProduct){
				 if(!categories.contains(categoryOfOneProduct)){
					 categories.add(categoryOfOneProduct);
				 }
			 }
		}
		List<CategoryDescription> categoriesOfProducts=new ArrayList<CategoryDescription>();
		for(Category category:categories){
			CategoryDescriptionId id = new CategoryDescriptionId();
			id.setCategory(category);
			id.setLanguage(language);
			CategoryDescription cd = categoryDescriptionRepository.findOne(id);
			categoriesOfProducts.add(cd);
		}
		productsByManufacturer.setCategoriesOfProducts(categoriesOfProducts);
		return productsByManufacturer;
	}
	
	@Override
	public ProductDescription findProductById(long productId, Language language) {
		return productDescriptionRepositoryDao.findByProductIdAndLanguage(productId, language);
	}

	@Override
	public ProductAttributes findProductOptionsByProduct(
			ProductDescription product) {
		Language language = product.getLanguage();
		List<ProductAttribute> listProductAttribute = productAttributeRepository.findByProduct(product.getProduct());
		Map<ProductOption,List<ProductOptionAttribute>> mapProductOptionAttribute = new HashMap<ProductOption,List<ProductOptionAttribute>>();
		for(ProductAttribute pa :listProductAttribute){
			ProductOptionId oid = new ProductOptionId();
			oid.setId(pa.getOptionId());
			oid.setLanguage(language);
			ProductOption po = productOptionRepository.findOne(oid);
			ProductOptionValueId povid = new ProductOptionValueId();
			povid.setId(pa.getValueId());
			povid.setLanguage(language);
			ProductOptionValue pov = productOptionValueRepository.findOne(povid);
			ProductOptionAttribute poa = new ProductOptionAttribute();
			poa.setProductAttribute(pa);
			poa.setProductOption(po);
			poa.setProductOptionValue(pov);
			StringBuilder sb = new StringBuilder();
			sb.append(pov.getName());
			if(pa.getPrice()!=0.0){
				sb.append(" (");
				sb.append(pa.getPricePrefix());
				sb.append(pa.getPrice());
				sb.append(")");
			}
			poa.setOptionValue(sb.toString());
			if(mapProductOptionAttribute.containsKey(po)){
				List<ProductOptionAttribute> mapList = mapProductOptionAttribute.get(po);
				mapList.add(poa);
				mapProductOptionAttribute.remove(po);
				mapProductOptionAttribute.put(po, mapList);
			} else {
				List<ProductOptionAttribute> mapList = new ArrayList<ProductOptionAttribute>();
				mapList.add(poa);
				mapProductOptionAttribute.put(po, mapList);
			}
		}
		ProductAttributes productAttributes = new ProductAttributes();
		productAttributes.setProductDescription(product);
		productAttributes.setMapProductOptionAttribute(mapProductOptionAttribute);
		return productAttributes;
	}

	public CategoryTree getCategoriesTree(long categoryId,Language language){
		CategoryTree categoryTree = new CategoryTree();
		categoryTree.setCategoryId(categoryId);
		categoryTree = getNumberOfProductsPerCategory(categoryTree);
		if(categoryId==0L){
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
	
	public ProductsByCategory getProductsByCategory(long categoryId,Language language){
		ProductsByCategory productsByCategory = new ProductsByCategory();
		Category category = categoryRepository.findOne(categoryId);
		List<ProductDescription> productDescriptions=productDescriptionRepositoryDao.findByCategory(category,language);
		productsByCategory.setProductDescriptions(productDescriptions);
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
	public ProductsByCategory getProductsByCategoryAndManufacturer(
			long categoryId, long manufacturerId, Language language) {
		ProductsByCategory productsByCategory = new ProductsByCategory();
		productsByCategory.setManufacturerId(manufacturerId);
		Category category = categoryRepository.findOne(categoryId);
		Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
		List<ProductDescription> productDescriptions=productDescriptionRepositoryDao.findByCategoryAndManufacturer(category,manufacturer,language);
		productsByCategory.setProductDescriptions(productDescriptions);
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
