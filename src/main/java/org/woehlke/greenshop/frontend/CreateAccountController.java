package org.woehlke.greenshop.frontend;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.greenshop.oodm.customer.service.CountryService;
import org.woehlke.greenshop.oodm.customer.CustomerService;
import org.woehlke.greenshop.oodm.customer.entities.Country;
import org.woehlke.greenshop.oodm.customer.model.CreateNewCustomerFormBean;

@Controller
@SessionAttributes({"transientBasket"})
public class CreateAccountController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(CreateAccountController.class);
	
	@Inject
	private CustomerService customerService;

    @Inject
    private CountryService countryService;
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String createNewCustomerForm(Model model){
		super.getDefaultBoxContent(model);
		CreateNewCustomerFormBean createNewCustomerFormBean = new CreateNewCustomerFormBean();
		model.addAttribute("createNewCustomerFormBean",createNewCustomerFormBean);
		List<Country> allCountriesOrderByName = countryService.findAllCountriesOrderByName();
		model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
		return "createAccount";
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createNewCustomer(
			@Valid CreateNewCustomerFormBean createNewCustomerFormBean,
			BindingResult result, Model model){
		super.getDefaultBoxContent(model);
		if(customerService.findCustomerByEmail(createNewCustomerFormBean.getEmailAddress())!=null){
			result.addError(new FieldError("createNewCustomerFormBean","emailAddress", "is already in use, choose another one"));
		}
		if(!createNewCustomerFormBean.passwordsMatch()){
			result.addError(new FieldError("createNewCustomerFormBean","password", "passwords doesn't match"));
			result.addError(new FieldError("createNewCustomerFormBean","confirmation","passwords doesn't match"));
		}
		if(result.hasErrors()){
			List<Country> allCountriesOrderByName = countryService.findAllCountriesOrderByName();
			model.addAttribute("allCountriesOrderByName",allCountriesOrderByName);
			for(ObjectError e :result.getAllErrors()){
				logger.info(e.toString());
			}
			return "createAccount";
		} else {
			customerService.createNewCustomer(createNewCustomerFormBean);
			//login Customer
			UserDetails userDetails = customerService.loadUserByUsername(createNewCustomerFormBean.getEmailAddress());
			Authentication auth = new UsernamePasswordAuthenticationToken (userDetails.getUsername (),userDetails.getPassword (),userDetails.getAuthorities ());
			SecurityContextHolder.getContext().setAuthentication(auth);
			return "createdAccount";
		}
	}
}
