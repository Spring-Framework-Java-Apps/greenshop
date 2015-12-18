package org.woehlke.greenshop.oodm.checkout.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatus;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class OrderStatusRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(OrderStatusRepositoryTest.class);
	
	@Inject
	private OrderStatusRepository orderStatusRepository;
	
	@Test
	public void getAllTest(){
		List<OrderStatus> all = orderStatusRepository.findAll();
		logger.info("------------------------------------------------------");
		for(OrderStatus one:all){
			logger.info(one.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
