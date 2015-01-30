package org.woehlke.greenshop.customer.service;

import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.repository.CountryRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("countryService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class CountryServiceImpl implements CountryService {

    @Inject
    private CountryRepository countryRepository;

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void createCountry(Country thisCountry) {
        countryRepository.save(thisCountry);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void updateCountry(Country thisCountry) {
        countryRepository.save(thisCountry);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void deleteCountry(Country thisCountry) {
        countryRepository.delete(thisCountry);
    }

    @Override
    public List<Country> findAllCountriesOrderByName() {
        Sort sort = new Sort("name");
        return countryRepository.findAll(sort);
    }

    @Override
    public Country findCountryById(long countryId) {
        return countryRepository.findOne(countryId);
    }
}
