package org.woehlke.greenshop.customer.repository;

import org.woehlke.greenshop.customer.entities.ProductNotification;

import java.util.List;

/**
 * Created by tw on 23.12.14.
 */
public interface ProductNotificationDao {
    List<ProductNotification> findAllProductNotificationsForCustomerId(Long customerId);
}
