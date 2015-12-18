package org.woehlke.greenshop.oodm.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.cart.entities.CustomersBasket;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

public interface CustomersBasketRepository extends JpaRepository<CustomersBasket, Long> {

	CustomersBasket findByCustomerAndProductId(Customer customer,
			String productWithAttributesId);

	List<CustomersBasket> findByCustomer(Customer customer);
	

}
