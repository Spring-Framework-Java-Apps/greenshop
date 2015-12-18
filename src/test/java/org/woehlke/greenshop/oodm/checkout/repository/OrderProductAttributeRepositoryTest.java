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
import org.woehlke.greenshop.oodm.checkout.entities.OrderProductAttribute;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class OrderProductAttributeRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(OrderProductAttributeRepositoryTest.class);
	
	@Inject
	private OrderProductAttributeRepository orderProductAttributeRepository;
	
	@Test
	public void getAllTest(){
		List<OrderProductAttribute> all = orderProductAttributeRepository.findAll();
		logger.info("------------------------------------------------------");
		for(OrderProductAttribute one:all){
			logger.info(one.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
