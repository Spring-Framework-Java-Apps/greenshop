package org.woehlke.greenshop.oodm.catalog.repositories;

import org.woehlke.greenshop.oodm.catalog.entities.Product;

import java.util.List;

/**
 * Created by tw on 11.01.15.
 */
public interface ProductRepositoryDao {
    List<Product> findByCategoryId(long categoryId);
}
