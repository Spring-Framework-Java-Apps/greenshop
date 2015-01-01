package org.woehlke.greenshop.catalog.repositories;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.Product;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);
	
	@Inject
	private ProductRepository productRepository;
	
	@Test
	public void testGetAll() throws Exception {
		List<Product> all = productRepository.findAll();
		logger.info("------------------------------------------------------");
		for (Product p : all){
			logger.info(p.toString());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findByMonthTest() throws Exception {
		int month=12;
		int year=2012;
		List<Product> list = productRepository.findByMonth(month,year);
		logger.info("------------------------------------------------------");
		for (Product p : list){
			logger.info(p.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
