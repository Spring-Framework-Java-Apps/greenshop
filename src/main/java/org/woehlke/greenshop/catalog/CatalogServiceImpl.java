package org.woehlke.greenshop.catalog;

import java.util.*;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.catalog.repositories.*;
import org.woehlke.greenshop.customer.entities.Customer;

@Named
@Transactional(readOnly=true,propagation= Propagation.REQUIRED)
public class CatalogServiceImpl implements CatalogService {

	@Inject
	private ProductDescriptionRepository productDescriptionRepository;

	@Inject
	private ProductDescriptionDao productDescriptionDao;
	
	@Inject
	private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;
	
	@Inject
	private LanguageRepository languageRepository;
	
	@Inject
	private ManufacturerRepository manufacturerRepository;

	@Inject
	private ManufacturerInfoRepository manufacturerInfoRepository;

	@Inject
	private ManufacturerInfoDao manufacturerInfoDao;
	
	@Inject
	private ProductAttributeRepository productAttributeRepository;
	
	@Inject
	private ProductOptionRepository productOptionRepository;
	
	@Inject
	private ProductOptionValueRepository productOptionValueRepository;

	@Inject
	private ProductImageRepository productImageRepository;

	@Inject
	private CategoryDescriptionRepository categoryDescriptionRepository;
	
	@Inject
	private CategoryDescriptionRepositoryDao categoryDescriptionRepositoryDao;
	
	@Inject
	private CategoryRepository categoryRepository;

	@Inject
	private ReviewRepository reviewRepository;

	@Inject
	private ReviewDescriptionRepository reviewDescriptionRepository;

	@Inject
	private ReviewDescriptionDao reviewDescriptionDao;

	@Inject
	private SpecialRepository specialRepository;
	
