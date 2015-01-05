package org.woehlke.greenshop.admin;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.woehlke.greenshop.admin.entities.Administrator;
import org.woehlke.greenshop.admin.entities.TaxClass;
import org.woehlke.greenshop.admin.entities.TaxRate;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.Special;
import org.woehlke.greenshop.catalog.model.ReviewProduct;

import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
public interface AdminService extends UserDetailsService {

    List<Manufacturer> getAllManufacturers();

    int countProductsOfThisManufacturer(Manufacturer thisManufacturer);

    Manufacturer getManufacturerById(long manufacturerId);

    void updateSpecial(Special special);

    ReviewProduct getReviewById(long reviewId, Language language);

    List<Administrator> findAllAdministrators();

    Administrator findAdministratorById(long administratorId);

    List<TaxClass> findAllTaxClasses();

    TaxClass findTaxClassById(long taxClassId);

    List<TaxRate> findAllTaxRates();

    TaxRate findTaxRateById(long taxRateId);
}
