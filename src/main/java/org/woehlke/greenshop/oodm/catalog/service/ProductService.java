package org.woehlke.greenshop.oodm.catalog.service;

import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.Manufacturer;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.model.ProductsByManufacturer;
import org.woehlke.greenshop.oodm.catalog.model.SpecialProduct;

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

    ProductDescription findProductById(long productId, Language language);

    List<SpecialProduct> recommenderNewProducts(Language language);

    SpecialProduct getRandomNewProduct(Language language);

    SpecialProduct viewProduct(SpecialProduct thisProduct);

    ProductsByManufacturer findProductsByManufacturer(
            Manufacturer manufacturer, Language language);

    ProductsByManufacturer findProductsByManufacturerAndCategory(
            Manufacturer manufacturer, long categoryId, Language language);
}
