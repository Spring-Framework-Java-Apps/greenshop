package org.woehlke.greenshop.oodm.catalog.repositories;

import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.Product;
import org.woehlke.greenshop.oodm.catalog.entities.ReviewDescription;

import java.util.List;

/**
 * Created by tw on 25.12.14.
 */
public interface ReviewDescriptionDao {

    ReviewDescription create(ReviewDescription reviewDescription);

    List<ReviewDescription> findReviewsForProductAndLanguage(Product product, Language language);

    ReviewDescription findReviewsForReviewIdAndLanguage(long reviewId, Language language);
}
