package org.woehlke.greenshop.catalog.service;

import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.model.CategoriesBean;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.CategoryTreeNode;
import org.woehlke.greenshop.catalog.model.ProductsByCategory;

/**
 * Created by tw on 30.01.15.
 */
public interface CategoryService {

    CategoryTree getCategoriesTree(long categoryId,Language language);

    CategoriesBean getAllCategories(Language language);

    CategoryTreeNode findCategoryById(long categoryId, Language language);

    CategoryTree getNumberOfProductsPerCategory(CategoryTree tree);

    ProductsByCategory getProductsByCategory(long categoryId,Language language);

    ProductsByCategory getProductsByCategoryAndManufacturer(long categoryId,
                                                            long manufacturerId, Language language);

}
