package org.woehlke.greenshop.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.TaxRate;
import org.woehlke.greenshop.admin.repository.TaxRateRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

/**
 * Created by tw on 30.01.15.
 */
@Named("taxRateService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class TaxRateServiceImpl implements TaxRateService {

    @Inject
    private TaxRateRepository taxRateRepository;

    @Override
    public Page<TaxRate> findAll(Pageable pageRequest) {
        return taxRateRepository.findAll(pageRequest);
    }

    @Override
    public TaxRate findById(long taxRateId) {
        return taxRateRepository.findOne(taxRateId);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void delete(TaxRate thisTaxRate) {
        taxRateRepository.delete(thisTaxRate);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void update(TaxRate loadedTaxRate) {
        taxRateRepository.save(loadedTaxRate);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void create(TaxRate thisTaxRate) {
        thisTaxRate.setDateAdded(new Date());
        taxRateRepository.save(thisTaxRate);
    }
}
