package org.woehlke.greenshop.oodm.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.greenshop.oodm.admin.entities.TaxZone;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface TaxZoneService {

    List<TaxZone> findAll();

    Page<TaxZone> findAllTaxZones(Pageable pageRequest);

    TaxZone findTaxZoneById(long taxZoneId);

    void deleteTaxZones(TaxZone thisTaxZone);

    void updateTaxZone(TaxZone thisTaxZone);

    TaxZone createTaxZone(TaxZone thisTaxZone);
}
