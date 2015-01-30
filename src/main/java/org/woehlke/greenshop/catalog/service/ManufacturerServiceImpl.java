package org.woehlke.greenshop.catalog.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.repositories.ManufacturerRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("manufacturerService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class ManufacturerServiceImpl implements ManufacturerService {

    @Inject
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAllOrderByName();
    }

    @Override
    public Manufacturer getManufacturerById(long manufacturerId) {
        return manufacturerRepository.findOne(manufacturerId);
    }
}
