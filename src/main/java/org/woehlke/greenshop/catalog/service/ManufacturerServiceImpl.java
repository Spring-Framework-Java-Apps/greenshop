package org.woehlke.greenshop.catalog.service;

import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ManufacturerInfo;
import org.woehlke.greenshop.catalog.entities.ManufacturerInfoId;
import org.woehlke.greenshop.catalog.model.Manufacturers;
import org.woehlke.greenshop.catalog.repositories.ManufacturerInfoDao;
import org.woehlke.greenshop.catalog.repositories.ManufacturerInfoRepository;
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

    @Inject
    private ManufacturerInfoRepository manufacturerInfoRepository;

    @Inject
    private ManufacturerInfoDao manufacturerInfoDao;

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAllOrderByName();
    }

    @Override
    public Manufacturer getManufacturerById(long manufacturerId) {
        return manufacturerRepository.findOne(manufacturerId);
    }

    //TODO: doppelte entfernen
    @Override
    public Manufacturers findManufacturers() {
        Sort sort = new Sort(Sort.Direction.ASC,"name");
        List<Manufacturer> manufacturers = manufacturerRepository.findAll(sort);
        Manufacturers m = new Manufacturers();
        m.setManufacturers(manufacturers);
        return m;
    }

    //TODO: doppelte entfernen
    @Override
    public Manufacturer findManufacturerById(Long manufacturerId) {
        return manufacturerRepository.findOne(manufacturerId);
    }

    @Override
    public ManufacturerInfo findManufacturerInfo(long manufacturerId, Language language) {
        Manufacturer manufacturer = manufacturerRepository.findOne(manufacturerId);
        ManufacturerInfoId manufacturerInfoId = new ManufacturerInfoId();
        manufacturerInfoId.setLanguage(language);
        manufacturerInfoId.setManufacturer(manufacturer);
        return manufacturerInfoRepository.findOne(manufacturerInfoId);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public ManufacturerInfo clickManufacturerUrl(ManufacturerInfo manufacturerInfo) {
        manufacturerInfo.addClick();
        return manufacturerInfoDao.update(manufacturerInfo);
    }
}
