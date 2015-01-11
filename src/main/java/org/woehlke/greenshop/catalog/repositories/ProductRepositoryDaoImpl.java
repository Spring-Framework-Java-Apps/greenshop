package org.woehlke.greenshop.catalog.repositories;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.catalog.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tw on 11.01.15.
 */
@Repository
public class ProductRepositoryDaoImpl implements ProductRepositoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findByCategoryId(long categoryId) {
        String hql;
        if(categoryId == 0){
            hql = "select p from Product p join fetch p.categories category where p.categories is empty";
            TypedQuery<Product> query = entityManager.createQuery(hql, Product.class);
            return query.getResultList();
        } else {
            hql = "select p from Product p join fetch p.categories category where category.id=:categoryId";
            TypedQuery<Product> query = entityManager.createQuery(hql, Product.class);
            query.setParameter("categoryId",categoryId);
            return query.getResultList();
        }
    }
}
