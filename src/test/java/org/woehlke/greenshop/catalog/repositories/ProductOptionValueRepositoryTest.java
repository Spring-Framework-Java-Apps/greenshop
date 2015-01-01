package org.woehlke.greenshop.catalog.repositories;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.ProductOptionValue;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductOptionValueRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(ProductOptionValueRepositoryTest.class);
	
	@Inject
	private ProductOptionValueRepository productOptionValueRepository;
	
	@Test
	public void findAllTest() throws Exception {
		List<ProductOptionValue> list = productOptionValueRepository.findAll();
		logger.info("------------------------------------------------------");
		for(ProductOptionValue productOption:list){
			logger.info("# "+productOption.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
