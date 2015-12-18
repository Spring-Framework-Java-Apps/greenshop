package org.woehlke.greenshop.backend.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.backend.AdminMenuCategory;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.Review;
import org.woehlke.greenshop.oodm.catalog.model.ReviewProduct;
import org.woehlke.greenshop.oodm.catalog.service.LanguageService;
import org.woehlke.greenshop.oodm.catalog.service.ReviewService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class ReviewController {

    @Inject
    private LanguageService languageService;

    @Inject
    private ReviewService reviewService;


    @RequestMapping(value = "/admin/reviews", method = RequestMethod.GET)
    public String reviews(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        List<ReviewProduct> reviews = reviewService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        ReviewProduct thisReview = null;
        if(reviews.size()>0){
            thisReview = reviews.iterator().next();
        }
        model.addAttribute("thisReview",thisReview);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/catalog/reviews";
    }

    @RequestMapping(value = "/admin/reviews/{reviewId}", method = RequestMethod.GET)
    public String reviewsId(@PathVariable long reviewId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        List<ReviewProduct> reviews = reviewService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        ReviewProduct thisReview = null;
        if(reviews.size()>0){
            thisReview = reviewService.getReviewById(reviewId, language);
        }
        model.addAttribute("thisReview",thisReview);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/catalog/reviews";
    }

    @RequestMapping(value = "/admin/reviews/setInactive/{reviewId}", method = RequestMethod.GET)
    public String reviewsSetInactive(@PathVariable long reviewId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        ReviewProduct thisReview = reviewService.getReviewById(reviewId, language);
        Review review = thisReview.getReview().getReview();
        review.setStatus(0);
        reviewService.update(review);
        thisReview = reviewService.getReviewById(reviewId, language);
        model.addAttribute("thisReview",thisReview);
        List<ReviewProduct> reviews = reviewService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/catalog/reviews";
    }

    @RequestMapping(value = "/admin/reviews/setActive/{reviewId}", method = RequestMethod.GET)
    public String reviewsSetActive(@PathVariable long reviewId,Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        ReviewProduct thisReview = reviewService.getReviewById(reviewId, language);
        Review review = thisReview.getReview().getReview();
        review.setStatus(1);
        reviewService.update(review);
        thisReview = reviewService.getReviewById(reviewId, language);
        model.addAttribute("thisReview",thisReview);
        List<ReviewProduct> reviews = reviewService.getAllReviews(language);
        model.addAttribute("reviews",reviews);
        int averageRating = thisReview.getReview().getReview().getRating();
        model.addAttribute("averageRating",averageRating);
        return "admin/catalog/reviews";
    }
}
