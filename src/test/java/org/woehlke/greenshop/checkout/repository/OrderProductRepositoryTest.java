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
import org.woehlke.greenshop.checkout.entities.OrderProduct;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class OrderProductRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(OrderProductRepositoryTest.class);
	
	@Inject
	private OrderProductRepository orderProductRepository;
	
	@Test
	public void getAllTest(){
		List<OrderProduct> all = orderProductRepository.findAll();
		logger.info("------------------------------------------------------");
		for(OrderProduct one:all){
			logger.info(one.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
