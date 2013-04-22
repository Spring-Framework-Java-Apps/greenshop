package org.woehlke.greenshop.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.customer.entities.AddressBook;
import org.woehlke.greenshop.customer.entities.Customer;

public interface AddressBookRepository extends JpaRepository<AddressBook,Long> {

	List<AddressBook> findByCustomer(Customer c);

}