	@Override
	public List<SpecialProduct> recommenderNewProducts(Language language) {
		int limit = 9;
		List<SpecialProduct> newProducts = new ArrayList<SpecialProduct>();
		List<ProductDescription> productDescriptions =
				productDescriptionRepositoryDao.findByLanguageOrderByDateAdded(language, limit);
		for(ProductDescription productDescription : productDescriptions){
			SpecialProduct newProduct = new SpecialProduct();
			newProduct.setProductDescription(productDescription);
			Special special = specialRepository.findByProduct(productDescription.getProduct());
			newProduct.setSpecial(special);
			newProducts.add(newProduct);
		}
		return newProducts;
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
	public SpecialProduct findSpecialProductById(long productId, Language language) {
		ProductDescription productDescription =
				productDescriptionRepositoryDao.findByProductIdAndLanguage(productId, language);
		Special special = specialRepository.findByProduct(productDescription.getProduct());
		SpecialProduct specialProduct = new SpecialProduct();
		specialProduct.setProductDescription(productDescription);
		specialProduct.setSpecial(special);
		return specialProduct;
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
	public ManufacturerInfo findManufacturerInfo(long manufacturerId, Language language) {
		Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
		ManufacturerInfoId manufacturerInfoId = new ManufacturerInfoId();
		manufacturerInfoId.setLanguage(language);
		manufacturerInfoId.setManufacturer(manufacturer);
		return manufacturerInfoRepository.findOne(manufacturerInfoId);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public ManufacturerInfo clickManufacturerUrl(ManufacturerInfo manufacturerInfo) {
		manufacturerInfo.addClick();
		return manufacturerInfoDao.update(manufacturerInfo);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public ReviewDescription saveReview(WriteReviewBean writeReviewBean,
										Product product, Customer customer, Language language) {
		language=languageRepository.findOne(language.getId());
		ReviewDescription reviewDescription = new ReviewDescription();
		Review review = new Review();
		if(customer==null){
			review.setCustomersId(0L);
		} else {
			review.setCustomersId(customer.getId());
		}
		review.setProduct(product);
		review.setCustomersName(customer.getFirstname()+" "+customer.getLastname());
		review.setDateAdded(new Date());
		review.setRating(writeReviewBean.getRating());
		review.setStatus(1);
		review.setReviewsRead(0);
		review=reviewRepository.save(review);
		reviewDescription.setReview(review);
		reviewDescription.setLanguage(language);
		reviewDescription.setReviewText(writeReviewBean.getReviewText());
		reviewDescription=reviewDescriptionDao.create(reviewDescription);
		return reviewDescription;
	}

	@Override
	public List<ReviewDescription> findReviewsForProduct(ProductDescription productDescription) {
		return reviewDescriptionDao.findReviewsForProductAndLanguage(
				productDescription.getProduct(), productDescription.getLanguage());
	}

	@Override
	public ReviewDescription findReviewById(long reviewId, Language language) {
		return reviewDescriptionDao.findReviewsForReviewIdAndLanguage(reviewId, language);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void update(Review review) {
		review=reviewRepository.save(review);
	}

	@Override
	public ReviewDescription getRandomReview(Language language) {
		List<Review> reviews=reviewRepository.findAll();
		int listLength = reviews.size();
		Random random = new Random();
		int index = random.nextInt(listLength);
		Review review = reviews.get(index);
		return reviewDescriptionDao.findReviewsForReviewIdAndLanguage(review.getId(), language);
	}

	@Override
	public SpecialProduct getRandomSpecial(Language language) {
		SpecialProduct specialProduct = new SpecialProduct();
		List<Special> specials = specialRepository.findAll();
		int listLength = specials.size();
		Random random = new Random();
		int index = random.nextInt(listLength);
		Special special = specials.get(index);
		specialProduct.setSpecial(special);
		ProductDescription productDescription =
				productDescriptionRepositoryDao.findByProductIdAndLanguage(
						special.getProduct().getId(),language);
		specialProduct.setProductDescription(productDescription);
		return specialProduct;
	}

	@Override
	public List<SpecialProduct> getSpecialProducts(Language language) {
		List<SpecialProduct> specialProducts = new ArrayList<SpecialProduct>();
		List<Special> specials = specialRepository.findAll();
		for(Special special:specials){
			SpecialProduct specialProduct = new SpecialProduct();
			specialProduct.setSpecial(special);
			ProductDescription productDescription =
					productDescriptionRepositoryDao.findByProductIdAndLanguage(
							special.getProduct().getId(),language);
			specialProduct.setProductDescription(productDescription);
			specialProducts.add(specialProduct);
		}
		return specialProducts;
	}

	@Override
	public List<ReviewProduct> getAllReviews(Language language) {
		List<ReviewProduct> reviews = new ArrayList<ReviewProduct>();
		List<ReviewDescription> reviewDescriptions =
				reviewDescriptionRepository.findByLanguage(language);
		for(ReviewDescription reviewDescription:reviewDescriptions){
			ReviewProduct review = new ReviewProduct();
			review.setReview(reviewDescription);
			ProductDescription productDescription =
					productDescriptionRepositoryDao.findByProductIdAndLanguage(
							reviewDescription.getReview().getProduct().getId(),language);
			review.setProduct(productDescription);
			reviews.add(review);
		}
		return reviews;
	}

	@Override
	public List<ProductImage> findProductImages(Product product) {
		return productImageRepository.findByProductOrderBySequenceAsc(product);
	}

	@Override
	public int getNumberOfReviewsForProduct(Product product) {
		List<Review> reviews = reviewRepository.findByProduct(product);
		return reviews.size();
	}

	@Override
	public SpecialProduct getRandomNewProduct(Language language) {
		int limit = 100;
		SpecialProduct newProduct = new SpecialProduct();
		List<ProductDescription> productDescriptions =
				productDescriptionRepositoryDao.findByLanguageOrderByDateAdded(language, limit);
		int listLength = productDescriptions.size();
		Random random = new Random();
		int index = random.nextInt(listLength);
		ProductDescription productDescription = productDescriptions.get(index);
		newProduct.setProductDescription(productDescription);
		Special special = specialRepository.findByProduct(productDescription.getProduct());
		newProduct.setSpecial(special);
		return newProduct;
	}

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

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public SpecialProduct viewProduct(SpecialProduct thisProduct) {
		ProductDescription productDescription = thisProduct.getProductDescription();
		productDescription.incViewed();
		productDescription = productDescriptionDao.update(productDescription);
		thisProduct.setProductDescription(productDescription);
		return thisProduct;
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

}
