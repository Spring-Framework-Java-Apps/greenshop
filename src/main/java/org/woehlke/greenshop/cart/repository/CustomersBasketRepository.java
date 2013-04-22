package org.woehlke.greenshop.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.cart.entities.CustomersBasket;
import org.woehlke.greenshop.customer.entities.Customer;

public interface CustomersBasketRepository extends JpaRepository<CustomersBasket, Long> {

	CustomersBasket findByCustomerAndProductId(Customer customer,
			String productWithAttributesId);

	List<CustomersBasket> findByCustomer(Customer customer);
	

}
