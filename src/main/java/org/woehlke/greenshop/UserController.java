package org.woehlke.greenshop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.woehlke.greenshop.checkout.OrderService;
import org.woehlke.greenshop.checkout.model.OrderHistoryBean;
import org.woehlke.greenshop.checkout.model.OrderHistoryDetailsBean;
import org.woehlke.greenshop.customer.CustomerService;
import org.woehlke.greenshop.customer.entities.AddressBook;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.entities.CustomerInfo;
import org.woehlke.greenshop.customer.model.ChangePasswordBean;
import org.woehlke.greenshop.customer.model.CustomerAddressBean;

@Controller
@SessionAttributes({"transientBasket"})
public class UserController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private OrderService orderService;


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model){
		super.getDefaultBoxContent(model);
		return "account";
	}
	
	@RequestMapping(value = "/accountEdit", method = RequestMethod.GET)
	public String accountEdit(Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		model.addAttribute("customerDetails", customer);
		return "accountEdit";
	}
	
	@RequestMapping(value = "/accountEdit", method = RequestMethod.POST)
	public String accountEditSave(
			@Valid Customer customerDetails, BindingResult result, Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		logger.info("-------------------------------------------------------");
		logger.info(customerDetails.toString());
		logger.info("-------------------------------------------------------");
		customer.setGender(customerDetails.getGender());
		customer.setFirstname(customerDetails.getFirstname());
		customer.setLastname(customerDetails.getLastname());
		customer.setDob(customerDetails.getDob());
		customer.setEmailAddress(customerDetails.getEmailAddress());
		customer.setTelephone(customerDetails.getTelephone());
		customer.setFax(customerDetails.getFax());
		customerService.updateCustomer(customer);
		model.addAttribute("customerDetails", customer);
		return "accountEdit";
	}
	
	@RequestMapping(value = "/addressBook", method = RequestMethod.GET)
	public String addressBook(Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		model.addAttribute("customer",customer);
		List<AddressBook> adressBook = customerService.findAddressBookForCustomer(customer);
		model.addAttribute("adressBook",adressBook);
		logger.info("-------------------------------------------------------");
		logger.info(customer.toString());
		logger.info("-------------------------------------------------------");
		return "addressBook";
	}
	
	@RequestMapping(value = "/addressBook/edit/{addressId}", method = RequestMethod.GET)
	public String addressBookEditForm(@PathVariable long addressId, Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		model.addAttribute("customer",customer);
		AddressBook customersAddress = customerService.findAddressById(addressId);
		List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
		model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
		CustomerAddressBean addressBean = new CustomerAddressBean();
		addressBean.setGender(customersAddress.getGender());
		addressBean.setFirstname(customersAddress.getFirstname());
		addressBean.setLastname(customersAddress.getLastname());
		addressBean.setCompany(customersAddress.getCompany());
		addressBean.setStreetAddress(customersAddress.getStreetAddress());
		addressBean.setSuburb(customersAddress.getSuburb());
		addressBean.setPostcode(customersAddress.getPostcode());
		addressBean.setCity(customersAddress.getCity());
		addressBean.setState(customersAddress.getState());
		addressBean.setCountry(customersAddress.getCountry().getId());
		model.addAttribute("customersAddress",addressBean);
		return "addressBookEdit";
	}
	
	@RequestMapping(value = "/addressBook/edit/{addressId}", method = RequestMethod.POST)
	public String addressBookEditStore(
			@Valid CustomerAddressBean customersAddress,
			@PathVariable long addressId, Model model, BindingResult result){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		model.addAttribute("customer",customer);
		if (result.hasErrors()){
			super.getDefaultBoxContent(model);
			List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
			model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
			return "addressBookEdit";
		} else {
			AddressBook persistentAddress = customerService.findAddressById(addressId);
			Country country = customerService.findCountryById(customersAddress.getCountry());
			persistentAddress.setCity(customersAddress.getCity());
			persistentAddress.setCompany(customersAddress.getCompany());
			persistentAddress.setCountry(country);
			persistentAddress.setFirstname(customersAddress.getFirstname());
			persistentAddress.setGender(customersAddress.getGender());
			persistentAddress.setLastname(customersAddress.getLastname());
			persistentAddress.setPostcode(customersAddress.getPostcode());
			persistentAddress.setState(customersAddress.getState());
			persistentAddress.setStreetAddress(customersAddress.getStreetAddress());
			persistentAddress.setSuburb(customersAddress.getSuburb());
			customerService.updateAddressBook(persistentAddress);
			return "redirect:/addressBook";
		}	
	}
	
	@RequestMapping(value = "/addressBook/add", method = RequestMethod.GET)
	public String addressBookAddForm(Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		model.addAttribute("customer",customer);
		List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
		model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
		CustomerAddressBean addressBean = new CustomerAddressBean();
		model.addAttribute("customersAddress",addressBean);
		return "addressBookAdd";
	}
	
	@RequestMapping(value = "/addressBook/add", method = RequestMethod.POST)
	public String addressBookAddPerform(@Valid CustomerAddressBean customersAddress,Model model, BindingResult result){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		model.addAttribute("customer",customer);
		if(result.hasErrors()){
			super.getDefaultBoxContent(model);
			List<Country> allCountriesOrderByName = customerService.findAllCountriesOrderByName();
			model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
			model.addAttribute("customersAddress",customersAddress);
			return "addressBookAdd";
		} else {
			AddressBook persistentAddress = new AddressBook();
			Country country = customerService.findCountryById(customersAddress.getCountry());
			persistentAddress.setCustomer(customer);
			persistentAddress.setCity(customersAddress.getCity());
			persistentAddress.setCompany(customersAddress.getCompany());
			persistentAddress.setCountry(country);
			persistentAddress.setFirstname(customersAddress.getFirstname());
			persistentAddress.setGender(customersAddress.getGender());
			persistentAddress.setLastname(customersAddress.getLastname());
			persistentAddress.setPostcode(customersAddress.getPostcode());
			persistentAddress.setState(customersAddress.getState());
			persistentAddress.setStreetAddress(customersAddress.getStreetAddress());
			persistentAddress.setSuburb(customersAddress.getSuburb());
			customerService.updateAddressBook(persistentAddress);
			return "redirect:/addressBook";
		}
	}
	
	@RequestMapping(value = "/addressBook/delete/{addressId}", method = RequestMethod.GET)
	public String addressBookDelete(@PathVariable long addressId, Model model){
		AddressBook customersAddress = customerService.findAddressById(addressId);
		if(!customersAddress.isPrimaryAddress()){
			customerService.deleteAddress(customersAddress);
		}
		return "redirect:/addressBook";
	}
	
	@RequestMapping(value = "/accountPassword", method = RequestMethod.GET)
	public String accountPassword(Model model){
		super.getDefaultBoxContent(model);
		ChangePasswordBean changePasswordBean = new ChangePasswordBean();
		model.addAttribute("changePasswordBean", changePasswordBean);
		return "accountPassword";
	}
	
	@RequestMapping(value = "/accountPassword", method = RequestMethod.POST)
	public String accountPasswordPerform(@Valid ChangePasswordBean changePasswordBean,
			BindingResult result, Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		if(customer.getPassword().equals(changePasswordBean.getPasswordCurrentEncoded())&&changePasswordBean.isConfirmed()){
			customer.setPassword(changePasswordBean.getPasswordNewEncoded());
			customerService.updateCustomer(customer);
			return "redirect:/account";
		} else {
			if(!changePasswordBean.isConfirmed()){
				FieldError e = new FieldError("changePasswordBean","passwordConfirmation","Passwords don't match");
				result.addError(e);
			}
			if(!customer.getPassword().equals(changePasswordBean.getPasswordCurrentEncoded())){
				FieldError e = new FieldError("changePasswordBean","passwordCurrent","wrong Password");
				result.addError(e);
			}
			model.addAttribute("changePasswordBean", changePasswordBean);
			return "accountPassword";
		}
	}
	
	@RequestMapping(value = "/accountHistory", method = RequestMethod.GET)
	public String accountHistory(Model model){
		super.getDefaultBoxContent(model);
		Customer customer = super.getLoggedInCustomer();
		List<OrderHistoryBean> orderHistory = this.orderService.getOrderHistoryForCustomer(customer);
		model.addAttribute("orders", orderHistory);
		return "accountHistory";
	}
	
	@RequestMapping(value = "/accountHistoryInfo/{orderId}", method = RequestMethod.GET)
	public String accountHistoryInfo(@PathVariable long orderId, Model model){
		super.getDefaultBoxContent(model);
		OrderHistoryDetailsBean orderHistoryDetailsBean = this.orderService.findOrderDetailsById(orderId);
		model.addAttribute("orderHistoryDetailsBean",orderHistoryDetailsBean);
		return "accountHistoryInfo";
	}
	
	@RequestMapping(value = "/accountNewsletter", method = RequestMethod.GET)
	 public String accountNewsletter(Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		model.addAttribute("customer", customer);
		return "accountNewsletter";
	}

	@RequestMapping(value = "/accountNewsletter", method = RequestMethod.POST)
	public String accountNewsletterPerform(Customer customer, BindingResult result, Model model) {
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer myCustomer = customerService.findCustomerByEmail(customerEmail);
		if(result.hasErrors()){
			model.addAttribute("customer", myCustomer);
			return "accountNewsletter";
		} else {
			myCustomer.setNewsletter(customer.getNewsletter());
			customerService.updateCustomer(myCustomer);
			return "redirect:/account";
		}
	}
	
	@RequestMapping(value = "/accountNotifications", method = RequestMethod.GET)
	public String accountNotifications(Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		CustomerInfo customerInfo = customerService.findCustomerInfoByCustomer(customer);
		model.addAttribute("customerInfo", customerInfo);
		model.addAttribute("customer", customer);
		return "accountNotifications";
	}

	@RequestMapping(value = "/accountNotifications", method = RequestMethod.POST)
	public String accountNotificationsPerform(CustomerInfo customerInfo, BindingResult result, Model model){
		super.getDefaultBoxContent(model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer myCustomer = customerService.findCustomerByEmail(customerEmail);
		CustomerInfo myCustomerInfo = customerService.findCustomerInfoByCustomer(myCustomer);
		if(result.hasErrors()){
			model.addAttribute("customerInfo", myCustomerInfo);
			model.addAttribute("customer", myCustomer);
			return "accountNotifications";
		} else {
			myCustomerInfo.setGlobalProductNotifications(customerInfo.getGlobalProductNotifications());
			customerService.updateCustomerInfo(myCustomerInfo);
			return "redirect:/account";
		}
	}
}
