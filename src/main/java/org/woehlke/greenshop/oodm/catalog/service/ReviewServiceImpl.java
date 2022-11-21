package org.woehlke.greenshop.oodm.catalog.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.catalog.entities.*;
import org.woehlke.greenshop.oodm.catalog.model.ReviewProduct;
import org.woehlke.greenshop.oodm.catalog.model.WriteReviewBean;
import org.woehlke.greenshop.oodm.catalog.repositories.*;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by tw on 30.01.15.
 */
@Named("reviewService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class ReviewServiceImpl implements ReviewService {

    @Inject
    private ProductDescriptionRepository productDescriptionRepository;

    @Inject
    private ReviewDescriptionRepository reviewDescriptionRepository;

    @Inject
    private ReviewRepository reviewRepository;

    @Inject
    private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;

    @Inject
    private ReviewDescriptionDao reviewDescriptionDao;

    @Inject
    private LanguageRepository languageRepository;

    @Override
    public ReviewProduct getReviewById(long reviewId, Language language) {
        Review review = reviewRepository.getOne(reviewId);
        ReviewDescriptionId reviewDescriptionId = new ReviewDescriptionId();
        reviewDescriptionId.setLanguage(language);
        reviewDescriptionId.setReview(review);
        ReviewDescription reviewDescription = reviewDescriptionRepository.getOne(reviewDescriptionId);
        ProductDescriptionId id = new ProductDescriptionId();
        id.setLanguage(language);
        id.setProduct(review.getProduct());
        ProductDescription productDescription=productDescriptionRepository.getOne(id);
        ReviewProduct reviewProduct = new ReviewProduct();
        reviewProduct.setProduct(productDescription);
        reviewProduct.setReview(reviewDescription);
        return reviewProduct;
    }

    @Override
    public List<ReviewProduct> getAllReviews(Language language) {
        List<ReviewProduct> reviews = new ArrayList<ReviewProduct>();
        List<ReviewDescription> reviewDescriptions =
                reviewDescriptionRepository.findByLanguage(language);
        for(ReviewDescription reviewDescription:reviewDescriptions){
            ReviewProduct review = new ReviewProduct();
            review.setReview(reviewDescription);
            ProductDescription productDescription =
                    productDescriptionRepositoryDao.findByProductIdAndLanguage(
                            reviewDescription.getReview().getProduct().getId(),language);
            review.setProduct(productDescription);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void update(Review review) {
        review=reviewRepository.save(review);
    }



    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public ReviewDescription saveReview(WriteReviewBean writeReviewBean,
                                        Product product, Customer customer, Language language) {
        language=languageRepository.getOne(language.getId());
        ReviewDescription reviewDescription = new ReviewDescription();
        Review review = new Review();
        if(customer==null){
            review.setCustomersId(0L);
        } else {
            review.setCustomersId(customer.getId());
        }
        review.setProduct(product);
        review.setCustomersName(customer.getFirstname()+" "+customer.getLastname());
        review.setDateAdded(new Date());
        review.setRating(writeReviewBean.getRating());
        review.setStatus(1);
        review.setReviewsRead(0);
        review=reviewRepository.save(review);
        reviewDescription.setReview(review);
        reviewDescription.setLanguage(language);
        reviewDescription.setReviewText(writeReviewBean.getReviewText());
        reviewDescription=reviewDescriptionDao.create(reviewDescription);
        return reviewDescription;
    }

    @Override
    public List<ReviewDescription> findReviewsForProduct(ProductDescription productDescription) {
        return reviewDescriptionDao.findReviewsForProductAndLanguage(
                productDescription.getProduct(), productDescription.getLanguage());
    }

    @Override
    public ReviewDescription findReviewById(long reviewId, Language language) {
        return reviewDescriptionDao.findReviewsForReviewIdAndLanguage(reviewId, language);
    }

    @Override
    public ReviewDescription getRandomReview(Language language) {
        List<Review> reviews=reviewRepository.findAll();
        int listLength = reviews.size();
        Random random = new Random();
        int index = random.nextInt(listLength);
        Review review = reviews.get(index);
        return reviewDescriptionDao.findReviewsForReviewIdAndLanguage(review.getId(), language);
    }
}
