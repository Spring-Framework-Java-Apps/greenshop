package org.woehlke.greenshop.customer.service;

import org.woehlke.greenshop.customer.entities.Country;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface CountryService {

    void createCountry(Country thisCountry);

    void updateCountry(Country thisCountry);

    void deleteCountry(Country thisCountry);

    List<Country> findAllCountriesOrderByName();

    Country findCountryById(long countryId);

}
