package org.woehlke.greenshop.customer;

import java.util.ArrayList;
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
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Product;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ProductDescriptionId;
import org.woehlke.greenshop.catalog.model.CategoriesBean;
import org.woehlke.greenshop.catalog.repositories.ProductDescriptionRepository;
import org.woehlke.greenshop.catalog.repositories.ProductRepository;
import org.woehlke.greenshop.customer.entities.*;
import org.woehlke.greenshop.customer.model.CreateNewCustomerFormBean;
import org.woehlke.greenshop.customer.model.ProductNotificationBean;
import org.woehlke.greenshop.customer.model.UserDetailsBean;
import org.woehlke.greenshop.customer.repository.*;

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
	private CustomerInfoRepository customerInfoRepository;
	
	@Inject
	private ZoneRepository zoneRepository;
	
	@Inject
	private AddressFormatRepository addressFormatRepository;

	@Inject
	private ProductNotificationRepository productNotificationRepository;

	@Inject
	private ProductNotificationDao productNotificationDao;

	@Inject
	private ProductRepository productRepository;

	@Inject
	private ProductDescriptionRepository productDescriptionRepository;
	
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
		CustomerInfo myCustomerInfo = new CustomerInfo();
		myCustomerInfo.setId(customer.getId());
		myCustomerInfo.setAccountCreated(new Date());
		customerInfoRepository.save(myCustomerInfo);
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

	@Override
	public CustomerInfo findCustomerInfoByCustomer(Customer customer) {
		return customerInfoRepository.findOne(customer.getId());
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void updateCustomerInfo(CustomerInfo myCustomerInfo) {
		customerInfoRepository.save(myCustomerInfo);
	}

	@Override
	public List<ProductNotificationBean> findAllProductNotificationsForCustomer(Customer customer,Language language) {
		List<ProductNotification> notifications = productNotificationDao.findAllProductNotificationsForCustomerId(customer.getId());
		List<ProductNotificationBean> notificationBeans = new ArrayList<ProductNotificationBean>();
		for(ProductNotification notification:notifications){
			Product product = productRepository.findOne(notification.getId().getProductId());
			ProductDescriptionId id = new ProductDescriptionId();
			id.setLanguage(language);
			id.setProduct(product);
			ProductDescription productDescription=productDescriptionRepository.findOne(id);
			ProductNotificationBean bean = new ProductNotificationBean();
			bean.setProductId(notification.getId().getProductId());
			bean.setProductName(productDescription.getName());
			notificationBeans.add(bean);
		}
		return notificationBeans;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void addProductNotification(Product product, Customer customer) {
		ProductNotificationId id = new ProductNotificationId();
		id.setCustomerId(customer.getId());
		id.setProductId(product.getId());
		ProductNotification notification = productNotificationRepository.findOne(id);
		if (notification == null){
			notification = new ProductNotification();
			notification.setId(id);
		}
		notification.setDateAdded(new Date());
		productNotificationRepository.save(notification);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void updateProductNotifications(Customer customer, long[] productNotification) {
		List<Long> choosenProducts = new ArrayList<Long>();
		if(productNotification!=null && productNotification.length>0) {
			for (long id : productNotification) {
					choosenProducts.add(id);
			}
		}
		List<ProductNotification> notifications = productNotificationDao.findAllProductNotificationsForCustomerId(customer.getId());
		for(ProductNotification notification:notifications){
		 	Long productId = notification.getId().getProductId();
			if(!choosenProducts.contains(productId)){
				productNotificationRepository.delete(notification);
			}
		}
	}

	@Override
	public List<Zone> findAllZones() {
		return zoneRepository.findAll();
	}

	@Override
	public Zone findZoneById(long zoneId) {
		return zoneRepository.findOne(zoneId);
	}
}
