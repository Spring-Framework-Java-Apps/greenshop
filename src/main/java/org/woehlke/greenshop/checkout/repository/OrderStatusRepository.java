package org.woehlke.greenshop.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.checkout.entities.OrderStatus;
import org.woehlke.greenshop.checkout.entities.OrderStatusId;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,OrderStatusId> {

}
