package org.woehlke.greenshop;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.greenshop.cart.model.TransientBasket;
import org.woehlke.greenshop.checkout.CheckoutService;
import org.woehlke.greenshop.checkout.model.AddressBean;
import org.woehlke.greenshop.checkout.model.CheckoutBean;
import org.woehlke.greenshop.customer.entities.AddressBook;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;

@Controller
@SessionAttributes({"transientBasket","checkout"})
public class CheckoutController extends AbstractController {

	@Inject
	private CheckoutService checkoutService;
	
	@ModelAttribute("checkout")
	public CheckoutBean createCheckoutBean(){
		return new CheckoutBean();
	}
	
	@RequestMapping(value = "/checkout/shipping", method = RequestMethod.GET)
	public String checkoutShipping(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@ModelAttribute("transientBasket") TransientBasket transientBasket, Model model){
		super.getDefaultBoxContent(model);
		if (transientBasket.isEmptyCart()){
			return "redirect:/shoppingCart";
		} else {
			Customer customer = super.getLoggedInCustomer();
			AddressBook defaultAddress = customer.getDefaultAddress();
			AddressBean customersAddress = checkoutService.transformPersistentAddressToBean(defaultAddress);
			checkout.setCustomersAddress(customersAddress);
			if (checkout.getShippingAddress() == null) {
				checkout.setShippingAddress(customersAddress);
			}
			if (checkout.getPaymentAddress() == null) {
				checkout.setPaymentAddress(customersAddress);
			}
			return "checkoutShipping";
		}
	}
	
	@RequestMapping(value = "/checkout/payment", method = RequestMethod.GET)
	public String checkoutPayment(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@ModelAttribute("transientBasket") TransientBasket transientBasket, Model model){
		super.getDefaultBoxContent(model);
		if (transientBasket.isEmptyCart()){
			return "redirect:/shoppingCart";
		} else {
			Customer customer = super.getLoggedInCustomer();
			return "checkoutPayment";
		}
	}	
	
	@RequestMapping(value = "/checkout/confirmation", method = RequestMethod.GET)
	public String checkoutConfirmation(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@ModelAttribute("transientBasket") TransientBasket transientBasket, Model model){
		super.getDefaultBoxContent(model);if (transientBasket.isEmptyCart()){
			return "redirect:/shoppingCart";
		} else {
			return "checkoutConfirmation";
		}
	}	
	
	@RequestMapping(value = "/checkout/confirmation", method = RequestMethod.POST)
	public String checkoutConfirmationPerform(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@ModelAttribute("transientBasket") TransientBasket transientBasket,
			Model model){
		super.getDefaultBoxContent(model);
		if (transientBasket.isEmptyCart()){
			return "redirect:/shoppingCart";
		} else {
			Customer customer = super.getLoggedInCustomer();
			checkoutService.placeOrder(checkout, transientBasket, customer);
			return "redirect:/checkout/performed";
		}
	}
	
	@RequestMapping(value = "/checkout/shippingAddress", method = RequestMethod.GET)
	public String checkoutShippingAddress(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@ModelAttribute("transientBasket") TransientBasket transientBasket, Model model){
		super.getDefaultBoxContent(model);
		if (transientBasket.isEmptyCart()){
			return "redirect:/shoppingCart";
		} else {
			Customer customer = super.getLoggedInCustomer();
			List<AddressBook> addressBook = super.customerService.findAddressBookForCustomer(customer);
			model.addAttribute("addressBook", addressBook);
			AddressBean newAddress = new AddressBean();
			newAddress.setChoosenAddressId(customer.getDefaultAddress().getId());
			model.addAttribute("newAddress", newAddress);
			List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
			model.addAttribute("allCountriesOrderByName", allCountriesOrderByName);
			return "checkoutShippingAddress";
		}
	}
	
	@RequestMapping(value = "/checkout/shippingAddress", method = RequestMethod.POST)
	public String checkoutShippingAddress(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@Valid AddressBean newAddress,
			BindingResult result, 
			Model model){
		super.getDefaultBoxContent(model);
		Customer customer = super.getLoggedInCustomer();
		if(newAddress.isFormEmpty()){
			long choosenAddressId = newAddress.getChoosenAddressId();
			AddressBook choosenAddress = super.customerService.findAddressById(choosenAddressId);
			AddressBean shippingAddress = checkoutService.transformPersistentAddressToBean(choosenAddress);
			checkout.setShippingAddress(shippingAddress);
		} else {
			newAddress.validate(result,"newAddress");
			if(result.hasErrors()){
				List<AddressBook> addressBook = super.customerService.findAddressBookForCustomer(customer);
				model.addAttribute("addressBook", addressBook);
				List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
				model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
				return "checkoutShippingAddress";
			} else {
				Country country = super.customerService.findCountryById(newAddress.getCountryId());
				newAddress.setCountryName(country.getName());
				AddressBook a = checkoutService.transformBeanToPersistentAddress(newAddress,country,customer);
				super.customerService.addAddress(a);
				checkout.setShippingAddress(newAddress);
			}
		}
		return "redirect:/checkout/shipping";
	}
	
	@RequestMapping(value = "/checkout/paymentAddress", method = RequestMethod.GET)
	public String checkoutPaymentAddress(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@ModelAttribute("transientBasket") TransientBasket transientBasket, Model model){
		super.getDefaultBoxContent(model);
		if (transientBasket.isEmptyCart()){
			return "redirect:/shoppingCart";
		} else {
			Customer customer = super.getLoggedInCustomer();
			List<AddressBook> addressBook = super.customerService.findAddressBookForCustomer(customer);
			model.addAttribute("addressBook", addressBook);
			AddressBean newAddress = new AddressBean();
			newAddress.setChoosenAddressId(customer.getDefaultAddress().getId());
			model.addAttribute("newAddress", newAddress);
			List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
			model.addAttribute("allCountriesOrderByName", allCountriesOrderByName);
			return "checkoutPaymentAddress";
		}
	}
	
	@RequestMapping(value = "/checkout/paymentAddress", method = RequestMethod.POST)
	public String checkoutPaymentAddress(
			@ModelAttribute("checkout") CheckoutBean checkout,
			@Valid AddressBean newAddress,
			BindingResult result, 
			Model model){
		super.getDefaultBoxContent(model);
		Customer customer = super.getLoggedInCustomer();
		if(newAddress.isFormEmpty()){
			long choosenAddressId = newAddress.getChoosenAddressId();
			AddressBook choosenAddress = super.customerService.findAddressById(choosenAddressId);
			AddressBean paymentAddress = checkoutService.transformPersistentAddressToBean(choosenAddress);
			checkout.setPaymentAddress(paymentAddress);
		} else {
			newAddress.validate(result,"newAddress");
			if(result.hasErrors()){
				List<AddressBook> addressBook = super.customerService.findAddressBookForCustomer(customer);
				model.addAttribute("addressBook", addressBook);
				List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
				model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
				return "checkoutShippingAddress";
			} else {
				Country country = super.customerService.findCountryById(newAddress.getCountryId());
				newAddress.setCountryName(country.getName());
				AddressBook a = checkoutService.transformBeanToPersistentAddress(newAddress, country, customer);
				super.customerService.addAddress(a);
				checkout.setPaymentAddress(newAddress);
			}
		}
		return "redirect:/checkout/payment";
	}
	
	@RequestMapping(value = "/checkout/performed", method = RequestMethod.GET)
	public String checkoutPerform(
			@ModelAttribute("checkout") CheckoutBean checkout, Model model){
		super.getDefaultBoxContent(model);
		return "checkoutSuccess";
	}
	
}
