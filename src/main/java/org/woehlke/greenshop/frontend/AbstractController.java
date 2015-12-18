package org.woehlke.greenshop.frontend;

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
import org.woehlke.greenshop.oodm.cart.model.TransientBasket;
import org.woehlke.greenshop.oodm.catalog.CatalogService;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.entities.ReviewDescription;
import org.woehlke.greenshop.oodm.catalog.model.CategoryTree;
import org.woehlke.greenshop.oodm.catalog.model.Manufacturers;
import org.woehlke.greenshop.oodm.catalog.model.ShareProductBean;
import org.woehlke.greenshop.oodm.catalog.model.SpecialProduct;
import org.woehlke.greenshop.oodm.catalog.service.*;
import org.woehlke.greenshop.oodm.customer.CustomerService;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

public abstract class AbstractController {

	@Inject
	protected CatalogService catalogService;
	
	@Inject
	protected CustomerService customerService;

    @Inject
    protected LanguageService languageService;

    @Inject
    protected CategoryService categoryService;

    @Inject
    private ManufacturerService manufacturerService;

    @Inject
    private ProductService productService;

    @Inject
    private ReviewService reviewService;

    @Inject
    private SpecialService specialService;
	
	@ModelAttribute("transientBasket")
	public TransientBasket createTransientBasket(){
		return new TransientBasket();
	}
	
	protected void getDefaultBoxContent(Model model){
		Language language = languageService.findLanguageByCode("en");
		List<SpecialProduct> newProducts = productService.recommenderNewProducts(language);
		model.addAttribute("newProducts", newProducts);
		Manufacturers manufacturers = manufacturerService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		CategoryTree categoryTree = categoryService.getCategoriesTree(0L, language);
		model.addAttribute("categoryTree", categoryTree);
		ReviewDescription randomReview = reviewService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		SpecialProduct randomSpecialProduct = specialService.getRandomSpecial(language);
		model.addAttribute("randomSpecialProduct", randomSpecialProduct);
		SpecialProduct randomNewProduct = productService.getRandomNewProduct(language);
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
