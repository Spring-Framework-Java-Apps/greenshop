package org.woehlke.greenshop.catalog.repositories;

import java.util.List;

import org.woehlke.greenshop.catalog.entities.Category;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ProductDescription;

public interface ProductDescriptionRepositoryDao {
	List<ProductDescription> findByLanguage(Language language, int limitation);
	List<ProductDescription> findByManufacturer(Manufacturer manufacturer, Language language);
	ProductDescription findByProductIdAndLanguage(long productId,
			Language language);
	List<ProductDescription> findByCategory(Category thisCategory, Language language);
	List<ProductDescription> findByCategoryAndManufacturer(Category category,
			Manufacturer manufacturer, Language language);
}
