package org.woehlke.greenshop.catalog.repositories;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Product;
import org.woehlke.greenshop.catalog.entities.ReviewDescription;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tw on 25.12.14.
 */
@Repository
public class ReviewDescriptionDaoImpl implements ReviewDescriptionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ReviewDescription create(ReviewDescription reviewDescription) {
        entityManager.persist(reviewDescription);
        return reviewDescription;
    }

    @Override
    public List<ReviewDescription> findReviewsForProductAndLanguage(Product product, Language language) {
        TypedQuery<ReviewDescription> query = entityManager.createQuery(
                "select r from ReviewDescription r where r.language=:language and r.review.product=:product",
                ReviewDescription.class);
        query.setParameter("language",language);
        query.setParameter("product",product);
        return query.getResultList();
    }

    @Override
    public ReviewDescription findReviewsForReviewIdAndLanguage(long reviewId, Language language) {
        TypedQuery<ReviewDescription> query = entityManager.createQuery(
                "select r from ReviewDescription r where r.language=:language and r.review.id=:reviewId",
                ReviewDescription.class);
        query.setParameter("language",language);
        query.setParameter("reviewId",reviewId);
        return query.getSingleResult();
    }
}
