package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.Product;
import org.woehlke.greenshop.oodm.catalog.entities.ProductImage;

import java.util.List;

/**
 * Created by tw on 01.01.15.
 */
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
    List<ProductImage> findByProductOrderBySequenceAsc(Product product);
}
