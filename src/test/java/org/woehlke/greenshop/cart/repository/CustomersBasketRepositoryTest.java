package org.woehlke.greenshop.cart.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.cart.entities.CustomersBasket;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CustomersBasketRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(CustomersBasketRepositoryTest.class);
	
	@Inject
	private CustomersBasketRepository customersBasketRepository;
	
	@Test
	public void getAllTest(){
		List<CustomersBasket> all = customersBasketRepository.findAll();
		logger.info("------------------------------------------------------");
		for(CustomersBasket one:all){
			logger.info(one.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
