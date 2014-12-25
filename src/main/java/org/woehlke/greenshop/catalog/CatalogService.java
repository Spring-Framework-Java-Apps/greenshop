package org.woehlke.greenshop.catalog;

import java.util.List;


import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.customer.entities.Customer;


public interface CatalogService {
	
	Language findLanguageByCode(String code);
	
	List<ProductDescription> recommenderNewProducts(Language language);
	
	Manufacturers findManufacturers();
	
	Manufacturer findManufacturerById(Long manufacturerId);
	
	ProductsByManufacturer findProductsByManufacturer(
			Manufacturer manufacturer, Language language);
	
	ProductsByManufacturer findProductsByManufacturerAndCategory(
			Manufacturer manufacturer, long categoryId, Language language);
	
	ProductDescription findProductById(long productId, Language language);
	
	ProductAttributes findProductOptionsByProduct(ProductDescription product);
	
	CategoryTree getCategoriesTree(long categoryId,Language language);
	
	CategoryTree getNumberOfProductsPerCategory(CategoryTree tree);
	
	ProductsByCategory getProductsByCategory(long categoryId,Language language);
	
	ProductsByCategory getProductsByCategoryAndManufacturer(long categoryId,
			long manufacturerId, Language language);

	ManufacturerInfo findManufacturerInfo(long manufacturerId, Language language);

	ManufacturerInfo clickManufacturerUrl(ManufacturerInfo manufacturerInfo);

	ReviewDescription saveReview(WriteReviewBean writeReviewBean, Product product, Customer customer, Language language);
}
