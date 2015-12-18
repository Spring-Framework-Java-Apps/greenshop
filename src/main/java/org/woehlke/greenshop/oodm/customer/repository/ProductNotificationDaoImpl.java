package org.woehlke.greenshop.oodm.customer.repository;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.oodm.customer.entities.ProductNotification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tw on 23.12.14.
 */
@Repository
public class ProductNotificationDaoImpl implements ProductNotificationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductNotification> findAllProductNotificationsForCustomerId(Long customerId) {
        TypedQuery<ProductNotification> query =
                entityManager.createQuery("select p from ProductNotification p where p.id.customerId=:customerId",
                        ProductNotification.class);
        query.setParameter("customerId",customerId);
        return query.getResultList();
    }
}
