package org.woehlke.greenshop.oodm.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.admin.entities.TaxClass;
import org.woehlke.greenshop.oodm.admin.repository.TaxClassRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
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
    public TaxClass findById(long taxClassId) {
        return taxClassRepository.findOne(taxClassId);
    }

    @Override
    public List<TaxClass> findAll() {
        return taxClassRepository.findAll();
    }

    @Override
    public Page<TaxClass> findAll(Pageable pageRequest) {
        return taxClassRepository.findAll(pageRequest);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void create(TaxClass thisTaxClass) {
        thisTaxClass.setDateAdded(new Date());
        thisTaxClass=taxClassRepository.save(thisTaxClass);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void update(TaxClass thisTaxClass) {
        thisTaxClass.setLastModified(new Date());
        thisTaxClass=taxClassRepository.save(thisTaxClass);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void delete(TaxClass thisTaxClass) {
        taxClassRepository.delete(thisTaxClass);
    }
}
