package org.woehlke.greenshop.checkout;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.cart.entities.CustomersBasket;
import org.woehlke.greenshop.cart.entities.CustomersBasketAttribute;
import org.woehlke.greenshop.cart.model.TransientBasket;
import org.woehlke.greenshop.cart.model.TransientProduct;
import org.woehlke.greenshop.cart.repository.CustomersBasketAttributeRepository;
import org.woehlke.greenshop.cart.repository.CustomersBasketRepository;
import org.woehlke.greenshop.catalog.model.ProductOptionAttribute;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.entities.OrderProduct;
import org.woehlke.greenshop.checkout.entities.OrderProductAttribute;
import org.woehlke.greenshop.checkout.entities.OrderStatusHistory;
import org.woehlke.greenshop.checkout.entities.OrderTotal;
import org.woehlke.greenshop.checkout.model.AddressBean;
import org.woehlke.greenshop.checkout.model.CheckoutBean;
import org.woehlke.greenshop.checkout.repository.OrderProductAttributeRepository;
import org.woehlke.greenshop.checkout.repository.OrderProductRepository;
import org.woehlke.greenshop.checkout.repository.OrderRepository;
import org.woehlke.greenshop.checkout.repository.OrderStatusHistoryRepository;
import org.woehlke.greenshop.checkout.repository.OrderTotalRepository;
import org.woehlke.greenshop.customer.entities.AddressBook;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.repository.CountryRepository;

