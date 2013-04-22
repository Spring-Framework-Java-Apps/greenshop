package org.woehlke.greenshop.customer.repository;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.customer.entities.Customer;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CustomerRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);
	
	@Inject
	private CustomerRepository customerRepository;
	
	@Test
	public void findAllTest() throws Exception {
		List<Customer> all = customerRepository.findAll();
		for(Customer a:all){
			logger.info(a.toString());
		}	
	}
}
