package org.woehlke.greenshop.customer.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.customer.entities.Country;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CountryRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(CountryRepositoryTest.class);
	
	@Inject
	private CountryRepository countryRepository;
	
	@Test
	public void findAllTest() throws Exception {
		List<Country> all = countryRepository.findAll();
		logger.info("------------------------------------------------------");
		for(Country a:all){
			logger.info(a.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