@Named("checkoutService")
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class CheckoutServiceImpl implements CheckoutService {

	private static final Logger logger = LoggerFactory.getLogger(CheckoutServiceImpl.class);
	
	@Inject
	private OrderRepository orderRepository;
	
	@Inject
	private OrderProductRepository orderProductRepository;
	
	@Inject
	private OrderProductAttributeRepository orderProductAttributeRepository;
	
	@Inject
	private CountryRepository countryRepository;
	
	@Inject
	private CustomersBasketAttributeRepository customersBasketAttributeRepository;
	
	@Inject
	private CustomersBasketRepository customersBasketRepository;
	
	@Inject
	private OrderTotalRepository orderTotalRepository;
	
	@Inject
	private OrderStatusHistoryRepository orderStatusHistoryRepository;
	
	public AddressBean transformPersistentAddressToBean(AddressBook choosenAddress){
		AddressBean transientAddress = new AddressBean();
		transientAddress.setCity(choosenAddress.getCity());
		transientAddress.setCountryId(choosenAddress.getCountry().getId());
		transientAddress.setCountryName(choosenAddress.getCountry().getName());
		transientAddress.setFirstname(choosenAddress.getFirstname());
		transientAddress.setGender(choosenAddress.getGender());
		transientAddress.setLastname(choosenAddress.getLastname());
		transientAddress.setPostcode(choosenAddress.getPostcode());
		transientAddress.setState(choosenAddress.getState());
		transientAddress.setStreetAddress(choosenAddress.getStreetAddress());
		transientAddress.setSuburb(choosenAddress.getSuburb());
		return transientAddress;
	}
	
	@Override
	public AddressBook transformBeanToPersistentAddress(
			AddressBean newAddress, 
			Country country, 
			Customer customer) {
		AddressBook a = new AddressBook();
		a.setCity(newAddress.getCity());
		a.setCountry(country);
		a.setCustomer(customer);
		a.setFirstname(newAddress.getFirstname());
		a.setGender(newAddress.getGender());
		a.setLastname(newAddress.getLastname());
		a.setPostcode(newAddress.getPostcode());
		a.setState(newAddress.getState());
		a.setStreetAddress(newAddress.getStreetAddress());
		a.setSuburb(newAddress.getSuburb());
		return a;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void placeOrder(CheckoutBean checkout,
			TransientBasket transientBasket, Customer customer) {
		Order order = new Order();
		this.copyAddressesToOrder(checkout,order,customer);
		order.setCustomer(customer);
		order.setDatePurchased(new Date());
		order.setCustomersEmailAddress(customer.getEmailAddress());
		order.setCustomersTelephone(customer.getTelephone());
		order.setPaymentMethod("TODO paymentMethod");
		order.setOrdersStatus(1);
		order.setCurrency("USD");
		order.setCurrencyValue(1.0d);
		orderRepository.save(order);
		double subtotal = 0.0d;
		for(TransientProduct transientProduct:transientBasket.getTransientProducts()){
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setOrder(order);
			orderProduct.setProduct(transientProduct.getProductDescription().getProduct());
			orderProduct.setProductsModel(transientProduct.getProductDescription().getProduct().getModel());
			orderProduct.setProductsName(transientProduct.getProductDescription().getName());
			orderProduct.setProductsPrice(transientProduct.getProductDescription().getProduct().getPrice());
			orderProduct.setFinalPrice(transientProduct.getPrice());
			double tax = 0.0d; //TODO: Tax
			subtotal += transientProduct.getPrice()*transientBasket.getNumberOfProducts().get(transientProduct);
			orderProduct.setProductsQuantity(transientBasket.getNumberOfProducts().get(transientProduct));
			orderProduct.setProductsTax(tax); 
			orderProductRepository.save(orderProduct);
			for(ProductOptionAttribute productOptionAttribute :transientProduct.getProductOptionAttributeList()){
				OrderProductAttribute orderProductAttribute = new OrderProductAttribute();
				orderProductAttribute.setOrder(order);
				orderProductAttribute.setOrderProduct(orderProduct);
				orderProductAttribute.setOptionValuePrice(productOptionAttribute.getProductAttribute().getPrice());
				orderProductAttribute.setPricePrefix(productOptionAttribute.getProductAttribute().getPricePrefix());
				orderProductAttribute.setProductOption(productOptionAttribute.getProductOption().getName());
				orderProductAttribute.setProductOptionValue(productOptionAttribute.getProductOptionValue().getName());
				orderProductAttributeRepository.save(orderProductAttribute);
			}
		}
		 //Todo:shipping
		//Todo:PaymentCost
		double shipping = 5.0d;
		double payment = 0.0d;
		double total = subtotal+shipping+payment;
		OrderTotal subTotalOrderTotal = new OrderTotal();
		subTotalOrderTotal.setOrder(order);
		subTotalOrderTotal.setTitle("Sub-Total:");
		subTotalOrderTotal.setTotalClass("ot_subtotal");
		subTotalOrderTotal.setSortOrder(1);
		subTotalOrderTotal.setValue(subtotal);
		subTotalOrderTotal.setText("$"+subtotal);
		OrderTotal shippingOrderTotal = new OrderTotal();
		shippingOrderTotal.setOrder(order);
		shippingOrderTotal.setTitle("Flat Rate (Best Way):");
		shippingOrderTotal.setTotalClass("ot_shipping");
		shippingOrderTotal.setSortOrder(2);
		shippingOrderTotal.setValue(shipping);
		shippingOrderTotal.setText("$"+shipping);
		OrderTotal totalOrderTotal = new OrderTotal();
		totalOrderTotal.setOrder(order);
		totalOrderTotal.setTitle("Total:");
		totalOrderTotal.setTotalClass("ot_total");
		totalOrderTotal.setSortOrder(4);
		totalOrderTotal.setValue(total);
		totalOrderTotal.setText("<strong>$"+total+"</strong>");
		orderTotalRepository.save(subTotalOrderTotal);
		orderTotalRepository.save(shippingOrderTotal);
		orderTotalRepository.save(totalOrderTotal);
		OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
		orderStatusHistory.setOrder(order);
		orderStatusHistory.setDateAdded(new Date());
		orderStatusHistory.setOrdersStatusId(1);
		orderStatusHistoryRepository.save(orderStatusHistory);
		for(CustomersBasketAttribute customersBasketAttribute:customersBasketAttributeRepository.findByCustomer(customer)){
			customersBasketAttributeRepository.delete(customersBasketAttribute);
		}
		for(CustomersBasket customersBasket:customersBasketRepository.findByCustomer(customer)){
			customersBasketRepository.delete(customersBasket);
		}
		transientBasket.clearBasket();
	}

	private void copyAddressesToOrder(CheckoutBean checkout, Order order, Customer customer) {
		order.setBillingCity(checkout.getPaymentAddress().getCity());
		order.setBillingCompany(checkout.getPaymentAddress().getCompany());
		order.setBillingCountry(checkout.getPaymentAddress().getCountryName());
		order.setBillingName(checkout.getPaymentAddress().getFirstname()+checkout.getPaymentAddress().getLastname());
		order.setBillingPostcode(checkout.getPaymentAddress().getPostcode());
		order.setBillingState(checkout.getPaymentAddress().getState());
		order.setBillingStreetAddress(checkout.getPaymentAddress().getStreetAddress());
		order.setBillingSuburb(checkout.getPaymentAddress().getSuburb());
		order.setCustomersStreetAddress(customer.getDefaultAddress().getStreetAddress());
		order.setCustomersCity(customer.getDefaultAddress().getCity());
		order.setCustomersCompany(customer.getDefaultAddress().getCompany());
		order.setCustomersCountry(customer.getDefaultAddress().getCountry().getName());
		order.setCustomersName(customer.getDefaultAddress().getFirstname()+customer.getDefaultAddress().getLastname());
		order.setCustomersPostcode(customer.getDefaultAddress().getPostcode());
		order.setCustomersState(customer.getDefaultAddress().getState());
		order.setCustomersSuburb(customer.getDefaultAddress().getSuburb());
		order.setDeliveryCity(checkout.getShippingAddress().getCity());
		order.setDeliveryCompany(checkout.getShippingAddress().getCompany());
		order.setDeliveryName(checkout.getShippingAddress().getFirstname()+checkout.getShippingAddress().getLastname());
		order.setDeliveryPostcode(checkout.getShippingAddress().getPostcode());
		order.setDeliveryStreetAddress(checkout.getShippingAddress().getStreetAddress());
		order.setDeliverySuburb(checkout.getShippingAddress().getSuburb());
		order.setDeliveryCountry(checkout.getShippingAddress().getCountryName());
		order.setCustomersAddressFormat(customer.getDefaultAddress().getCountry().getAddressFormat());
		order.setBillingAddressFormat(countryRepository.findOne(checkout.getPaymentAddress().getCountryId()).getAddressFormat());
		order.setDeliveryAddressFormat(countryRepository.findOne(checkout.getShippingAddress().getCountryId()).getAddressFormat());
	}
	
	
}
