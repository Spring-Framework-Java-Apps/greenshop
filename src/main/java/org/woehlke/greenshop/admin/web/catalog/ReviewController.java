package org.woehlke.greenshop.admin.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.AdminService;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Review;
import org.woehlke.greenshop.catalog.model.ReviewProduct;
import org.woehlke.greenshop.catalog.service.LanguageService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class ReviewController {

    @Inject
    private AdminService adminService;

    @Inject
    private CatalogService catalogService;

    @Inject
    private LanguageService languageService;

    @RequestMapping(value = "/admin/reviews", method = RequestMethod.GET)
    public String reviews(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
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
        Language language = languageService.findLanguageByCode("en");
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
        Language language = languageService.findLanguageByCode("en");
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
        Language language = languageService.findLanguageByCode("en");
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
}
