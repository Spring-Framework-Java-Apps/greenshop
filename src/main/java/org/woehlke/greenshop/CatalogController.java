package org.woehlke.greenshop;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.customer.entities.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
@SessionAttributes({"transientBasket"})
public class CatalogController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model){
		super.getDefaultBoxContent(model);
		return "home";
	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String category(@PathVariable long categoryId,Model model){
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		List<ProductDescription> newProducts = catalogService.recommenderNewProducts(language);
		model.addAttribute("newProducts", newProducts);
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		CategoryTree categoryTree = catalogService.getCategoriesTree(categoryId, language);
		model.addAttribute("categoryTree", categoryTree);
		ProductsByCategory productsByCategory = catalogService.getProductsByCategory(categoryId, language);
		model.addAttribute("productsByCategory", productsByCategory);
		return "category";
	}
	
	@RequestMapping(value = "/category/{categoryId}/manufacturer", method = RequestMethod.GET)
	public String categoryFilteredByManufacturerId(
			@PathVariable long categoryId,
			@RequestParam("manufacturer") Long manufacturerId, Model model){
		if(manufacturerId==0){
			return "redirect:/category/"+categoryId;
		} else {
			return "redirect:/category/"+categoryId+"/manufacturer/"+manufacturerId;
		}
	}
	
	@RequestMapping(value = "/category/{categoryId}/manufacturer/{manufacturerId}", method = RequestMethod.GET)
	public String categoryFilteredByManufacturer(
			@PathVariable long categoryId,
			@PathVariable long manufacturerId, Model model){
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		List<ProductDescription> newProducts = catalogService.recommenderNewProducts(language);
		model.addAttribute("newProducts", newProducts);
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		CategoryTree categoryTree = catalogService.getCategoriesTree(categoryId, language);
		model.addAttribute("categoryTree", categoryTree);
		ProductsByCategory productsByCategory = catalogService.getProductsByCategoryAndManufacturer(categoryId, manufacturerId, language);
		model.addAttribute("productsByCategory", productsByCategory);
		return "category";
	}
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public String product(@PathVariable long productId,
						  HttpServletRequest request,
						  HttpServletResponse response,
						  Model model){
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		ProductDescription productDescription = catalogService.findProductById(productId,language);
		model.addAttribute("product", productDescription);
		logger.info(productDescription.toString());
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(productDescription);
		logger.info(productAttributes.toString());
		model.addAttribute("productAttributes", productAttributes);
		CategoryTree categoryTree = catalogService.getCategoriesTree(productDescription.getProduct().getCategories().iterator().next().getId(), language);
		model.addAttribute("categoryTree", categoryTree);
		ShareProductBean shareProductBean = getShareProductBean(request,productDescription);
		model.addAttribute("shareProductBean", shareProductBean);
		return "product";
	}
	
	@RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
	public String manufacturer(@RequestParam("manufacturers_id") Long manufacturerId,Model model){
		logger.info("manufacturers_id="+manufacturerId);
		return "redirect:/manufacturer/"+manufacturerId;
	}
	
	@RequestMapping(value = "/manufacturer/{manufacturerId}", method = RequestMethod.GET)
	public String manufacturer(@PathVariable long manufacturerId,Model model){
		logger.info("manufacturers_id="+manufacturerId);
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		List<ProductDescription> newProducts = catalogService.recommenderNewProducts(language);
		model.addAttribute("newProducts", newProducts);
		Manufacturers manufacturers=catalogService.findManufacturers();
		manufacturers.setManufacturerId(manufacturerId);
		model.addAttribute("manufacturers", manufacturers);
		Manufacturer manufacturer=catalogService.findManufacturerById(manufacturerId);
		model.addAttribute("manufacturer", manufacturer);
		ProductsByManufacturer products = catalogService.findProductsByManufacturer(manufacturer,language);
		model.addAttribute("products", products);
		CategoryTree categoryTree = catalogService.getCategoriesTree(0L, language);
		model.addAttribute("categoryTree", categoryTree);
		return "manufacturer";
	}
	
