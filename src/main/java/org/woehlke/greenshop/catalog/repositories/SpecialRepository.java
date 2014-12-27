package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.Special;

/**
 * Created by tw on 27.12.14.
 */
public interface SpecialRepository  extends
        JpaRepository<Special,Long> {
}
