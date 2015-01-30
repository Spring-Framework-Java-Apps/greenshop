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
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.service.LanguageService;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.entities.OrderStatusHistory;
import org.woehlke.greenshop.checkout.model.OrderStatusHistoryBean;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class OrderStatusHistoryRepositoryTest {
	

	private static final Logger logger = LoggerFactory.getLogger(OrderStatusHistoryRepositoryTest.class);
	
	@Inject
	private OrderStatusHistoryRepository orderStatusHistoryRepository;
	
	@Inject
	private OrderRepository orderRepository;

    @Inject
    private LanguageService languageService;
	
	@Test
	public void getAllTest(){
		List<OrderStatusHistory> all = orderStatusHistoryRepository.findAll();
		logger.info("------------------------------------------------------");
		for(OrderStatusHistory one:all){
			logger.info(one.toString());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findByOrderTest(){
		Language language = languageService.findLanguageByCode("en");
		List<Order> all = orderRepository.findAll();
		logger.info("------------------------------------------------------");
		for(Order one:all){
			List<OrderStatusHistoryBean> beans = orderStatusHistoryRepository.findByOrder(one, language);
			for(OrderStatusHistoryBean bean:beans){
				logger.info(bean.toString());
			}
		}
		logger.info("------------------------------------------------------");
	}
		
}
