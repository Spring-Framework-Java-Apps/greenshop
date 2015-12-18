package org.woehlke.greenshop.oodm.customer.repository;

import org.woehlke.greenshop.oodm.customer.entities.ProductNotification;

import java.util.List;

/**
 * Created by tw on 23.12.14.
 */
public interface ProductNotificationDao {
    List<ProductNotification> findAllProductNotificationsForCustomerId(Long customerId);
}
