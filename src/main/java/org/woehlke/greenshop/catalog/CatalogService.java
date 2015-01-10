package org.woehlke.greenshop.catalog;

import java.util.List;


import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;


public interface CatalogService {
	
	Language findLanguageByCode(String code);
	
	List<SpecialProduct> recommenderNewProducts(Language language);
	
	Manufacturers findManufacturers();
	
	Manufacturer findManufacturerById(Long manufacturerId);
	
	ProductsByManufacturer findProductsByManufacturer(
			Manufacturer manufacturer, Language language);
	
	ProductsByManufacturer findProductsByManufacturerAndCategory(
			Manufacturer manufacturer, long categoryId, Language language);

	ProductDescription findProductById(long productId, Language language);

	SpecialProduct findSpecialProductById(long productId, Language language);
	
	ProductAttributes findProductOptionsByProduct(ProductDescription product);
	
	CategoryTree getCategoriesTree(long categoryId,Language language);
	
	CategoryTree getNumberOfProductsPerCategory(CategoryTree tree);
	
	ProductsByCategory getProductsByCategory(long categoryId,Language language);
	
	ProductsByCategory getProductsByCategoryAndManufacturer(long categoryId,
			long manufacturerId, Language language);

	ManufacturerInfo findManufacturerInfo(long manufacturerId, Language language);

	ManufacturerInfo clickManufacturerUrl(ManufacturerInfo manufacturerInfo);

	ReviewDescription saveReview(WriteReviewBean writeReviewBean, Product product, Customer customer, Language language);

	List<ReviewDescription> findReviewsForProduct(ProductDescription productDescription);

	ReviewDescription findReviewById(long reviewId, Language language);

	void update(Review review);

	ReviewDescription getRandomReview(Language language);

	SpecialProduct getRandomSpecial(Language language);

	List<SpecialProduct> getSpecialProducts(Language language);

	List<ReviewProduct> getAllReviews(Language language);

	List<ProductImage> findProductImages(Product product);

	int getNumberOfReviewsForProduct(Product product);

	SpecialProduct getRandomNewProduct(Language language);

	CategoriesBean getAllCategories(Language language);

	SpecialProduct viewProduct(SpecialProduct thisProduct);

	CategoryTreeNode findCategoryById(long categoryId, Language language);
}
