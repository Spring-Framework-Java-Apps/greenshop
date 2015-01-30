package org.woehlke.greenshop.admin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.TaxZone;
import org.woehlke.greenshop.admin.entities.TaxZone2Zone;
import org.woehlke.greenshop.admin.repository.TaxZone2ZoneRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("taxZone2ZoneService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class TaxZone2ZoneServiceImpl implements TaxZone2ZoneService {

    @Inject
    private TaxZone2ZoneRepository taxZone2ZoneRepository;

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void createTaxZone2Zone(TaxZone2Zone newTaxZone2Zone) {
        taxZone2ZoneRepository.save(newTaxZone2Zone);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void deleteTaxZone2Zone(TaxZone2Zone thisZone) {
        taxZone2ZoneRepository.delete(thisZone);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void updateTaxZone2Zone(TaxZone2Zone thisZone) {
        taxZone2ZoneRepository.save(thisZone);
    }

    @Override
    public int getNumberOfZonesForTaxZone(TaxZone thisTaxZone) {
        return taxZone2ZoneRepository.findByTaxZone(thisTaxZone).size();
    }

    @Override
    public List<TaxZone2Zone> findZonesByTaxZone(TaxZone thisTaxZone) {
        return taxZone2ZoneRepository.findByTaxZone(thisTaxZone);
    }

    @Override
    public TaxZone2Zone findTaxZone2ZoneById(long zoneId) {
        return taxZone2ZoneRepository.findOne(zoneId);
    }
}
