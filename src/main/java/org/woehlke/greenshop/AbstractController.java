package org.woehlke.greenshop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.woehlke.greenshop.cart.model.TransientBasket;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.Manufacturers;
import org.woehlke.greenshop.customer.CustomerService;
import org.woehlke.greenshop.customer.entities.Customer;

public abstract class AbstractController {

	@Inject
	protected CatalogService catalogService;
	
	@Inject
	protected CustomerService customerService;
	
	@ModelAttribute("transientBasket")
	public TransientBasket createTransientBasket(){
		return new TransientBasket();
	}
	
	protected void getDefaultBoxContent(Model model){
		Language language = catalogService.findLanguageByCode("en");
		List<ProductDescription> newProducts = catalogService.recommenderNewProducts(language);
		model.addAttribute("newProducts", newProducts);
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		CategoryTree categoryTree = catalogService.getCategoriesTree(0L, language);
		model.addAttribute("categoryTree", categoryTree);
	}
	
	protected Customer getLoggedInCustomer(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		return customer;
	}
}
