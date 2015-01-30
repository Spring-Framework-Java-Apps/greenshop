package org.woehlke.greenshop.customer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.customer.entities.Country;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CountryServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImplTest.class);

    @Inject
    private CountryService countryService;

    @Test
    public void findAllCountriesOrderByNameTest() throws Exception {
        List<Country> all = countryService.findAllCountriesOrderByName();
        logger.info("------------------------------------------------------");
        for(Country one:all){
            logger.info(one.getName());
        }
        logger.info("------------------------------------------------------");
    }
}
