package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.ReviewDescription;
import org.woehlke.greenshop.oodm.catalog.entities.ReviewDescriptionId;

import java.util.List;

/**
 * Created by tw on 25.12.14.
 */
public interface ReviewDescriptionRepository extends
        JpaRepository<ReviewDescription,ReviewDescriptionId> {

        List<ReviewDescription> findByLanguage(Language language);
}
