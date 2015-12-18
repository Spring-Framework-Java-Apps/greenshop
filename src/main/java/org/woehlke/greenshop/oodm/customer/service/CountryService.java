package org.woehlke.greenshop.oodm.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.greenshop.oodm.customer.entities.Country;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface CountryService {

    void createCountry(Country thisCountry);

    void updateCountry(Country thisCountry);

    void deleteCountry(Country thisCountry);

    Page<Country> findAllCountriesOrderByName(Pageable pageRequest);

    List<Country> findAllCountriesOrderByName();

    Country findCountryById(long countryId);

}
