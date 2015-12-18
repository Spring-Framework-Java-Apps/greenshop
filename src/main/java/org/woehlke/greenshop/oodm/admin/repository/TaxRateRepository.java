package org.woehlke.greenshop.oodm.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.admin.entities.TaxRate;

/**
 * Created by tw on 05.01.15.
 */
public interface TaxRateRepository extends JpaRepository<TaxRate, Long> {
}
