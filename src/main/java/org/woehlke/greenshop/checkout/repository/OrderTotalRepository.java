package org.woehlke.greenshop.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.entities.OrderTotal;

import java.util.List;

public interface OrderTotalRepository extends JpaRepository<OrderTotal, Long> {

	OrderTotal findByOrderAndTotalClass(Order order, String string);

	List<OrderTotal> findByOrder(Order order);

}
