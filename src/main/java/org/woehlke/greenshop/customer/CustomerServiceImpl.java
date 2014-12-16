package org.woehlke.greenshop.customer;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.customer.entities.AddressBook;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.entities.Zone;
import org.woehlke.greenshop.customer.model.CreateNewCustomerFormBean;
import org.woehlke.greenshop.customer.model.UserDetailsBean;
import org.woehlke.greenshop.customer.repository.AddressBookRepository;
import org.woehlke.greenshop.customer.repository.AddressFormatRepository;
import org.woehlke.greenshop.customer.repository.CountryRepository;
import org.woehlke.greenshop.customer.repository.CustomerRepository;
import org.woehlke.greenshop.customer.repository.ZoneRepository;

@Named("customerService")
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Inject
	private CountryRepository countryRepository;

	@Inject
	private AddressBookRepository addressBookRepository;
	
	@Inject
	private CustomerRepository customerRepository;
	
	@Inject
	private ZoneRepository zoneRepository;
	
	@Inject
	private AddressFormatRepository addressFormatRepository;
	
	@Override
	public List<Country> findAllCountriesOrderByName() {
		Sort sort = new Sort("name");
		return countryRepository.findAll(sort);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void createNewCustomer(
			CreateNewCustomerFormBean createNewCustomerFormBean) {
		Country country = countryRepository.findOne(createNewCustomerFormBean.getCountry());
		List<Zone> zones = zoneRepository.findByCountry(country);
		AddressBook defaultAddress = createNewCustomerFormBean2AddressBook(createNewCustomerFormBean);
		//set Customer and Zone to addressBook
		Customer customer = createNewCustomerFormBean2Customer(createNewCustomerFormBean);
		defaultAddress.setCountry(country);
		customer.setDefaultAddress(defaultAddress);
		defaultAddress.setCustomer(customer);
		customer=customerRepository.save(customer);
		defaultAddress=addressBookRepository.save(defaultAddress);
	}
	
	private AddressBook createNewCustomerFormBean2AddressBook(CreateNewCustomerFormBean createNewCustomerFormBean){
		AddressBook addressBook = new AddressBook();
		addressBook.setCity(createNewCustomerFormBean.getCity());
		addressBook.setCompany(createNewCustomerFormBean.getCompany());
		addressBook.setFirstname(createNewCustomerFormBean.getFirstname());
		addressBook.setGender(createNewCustomerFormBean.getGender());
		addressBook.setLastname(createNewCustomerFormBean.getLastname());
		addressBook.setPostcode(createNewCustomerFormBean.getPostcode());
		addressBook.setState(createNewCustomerFormBean.getState());
		addressBook.setStreetAddress(createNewCustomerFormBean.getStreetAddress());
		addressBook.setSuburb(createNewCustomerFormBean.getSuburb());
		return addressBook;
	}

	
	private Customer createNewCustomerFormBean2Customer(CreateNewCustomerFormBean createNewCustomerFormBean){
		Customer customer = new Customer();
		Date dob = new Date(createNewCustomerFormBean.getDob());
		customer.setDob(dob);
		customer.setEmailAddress(createNewCustomerFormBean.getEmailAddress());
		customer.setFax(createNewCustomerFormBean.getFax());
		customer.setFirstname(createNewCustomerFormBean.getFirstname());
		customer.setGender(createNewCustomerFormBean.getGender());
		customer.setLastname(createNewCustomerFormBean.getLastname());
		customer.setNewsletter(createNewCustomerFormBean.getNewsletter());
		//TODO: password encryption like in PHP
		PasswordEncoder encoder = new Md5PasswordEncoder();
		String codedPassword = encoder.encodePassword(createNewCustomerFormBean.getPassword(),null);
		customer.setPassword(codedPassword);
		customer.setTelephone(createNewCustomerFormBean.getTelephone());
		return customer;
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return customerRepository.findByEmailAddress(email);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void deleteCustomer(Customer c) {
		List<AddressBook> addresses = addressBookRepository.findByCustomer(c);
		for(AddressBook a:addresses){
			addressBookRepository.delete(a);
		}
		customerRepository.delete(c);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmailAddress(username);
		if(customer == null) throw new UsernameNotFoundException(username);
		return new UserDetailsBean(customer);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void updateCustomer(Customer customer) {
		customer=customerRepository.saveAndFlush(customer);
	}

	@Override
	public List<AddressBook> findAddressBookForCustomer(Customer customer) {
		return addressBookRepository.findByCustomer(customer);
	}

	@Override
	public AddressBook findAddressById(long addressId) {
		return addressBookRepository.findOne(addressId);
	}

	@Override
	public Country findCountryById(long countryId) {
		return countryRepository.findOne(countryId);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void updateAddressBook(AddressBook persistentAddress) {
		persistentAddress=addressBookRepository.saveAndFlush(persistentAddress);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void deleteAddress(AddressBook customersAddress) {
		addressBookRepository.delete(customersAddress.getId());	
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void addAddress(AddressBook transientAddress) {
		transientAddress=addressBookRepository.saveAndFlush(transientAddress);	
	}
}
