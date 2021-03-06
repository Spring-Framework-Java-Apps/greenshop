package org.woehlke.greenshop.oodm.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.greenshop.oodm.admin.entities.TaxClass;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface TaxClassService {

    TaxClass findById(long taxClassId);

    List<TaxClass> findAll();

    Page<TaxClass> findAll(Pageable pageRequest);

    void create(TaxClass thisTaxClass);

    void update(TaxClass thisTaxClass);

    void delete(TaxClass thisTaxClass);

}
