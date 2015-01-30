package org.woehlke.greenshop.admin.service;

import org.woehlke.greenshop.admin.entities.TaxZone;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface TaxZoneService {

    List<TaxZone> findAllTaxZones();

    TaxZone findTaxZoneById(long taxZoneId);

    void deleteTaxZones(TaxZone thisTaxZone);

    void updateTaxZone(TaxZone thisTaxZone);

    TaxZone createTaxZone(TaxZone thisTaxZone);
}
