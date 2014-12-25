package org.woehlke.greenshop.catalog.repositories;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.catalog.entities.ReviewDescription;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
