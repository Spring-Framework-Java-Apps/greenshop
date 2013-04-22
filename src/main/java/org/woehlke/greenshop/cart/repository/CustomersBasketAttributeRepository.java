package org.woehlke.greenshop.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.cart.entities.CustomersBasketAttribute;
import org.woehlke.greenshop.customer.entities.Customer;

public interface CustomersBasketAttributeRepository extends
		JpaRepository<CustomersBasketAttribute, Long> {

	List<CustomersBasketAttribute> findByCustomer(Customer customer);
}
