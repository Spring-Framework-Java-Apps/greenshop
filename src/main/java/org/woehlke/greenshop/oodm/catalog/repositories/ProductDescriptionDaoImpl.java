package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tw on 09.01.15.
 */
@Repository
public class ProductDescriptionDaoImpl implements ProductDescriptionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductDescription update(ProductDescription productDescription) {
        productDescription = entityManager.merge(productDescription);
        entityManager.flush();
        entityManager.close();
        return productDescription;
    }
}
