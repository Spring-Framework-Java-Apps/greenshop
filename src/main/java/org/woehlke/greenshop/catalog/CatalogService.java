package org.woehlke.greenshop.catalog;

import java.util.List;


import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.Manufacturers;
import org.woehlke.greenshop.catalog.model.ProductAttributes;
import org.woehlke.greenshop.catalog.model.ProductsByCategory;
import org.woehlke.greenshop.catalog.model.ProductsByManufacturer;


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
}
