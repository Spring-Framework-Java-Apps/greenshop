package org.woehlke.greenshop.oodm.checkout;

import org.woehlke.greenshop.oodm.cart.model.TransientBasket;
import org.woehlke.greenshop.oodm.checkout.model.AddressBean;
import org.woehlke.greenshop.oodm.checkout.model.CheckoutBean;
import org.woehlke.greenshop.oodm.customer.entities.AddressBook;
import org.woehlke.greenshop.oodm.customer.entities.Country;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

public interface CheckoutService {

	AddressBean transformPersistentAddressToBean(AddressBook choosenAddress);
	
	AddressBook transformBeanToPersistentAddress(
			AddressBean newAddress, 
			Country country, 
			Customer customer);

	void placeOrder(CheckoutBean checkout, TransientBasket transientBasket,
			Customer customer);

}
