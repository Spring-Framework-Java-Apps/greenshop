package org.woehlke.greenshop.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Customer findByEmailAddress(String email);

}
