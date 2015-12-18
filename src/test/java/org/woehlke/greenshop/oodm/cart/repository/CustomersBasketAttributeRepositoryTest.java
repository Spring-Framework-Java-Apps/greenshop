package org.woehlke.greenshop.oodm.cart.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.cart.entities.CustomersBasketAttribute;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CustomersBasketAttributeRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(CustomersBasketAttributeRepositoryTest.class);
	
	@Inject
	private CustomersBasketAttributeRepository customersBasketAttributeRepository;
	
	@Test
	public void getAllTest(){
		List<CustomersBasketAttribute> all = customersBasketAttributeRepository.findAll();
		logger.info("------------------------------------------------------");
		for(CustomersBasketAttribute one:all){
			logger.info(one.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
