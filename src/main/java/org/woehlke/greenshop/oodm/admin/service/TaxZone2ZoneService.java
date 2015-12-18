package org.woehlke.greenshop.oodm.admin.service;

import org.woehlke.greenshop.oodm.admin.entities.TaxZone;
import org.woehlke.greenshop.oodm.admin.entities.TaxZone2Zone;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface TaxZone2ZoneService {

    int getNumberOfZonesForTaxZone(TaxZone thisTaxZone);

    void createTaxZone2Zone(TaxZone2Zone newTaxZone2Zone);

    void deleteTaxZone2Zone(TaxZone2Zone thisZone);

    void updateTaxZone2Zone(TaxZone2Zone thisZone);

    List<TaxZone2Zone> findZonesByTaxZone(TaxZone thisTaxZone);

    TaxZone2Zone findTaxZone2ZoneById(long zoneId);
}
