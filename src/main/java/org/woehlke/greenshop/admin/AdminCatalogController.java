package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.Review;
import org.woehlke.greenshop.catalog.entities.Special;
import org.woehlke.greenshop.catalog.model.ReviewProduct;
import org.woehlke.greenshop.catalog.model.SpecialProduct;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
@Controller
public class AdminCatalogController {

    @Inject
    private AdminService adminService;

    @Inject
    private CatalogService catalogService;

    @RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
    public String rootCategories(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/categories";
    }

    @RequestMapping(value = "/admin/manufacturers", method = RequestMethod.GET)
    public String manufacturers(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Manufacturer> manufacturers = adminService.getAllManufacturers();
        model.addAttribute("manufacturers",manufacturers);
        int productsOfThisManufacturer = 0;
        Manufacturer thisManufacturer = null;
        if(manufacturers.size()>0){
            thisManufacturer = manufacturers.iterator().next();
            productsOfThisManufacturer = adminService.countProductsOfThisManufacturer(thisManufacturer);
        }
        model.addAttribute("thisManufacturer",thisManufacturer);
        model.addAttribute("productsOfThisManufacturer",productsOfThisManufacturer);
        return "admin/manufacturers";
    }

    @RequestMapping(value = "/admin/manufacturers/{manufacturerId}", method = RequestMethod.GET)
    public String manufacturersId(
            @PathVariable long manufacturerId , Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Manufacturer> manufacturers = adminService.getAllManufacturers();
        model.addAttribute("manufacturers",manufacturers);
        int productsOfThisManufacturer = 0;
        Manufacturer thisManufacturer = null;
        if(manufacturers.size()>0){
            thisManufacturer = adminService.getManufacturerById(manufacturerId);
            productsOfThisManufacturer = adminService.countProductsOfThisManufacturer(thisManufacturer);
        }
        model.addAttribute("thisManufacturer",thisManufacturer);
        model.addAttribute("productsOfThisManufacturer",productsOfThisManufacturer);
        return "admin/manufacturers";
    }

    @RequestMapping(value = "/admin/reviews", method = RequestMethod.GET)
    public String reviews(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        List<ReviewProduct> reviews = catalogService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        ReviewProduct thisReview = null;
        if(reviews.size()>0){
            thisReview = reviews.iterator().next();
        }
        model.addAttribute("thisReview",thisReview);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/reviews";
    }

    @RequestMapping(value = "/admin/reviews/{reviewId}", method = RequestMethod.GET)
    public String reviewsId(@PathVariable long reviewId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        List<ReviewProduct> reviews = catalogService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        ReviewProduct thisReview = null;
        if(reviews.size()>0){
            thisReview = adminService.getReviewById(reviewId, language);
        }
        model.addAttribute("thisReview",thisReview);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/reviews";
    }

    @RequestMapping(value = "/admin/reviews/setInactive/{reviewId}", method = RequestMethod.GET)
    public String reviewsSetInactive(@PathVariable long reviewId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        ReviewProduct thisReview = adminService.getReviewById(reviewId, language);
        Review review = thisReview.getReview().getReview();
        review.setStatus(0);
        catalogService.update(review);
        thisReview = adminService.getReviewById(reviewId, language);
        model.addAttribute("thisReview",thisReview);
        List<ReviewProduct> reviews = catalogService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/reviews";
    }

    @RequestMapping(value = "/admin/reviews/setActive/{reviewId}", method = RequestMethod.GET)
    public String reviewsSetActive(@PathVariable long reviewId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        ReviewProduct thisReview = adminService.getReviewById(reviewId, language);
        Review review = thisReview.getReview().getReview();
        review.setStatus(1);
        catalogService.update(review);
        thisReview = adminService.getReviewById(reviewId, language);
        model.addAttribute("thisReview",thisReview);
        List<ReviewProduct> reviews = catalogService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/reviews";
    }

    @RequestMapping(value = "/admin/specials", method = RequestMethod.GET)
    public String specials(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        SpecialProduct thisSpecial = null;
        if(specials.size()>0){
            thisSpecial = specials.iterator().next();
        }
        model.addAttribute("thisSpecial",thisSpecial);
        return "admin/specials";
    }

    @RequestMapping(value = "/admin/specials/{productId}", method = RequestMethod.GET)
    public String specialsId(@PathVariable long productId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        SpecialProduct thisSpecial = null;
        if(specials.size()>0){
            thisSpecial = catalogService.findSpecialProductById(productId, language);
        }
        model.addAttribute("thisSpecial",thisSpecial);
        return "admin/specials";
    }

    @RequestMapping(value = "/admin/specials/setInactive/{productId}", method = RequestMethod.GET)
    public String specialSetInactive(@PathVariable long productId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        SpecialProduct thisSpecial = catalogService.findSpecialProductById(productId, language);
        Special special=thisSpecial.getSpecial();
        special.setStatus(false);
        special.setStatusChanged(new Date());
        adminService.updateSpecial(special);
        thisSpecial = catalogService.findSpecialProductById(productId,language);
        model.addAttribute("thisSpecial",thisSpecial);
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        return "admin/specials";
    }

    @RequestMapping(value = "/admin/specials/setActive/{productId}", method = RequestMethod.GET)
    public String specialSetActive(@PathVariable long productId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        SpecialProduct thisSpecial = catalogService.findSpecialProductById(productId,language);
        Special special=thisSpecial.getSpecial();
        special.setStatus(true);
        special.setStatusChanged(new Date());
        adminService.updateSpecial(special);
        thisSpecial = catalogService.findSpecialProductById(productId,language);
        model.addAttribute("thisSpecial",thisSpecial);
        List<SpecialProduct> specials = catalogService.getSpecialProducts(language);
        model.addAttribute("specials",specials);
        return "admin/specials";
    }
}