	@RequestMapping(value = "/manufacturer/{manufacturerId}/category/", method = RequestMethod.GET)
	public String manufacturerFilteredByCategoryId(
			@PathVariable long manufacturerId,
			@RequestParam("categoryId") Long categoryId, Model model){
		if(categoryId==null || categoryId==0){
			return "redirect:/manufacturer/"+manufacturerId;
		} else {
			return "redirect:/manufacturer/"+manufacturerId+"/category/"+categoryId;
		}
	}
		
	@RequestMapping(value = "/manufacturer/{manufacturerId}/category/{categoryId}", method = RequestMethod.GET)
	public String manufacturerFilteredByCategory(
			@PathVariable long manufacturerId,
			@PathVariable long categoryId, Model model){
		logger.info("manufacturers_id="+manufacturerId);
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		List<ProductDescription> newProducts = catalogService.recommenderNewProducts(language);
		model.addAttribute("newProducts", newProducts);
		Manufacturers manufacturers=catalogService.findManufacturers();
		manufacturers.setManufacturerId(manufacturerId);
		model.addAttribute("manufacturers", manufacturers);
		Manufacturer manufacturer=catalogService.findManufacturerById(manufacturerId);
		model.addAttribute("manufacturer", manufacturer);
		ProductsByManufacturer products = catalogService.findProductsByManufacturerAndCategory(manufacturer,categoryId,language);
		products.setCategoryId(categoryId);
		model.addAttribute("products", products);
		CategoryTree categoryTree = catalogService.getCategoriesTree(0L, language);
		model.addAttribute("categoryTree", categoryTree);
		return "manufacturer";
	}

	@RequestMapping(value = "/manufacturer/redirect/{manufacturerId}", method = RequestMethod.GET)
	public String manufacturerRedirect(@PathVariable long manufacturerId,Model model) {
		logger.info("manufacturers_id=" + manufacturerId);
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		ManufacturerInfo manufacturerInfo=catalogService.findManufacturerInfo(manufacturerId,language);
		manufacturerInfo=catalogService.clickManufacturerUrl(manufacturerInfo);
		model.addAttribute("manufacturer", manufacturerInfo);
		return "manufacturerRedirect";
	}

	@RequestMapping(value = "/review/write/product/{productId}", method = RequestMethod.GET)
	public String writeReviewForProduct(@PathVariable long productId,
										HttpServletRequest request,
										HttpServletResponse response,
										Model model){
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		ProductDescription productDescription = catalogService.findProductById(productId,language);
		model.addAttribute("product", productDescription);
		logger.info(productDescription.toString());
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(productDescription);
		logger.info(productAttributes.toString());
		model.addAttribute("productAttributes", productAttributes);
		CategoryTree categoryTree =
				catalogService.getCategoriesTree(productDescription.getProduct().getCategories().iterator().next().getId(), language);
		model.addAttribute("categoryTree", categoryTree);
		ShareProductBean shareProductBean = getShareProductBean(request, productDescription);
		model.addAttribute("shareProductBean", shareProductBean);
		Customer customer = super.getLoggedInCustomer();
		model.addAttribute("customer", customer);
		WriteReviewBean writeReviewBean = new WriteReviewBean();
		model.addAttribute("writeReviewBean", writeReviewBean);
		return "writeReviewForProduct";
	}

