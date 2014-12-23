package org.woehlke.greenshop.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.customer.entities.ProductNotification;
import org.woehlke.greenshop.customer.entities.ProductNotificationId;

/**
 * Created by tw on 23.12.14.
 */
public interface ProductNotificationRepository extends JpaRepository<ProductNotification,ProductNotificationId> {
}
