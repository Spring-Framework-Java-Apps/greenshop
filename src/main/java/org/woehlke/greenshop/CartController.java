package org.woehlke.greenshop;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.greenshop.cart.CartService;
import org.woehlke.greenshop.cart.model.TransientBasket;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.ReviewDescription;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.Manufacturers;
import org.woehlke.greenshop.catalog.model.ProductAttributes;
import org.woehlke.greenshop.catalog.model.SpecialProduct;

@Controller
@SessionAttributes({"transientBasket"})
public class CartController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Inject
	private CartService cartService;
	
	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public String shoppingCart(
			@ModelAttribute("transientBasket") TransientBasket transientBasket, 
			Model model){
		super.getDefaultBoxContent(model);
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/shoppingCart/add/{productId}", method = RequestMethod.GET)
	public String addToBasket(
			@ModelAttribute("transientBasket") TransientBasket transientBasket,
			HttpServletRequest request,  
            HttpServletResponse response,
			@PathVariable long productId, Model model){	
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		SpecialProduct randomSpecialProduct = catalogService.getRandomSpecial(language);
		model.addAttribute("randomSpecialProduct", randomSpecialProduct);
		SpecialProduct thisProduct = catalogService.findSpecialProductById(productId, language);
		model.addAttribute("product", thisProduct);
		logger.info(thisProduct.toString());
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(thisProduct.getProductDescription());
		logger.info(productAttributes.toString());
		model.addAttribute("productAttributes", productAttributes);
		CategoryTree categoryTree = catalogService.getCategoriesTree(thisProduct.getProductDescription().getProduct().getCategories().iterator().next().getId(), language);
		model.addAttribute("categoryTree", categoryTree);
		Map<Long,Long> optionsAndValues = getOptionsAndValuesFromRequest(request);
		transientBasket = cartService.addProductToCart(transientBasket,productId,optionsAndValues,language);
		logger.info(transientBasket.toString());
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/shoppingCart/remove/{productId}", method = RequestMethod.GET)
	public String removeFromBasket(
			@ModelAttribute("transientBasket") TransientBasket transientBasket,
			HttpServletRequest request,  
            HttpServletResponse response,
			@PathVariable long productId, Model model){	
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		SpecialProduct randomSpecialProduct = catalogService.getRandomSpecial(language);
		model.addAttribute("randomSpecialProduct", randomSpecialProduct);
		SpecialProduct thisProduct = catalogService.findSpecialProductById(productId, language);
		model.addAttribute("product", thisProduct);
		logger.info(thisProduct.toString());
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(thisProduct.getProductDescription());
		logger.info(productAttributes.toString());
		model.addAttribute("productAttributes", productAttributes);
		CategoryTree categoryTree = catalogService.getCategoriesTree(thisProduct.getProductDescription().getProduct().getCategories().iterator().next().getId(), language);
		model.addAttribute("categoryTree", categoryTree);
		Map<Long,Long> optionsAndValues = getOptionsAndValuesFromRequest(request);
		transientBasket = cartService.removeProductFromCart(transientBasket,productId,optionsAndValues,language);
		logger.info(transientBasket.toString());
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/shoppingCart/update", method = RequestMethod.POST)
	public String updateBasket(
			@ModelAttribute("transientBasket") TransientBasket transientBasket,
			HttpServletRequest request,  
            HttpServletResponse response, 
            @RequestParam("cartQuantity[]") int cartQuantity[], Model model){	
		super.getDefaultBoxContent(model);
		cartService.update(cartQuantity,transientBasket);
		return "shoppingCart";
	}
	
	private Map<Long,Long> getOptionsAndValuesFromRequest(HttpServletRequest request){
		Map<Long,Long> optionsAndValues = new HashMap<Long,Long>();
		@SuppressWarnings("unchecked")
		Map<String,String[]> parameter= request.getParameterMap();
		for(String name:parameter.keySet()){
			if(name.matches("id_[0-9]*")){
				String optionString = name.replace("id_", "");
				logger.info("optionString: "+optionString);
				long option = Long.parseLong(optionString);
				String parameterList[] = parameter.get(name);
				for(String parameterValue:parameterList){
					if(parameterValue.matches("[0-9]*")){
						long value = Long.parseLong(parameterValue);
						optionsAndValues.put(option, value);
					}
					logger.info("Parameter: "+name+" = "+ parameterValue);
				}
			}
		}
		for(Long option:optionsAndValues.keySet()){
			logger.info("Option: "+option+" = "+ optionsAndValues.get(option));
		}
		return optionsAndValues;
	}
}
