package org.woehlke.greenshop.admin.service;

import org.woehlke.greenshop.admin.entities.TaxRate;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface TaxRateService {

    List<TaxRate> findAllTaxRates();

    TaxRate findTaxRateById(long taxRateId);
}