	@RequestMapping(value = "/review/write/product/{productId}", method = RequestMethod.POST)
	public String writeReviewForProductPerform(@ModelAttribute("writeReviewBean") @Valid WriteReviewBean writeReviewBean,
											   BindingResult result, //BindingResult must be here after validated Object
											   @PathVariable long productId,
											   HttpServletRequest request,
											   HttpServletResponse response,
											   Model model){
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		ProductDescription productDescription = catalogService.findProductById(productId,language);
		Customer customer = super.getLoggedInCustomer();
		if(result.hasErrors()){
			model.addAttribute("product", productDescription);
			logger.info(productDescription.toString());
			Manufacturers manufacturers=catalogService.findManufacturers();
			model.addAttribute("manufacturers", manufacturers);
			ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(productDescription);
			logger.info(productAttributes.toString());
			model.addAttribute("productAttributes", productAttributes);
			CategoryTree categoryTree =
					catalogService.getCategoriesTree(productDescription.getProduct().getCategories().iterator().next().getId(), language);
			model.addAttribute("categoryTree", categoryTree);
			ShareProductBean shareProductBean = getShareProductBean(request, productDescription);
			model.addAttribute("shareProductBean", shareProductBean);
			model.addAttribute("customer", customer);
			return "writeReviewForProduct";
		} else {
			logger.info("##################################");
			logger.info(writeReviewBean.toString());
			logger.info("##################################");
			ReviewDescription reviewDescription = catalogService.
			saveReview(writeReviewBean, productDescription.getProduct(), customer,language);
			logger.info(reviewDescription.toString());
			return "redirect:/product/"+productId;
		}
	}

	@RequestMapping(value = "/product/reviews/{productId}", method = RequestMethod.GET)
	 public String showReviews(@PathVariable long productId,
							   HttpServletRequest request,
							   HttpServletResponse response,
							   Model model){
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		ProductDescription productDescription = catalogService.findProductById(productId,language);
		model.addAttribute("product", productDescription);
		logger.info(productDescription.toString());
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(productDescription);
		logger.info(productAttributes.toString());
		model.addAttribute("productAttributes", productAttributes);
		CategoryTree categoryTree = catalogService.getCategoriesTree(productDescription.getProduct().getCategories().iterator().next().getId(), language);
		model.addAttribute("categoryTree", categoryTree);
		ShareProductBean shareProductBean = getShareProductBean(request,productDescription);
		model.addAttribute("shareProductBean", shareProductBean);
		List<ReviewDescription> reviewDescriptions = catalogService.findReviewsForProduct(productDescription);
		for(ReviewDescription reviewDescription:reviewDescriptions){
		  	Review review = reviewDescription.getReview();
			review.increaseReviewsRead();
			catalogService.update(review);
		}
		reviewDescriptions = catalogService.findReviewsForProduct(productDescription);
		model.addAttribute("reviewDescriptions", reviewDescriptions);
		return "showReviews";
	}

	@RequestMapping(value = "/product/review/{reviewId}", method = RequestMethod.GET)
	public String showReview(@PathVariable long reviewId,
							  HttpServletRequest request,
							  HttpServletResponse response,
							  Model model){
		Language language = catalogService.findLanguageByCode("en");
		ReviewDescription randomReview = catalogService.getRandomReview(language);
		model.addAttribute("randomReview", randomReview);
		ReviewDescription reviewDescription = catalogService.findReviewById(reviewId,language);
		Review review = reviewDescription.getReview();
		review.increaseReviewsRead();
		catalogService.update(review);
		reviewDescription = catalogService.findReviewById(reviewId,language);
		model.addAttribute("reviewDescription", reviewDescription);
		ProductDescription productDescription = catalogService.findProductById(reviewDescription.getReview().getProduct().getId(),language);
		model.addAttribute("product", productDescription);
		logger.info(productDescription.toString());
		Manufacturers manufacturers=catalogService.findManufacturers();
		model.addAttribute("manufacturers", manufacturers);
		ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(productDescription);
		logger.info(productAttributes.toString());
		model.addAttribute("productAttributes", productAttributes);
		CategoryTree categoryTree = catalogService.getCategoriesTree(productDescription.getProduct().getCategories().iterator().next().getId(), language);
		model.addAttribute("categoryTree", categoryTree);
		ShareProductBean shareProductBean = getShareProductBean(request, productDescription);
		model.addAttribute("shareProductBean", shareProductBean);
		return "showReview";
	}
}
