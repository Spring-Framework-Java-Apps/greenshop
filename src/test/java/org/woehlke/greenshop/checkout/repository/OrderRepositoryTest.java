package org.woehlke.greenshop.checkout.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.checkout.entities.Order;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class OrderRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(OrderRepositoryTest.class);
	
	@Inject
	private OrderRepository orderRepository;
	
	@Test
	public void getAllTest(){
		List<Order> all = orderRepository.findAll();
		logger.info("------------------------------------------------------");
		for(Order one:all){
			logger.info(one.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
