package org.woehlke.greenshop.customer;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Product;
import org.woehlke.greenshop.catalog.model.CategoriesBean;
import org.woehlke.greenshop.customer.entities.*;
import org.woehlke.greenshop.customer.model.CreateNewCustomerFormBean;
import org.woehlke.greenshop.customer.model.ProductNotificationBean;

public interface CustomerService extends UserDetailsService {
	
	List<Country> findAllCountriesOrderByName();

	void createNewCustomer(CreateNewCustomerFormBean createNewCustomerFormBean);

	Customer findCustomerByEmail(String string);

	void deleteCustomer(Customer c);

	void updateCustomer(Customer customer);

	List<AddressBook> findAddressBookForCustomer(Customer customer);

	AddressBook findAddressById(long addressId);

	Country findCountryById(long countryId);

	void updateAddressBook(AddressBook persistentAddress);

	void deleteAddress(AddressBook customersAddress);

	void addAddress(AddressBook transientAddress);

	CustomerInfo findCustomerInfoByCustomer(Customer customer);

	void updateCustomerInfo(CustomerInfo myCustomerInfo);

	List<ProductNotificationBean> findAllProductNotificationsForCustomer(Customer customer, Language language);

	void addProductNotification(Product product, Customer customer);

	void updateProductNotifications(Customer customer, long[] productNotification);

	List<Zone> findAllZones();

	Zone findZoneById(long zoneId);
}
