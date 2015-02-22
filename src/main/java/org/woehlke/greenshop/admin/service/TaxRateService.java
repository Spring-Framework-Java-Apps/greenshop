package org.woehlke.greenshop.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.greenshop.admin.entities.TaxRate;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface TaxRateService {

    Page<TaxRate> findAll(Pageable pageRequest);

    TaxRate findById(long taxRateId);

    void delete(TaxRate thisTaxRate);

    void update(TaxRate loadedTaxRate);

    void create(TaxRate thisTaxRate);

}
