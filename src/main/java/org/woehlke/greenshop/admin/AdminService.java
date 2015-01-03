package org.woehlke.greenshop.admin;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.woehlke.greenshop.catalog.entities.Manufacturer;

import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
public interface AdminService extends UserDetailsService {

    List<Manufacturer> getAllManufacturers();

    int countProductsOfThisManufacturer(Manufacturer thisManufacturer);

    Manufacturer getManufacturerById(long manufacturerId);

}
