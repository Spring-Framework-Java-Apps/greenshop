package org.woehlke.greenshop.checkout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.entities.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

	List<OrderProduct> findByOrder(Order order);

}
