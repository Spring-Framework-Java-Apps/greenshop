package org.woehlke.greenshop.oodm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.customer.entities.ProductNotification;
import org.woehlke.greenshop.oodm.customer.entities.ProductNotificationId;

/**
 * Created by tw on 23.12.14.
 */
public interface ProductNotificationRepository extends JpaRepository<ProductNotification,ProductNotificationId> {
}
