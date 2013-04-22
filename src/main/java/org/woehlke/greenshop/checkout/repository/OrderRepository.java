package org.woehlke.greenshop.checkout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.customer.entities.Customer;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByCustomer(Customer customer);

}
