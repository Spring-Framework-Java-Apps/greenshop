package org.woehlke.greenshop.catalog.service;

import org.woehlke.greenshop.catalog.entities.Manufacturer;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface ManufacturerService {

    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(long manufacturerId);
}
