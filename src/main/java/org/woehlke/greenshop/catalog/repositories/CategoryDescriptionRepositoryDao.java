package org.woehlke.greenshop.catalog.repositories;

import java.util.List;

import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.Language;

public interface CategoryDescriptionRepositoryDao {

	List<CategoryDescription> findRootCategories(Language language);
	List<CategoryDescription> findCategoriesByParentId(long parentId, Language language);
	CategoryDescription findByCategoryId(long categoryId, Language language);
}
