package org.woehlke.greenshop.oodm.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.cart.entities.CustomersBasketAttribute;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

public interface CustomersBasketAttributeRepository extends
		JpaRepository<CustomersBasketAttribute, Long> {

	List<CustomersBasketAttribute> findByCustomer(Customer customer);
}
