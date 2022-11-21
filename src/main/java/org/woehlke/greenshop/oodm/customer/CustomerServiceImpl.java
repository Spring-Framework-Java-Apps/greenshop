package org.woehlke.greenshop.oodm.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.Product;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescriptionId;
import org.woehlke.greenshop.oodm.catalog.repositories.ProductDescriptionRepository;
import org.woehlke.greenshop.oodm.catalog.repositories.ProductRepository;
import org.woehlke.greenshop.oodm.catalog.repositories.ReviewRepository;
import org.woehlke.greenshop.oodm.customer.entities.*;
import org.woehlke.greenshop.oodm.customer.model.CreateNewCustomerFormBean;
import org.woehlke.greenshop.oodm.customer.model.CustomerBean;
import org.woehlke.greenshop.oodm.customer.model.ProductNotificationBean;
import org.woehlke.greenshop.oodm.customer.model.UserDetailsBean;
import org.woehlke.greenshop.oodm.customer.repository.*;

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
	private ProductNotificationRepository productNotificationRepository;

	@Inject
	private ProductNotificationDao productNotificationDao;

	@Inject
	private ProductRepository productRepository;

	@Inject
	private ProductDescriptionRepository productDescriptionRepository;

    @Inject
    private ReviewRepository reviewRepository;

	@Inject
	private PasswordEncoder encoder;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void createNewCustomer(
			CreateNewCustomerFormBean createNewCustomerFormBean) {
		Country country = countryRepository.getOne(createNewCustomerFormBean.getCountry());
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
		myCustomerInfo.incNumberOfLogons();
		myCustomerInfo.setLastLogin(new Date());
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
		String codedPassword = encoder.encode(createNewCustomerFormBean.getPassword());
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
		customerInfoRepository.deleteById(c.getId());
		customerRepository.delete(c);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmailAddress(username);
		if(customer == null) throw new UsernameNotFoundException(username);
		CustomerInfo info = customerInfoRepository.getOne(customer.getId());
		info.setLastLogin(new Date());
		info.incNumberOfLogons();
		customerInfoRepository.save(info);
		return new UserDetailsBean(customer);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void updateCustomer(Customer customer) {
		CustomerInfo info = customerInfoRepository.getOne(customer.getId());
		info.setAccountLastModified(new Date());
		customerInfoRepository.save(info);
		customer=customerRepository.save(customer);
	}

	@Override
	public List<AddressBook> findAddressBookForCustomer(Customer customer) {
		return addressBookRepository.findByCustomer(customer);
	}

	@Override
	public AddressBook findAddressById(long addressId) {
		return addressBookRepository.getOne(addressId);
	}


	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void updateAddressBook(AddressBook persistentAddress) {
		persistentAddress=addressBookRepository.saveAndFlush(persistentAddress);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void deleteAddress(AddressBook customersAddress) {
		addressBookRepository.deleteById(customersAddress.getId());
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void addAddress(AddressBook transientAddress) {
		transientAddress=addressBookRepository.saveAndFlush(transientAddress);	
	}

	@Override
	public CustomerInfo findCustomerInfoByCustomer(Customer customer) {
		return customerInfoRepository.getOne(customer.getId());
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
			Product product = productRepository.getOne(notification.getId().getProductId());
			ProductDescriptionId id = new ProductDescriptionId();
			id.setLanguage(language);
			id.setProduct(product);
			ProductDescription productDescription=productDescriptionRepository.getOne(id);
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
		ProductNotification notification = productNotificationRepository.getOne(id);
		if (notification == null){
			notification = new ProductNotification();
			notification.setId(id);
		}
		notification.setDateAdded(new Date());
		productNotificationRepository.save(notification);
		CustomerInfo info = customerInfoRepository.getOne(customer.getId());
		info.setAccountLastModified(new Date());
		customerInfoRepository.save(info);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void updateProductNotifications(Customer customer, long[] productNotification) {
		boolean changed = false;
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
				changed = true;
			}
		}
		if(changed){
			CustomerInfo info = customerInfoRepository.getOne(customer.getId());
			info.setAccountLastModified(new Date());
			customerInfoRepository.save(info);
		}
	}



    @Override
    public List<CustomerBean> findAllCustomers() {
        List<CustomerBean> customerBeans = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer:customers){
            CustomerBean customerBean = new CustomerBean();
            customerBean.setCustomer(customer);
            CustomerInfo info = customerInfoRepository.getOne(customer.getId());
            customerBean.setCustomerInfo(info);
            customerBeans.add(customerBean);
        }
        return customerBeans;
    }

    @Override
    public int getNumberOfReviewsForCustomer(Customer customer) {
        return reviewRepository.findByCustomersId(customer.getId()).size();
    }

    @Override
    public CustomerBean getCustomerById(long customerId) {
        Customer customer = customerRepository.getOne(customerId);
        CustomerBean customerBean = new CustomerBean();
        customerBean.setCustomer(customer);
        CustomerInfo info = customerInfoRepository.getOne(customer.getId());
        customerBean.setCustomerInfo(info);
        return customerBean;
    }
}
