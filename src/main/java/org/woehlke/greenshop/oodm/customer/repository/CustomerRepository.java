package org.woehlke.greenshop.oodm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Customer findByEmailAddress(String email);

}
