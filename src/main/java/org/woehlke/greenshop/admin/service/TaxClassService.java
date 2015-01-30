package org.woehlke.greenshop.admin.service;

import org.woehlke.greenshop.admin.entities.TaxClass;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface TaxClassService {

    List<TaxClass> findAllTaxClasses();

    TaxClass findTaxClassById(long taxClassId);
}
