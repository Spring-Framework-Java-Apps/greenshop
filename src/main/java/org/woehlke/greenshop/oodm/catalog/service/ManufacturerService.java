package org.woehlke.greenshop.oodm.catalog.service;

import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.Manufacturer;
import org.woehlke.greenshop.oodm.catalog.entities.ManufacturerInfo;
import org.woehlke.greenshop.oodm.catalog.model.Manufacturers;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface ManufacturerService {

    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(long manufacturerId);

    Manufacturers findManufacturers();

    Manufacturer findManufacturerById(Long manufacturerId);

    ManufacturerInfo findManufacturerInfo(long manufacturerId, Language language);

    ManufacturerInfo clickManufacturerUrl(ManufacturerInfo manufacturerInfo);
}
