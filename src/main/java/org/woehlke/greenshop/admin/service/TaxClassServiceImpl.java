package org.woehlke.greenshop.admin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.TaxClass;
import org.woehlke.greenshop.admin.repository.TaxClassRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("taxClassService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class TaxClassServiceImpl implements TaxClassService {

    @Inject
    private TaxClassRepository taxClassRepository;

    @Override
    public List<TaxClass> findAllTaxClasses() {
        return taxClassRepository.findAll();
    }

    @Override
    public TaxClass findTaxClassById(long taxClassId) {
        return taxClassRepository.findOne(taxClassId);
    }
}
