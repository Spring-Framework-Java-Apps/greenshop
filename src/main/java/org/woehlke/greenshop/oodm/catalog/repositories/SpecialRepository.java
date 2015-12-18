package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.Product;
import org.woehlke.greenshop.oodm.catalog.entities.Special;

/**
 * Created by tw on 27.12.14.
 */
public interface SpecialRepository  extends
        JpaRepository<Special,Long> {

        Special findByProduct(Product product);
}
