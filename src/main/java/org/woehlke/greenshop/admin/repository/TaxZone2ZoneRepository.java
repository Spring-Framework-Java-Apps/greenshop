package org.woehlke.greenshop.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.admin.entities.TaxZone;
import org.woehlke.greenshop.admin.entities.TaxZone2Zone;

import java.util.List;


/**
 * Created by tw on 27.01.15.
 */
public interface TaxZone2ZoneRepository extends JpaRepository<TaxZone2Zone, Long> {

    List<TaxZone2Zone> findByTaxZone(TaxZone thisTaxZone);
}
