package org.woehlke.greenshop.oodm.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.admin.entities.TaxZone;
import org.woehlke.greenshop.oodm.admin.entities.TaxZone2Zone;
import org.woehlke.greenshop.oodm.admin.repository.TaxZone2ZoneRepository;
import org.woehlke.greenshop.oodm.admin.repository.TaxZoneRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("taxZoneService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class TaxZoneServiceImpl implements TaxZoneService {

    @Inject
    private TaxZoneRepository taxZoneRepository;

    @Inject
    private TaxZone2ZoneRepository taxZone2ZoneRepository;

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public TaxZone createTaxZone(TaxZone thisTaxZone) {
        return taxZoneRepository.save(thisTaxZone);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void deleteTaxZones(TaxZone thisTaxZone) {
        TaxZone tz =taxZoneRepository.findOne(thisTaxZone.getId());
        List<TaxZone2Zone> list = taxZone2ZoneRepository.findByTaxZone(tz);
        taxZone2ZoneRepository.delete(list);
        taxZoneRepository.delete(tz);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void updateTaxZone(TaxZone thisTaxZone) {
        TaxZone tz =taxZoneRepository.findOne(thisTaxZone.getId());
        tz.setLastModified(new Date());
        tz.setName(thisTaxZone.getName());
        tz.setDescription(thisTaxZone.getDescription());
        taxZoneRepository.save(tz);
    }

    @Override
    public List<TaxZone> findAll() {
        return taxZoneRepository.findAll();
    }

    @Override
    public Page<TaxZone> findAllTaxZones(Pageable pageRequest) {
        return taxZoneRepository.findAll(pageRequest);
    }

    @Override
    public TaxZone findTaxZoneById(long taxZoneId) {
        return taxZoneRepository.findOne(taxZoneId);
    }
}
