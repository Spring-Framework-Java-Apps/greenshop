package org.woehlke.greenshop.admin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.TaxRate;
import org.woehlke.greenshop.admin.repository.TaxRateRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("taxRateService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class TaxRateServiceImpl implements TaxRateService {

    @Inject
    private TaxRateRepository taxRateRepository;

    @Override
    public List<TaxRate> findAllTaxRates() {
        return taxRateRepository.findAll();
    }

    @Override
    public TaxRate findTaxRateById(long taxRateId) {
        return taxRateRepository.findOne(taxRateId);
    }
}
