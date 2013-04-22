package org.woehlke.greenshop.checkout;

import org.woehlke.greenshop.cart.model.TransientBasket;
import org.woehlke.greenshop.checkout.model.AddressBean;
import org.woehlke.greenshop.checkout.model.CheckoutBean;
import org.woehlke.greenshop.customer.entities.AddressBook;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;

public interface CheckoutService {

	AddressBean transformPersistentAddressToBean(AddressBook choosenAddress);
	
	AddressBook transformBeanToPersistentAddress(
			AddressBean newAddress, 
			Country country, 
			Customer customer);

	void placeOrder(CheckoutBean checkout, TransientBasket transientBasket,
			Customer customer);

}
