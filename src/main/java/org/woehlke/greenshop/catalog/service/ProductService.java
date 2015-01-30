package org.woehlke.greenshop.catalog.service;

import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ProductDescription;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface ProductService {

    int countProductsOfThisManufacturer(Manufacturer thisManufacturer);

    List<ProductDescription> findProductsViewed(Language language);

    List<ProductDescription> findProductsByCategoryId(long categoryId, Language language);

    void setProductActive(long productId);

    void setProductInactive(long productId);
}
