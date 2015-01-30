package org.woehlke.greenshop;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.woehlke.greenshop.cart.model.TransientBasket;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ReviewDescription;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.Manufacturers;
import org.woehlke.greenshop.catalog.model.ShareProductBean;
import org.woehlke.greenshop.catalog.model.SpecialProduct;
import org.woehlke.greenshop.catalog.service.LanguageService;
import org.woehlke.greenshop.customer.CustomerService;
import org.woehlke.greenshop.customer.entities.Customer;

public abstract class AbstractController {

	@Inject
	protected CatalogService catalogService;
	
	@Inject
	protected CustomerService customerService;

    @Inject
    protected LanguageService languageService;
	
	@ModelAttribute("transientBasket")
	public TransientBasket createTransientBasket(){
		return new TransientBasket();
	}
	
	protected void getDefaultBoxContent(Model model){
		Language language = languageService.findLanguageByCode("en");
		List<SpecialProduct> newProducts = catalogService.recommenderNewProducts(language);
		model.addAttribute("newProducts", newProducts);
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		CategoryTree categoryTree = catalogService.getCategoriesTree(0L, language);
		model.addAttribute("categoryTree", categoryTree);
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		SpecialProduct randomSpecialProduct = catalogService.getRandomSpecial(language);
		model.addAttribute("randomSpecialProduct", randomSpecialProduct);
		SpecialProduct randomNewProduct = catalogService.getRandomNewProduct(language);
		model.addAttribute("randomNewProduct", randomNewProduct);
	}
	
	protected Customer getLoggedInCustomer(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String customerEmail = auth.getName();
		Customer customer = customerService.findCustomerByEmail(customerEmail);
		return customer;
	}

	protected ShareProductBean getShareProductBean(HttpServletRequest request,ProductDescription productDescription){
		ShareProductBean shareProductBean = new ShareProductBean();
		String productUrl = request.getRequestURL().toString();
		shareProductBean.setProductUrl(URLEncoder.encode(productUrl));
		shareProductBean.setProductName(URLEncoder.encode(productDescription.getName()));
		try {
			URL imageUrl = new URL(request.getRequestURL().toString());
			StringBuffer sb = new StringBuffer();
			sb.append(imageUrl.getProtocol());
			sb.append("://");
			sb.append(imageUrl.getHost());
			sb.append(":");
			sb.append(imageUrl.getPort());
			sb.append(request.getContextPath());
			sb.append("/resources/images/");
			sb.append(productDescription.getProduct().getImage());
			shareProductBean.setProductImageUrl(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return shareProductBean;
	}
}
