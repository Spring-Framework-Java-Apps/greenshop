package org.woehlke.greenshop.oodm.customer.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.customer.entities.AddressFormat;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class AddressFormatRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AddressFormatRepositoryTest.class);
	
	@Inject
	private AddressFormatRepository addressFormatRepository;
	
	@Test
	public void findAllTest() throws Exception {
		List<AddressFormat> all = addressFormatRepository.findAll();
		logger.info("------------------------------------------------------");
		for(AddressFormat a:all){
			logger.info(a.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
