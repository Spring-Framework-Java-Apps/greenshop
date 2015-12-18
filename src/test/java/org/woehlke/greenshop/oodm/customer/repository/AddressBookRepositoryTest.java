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
import org.woehlke.greenshop.oodm.customer.entities.AddressBook;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class AddressBookRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(AddressBookRepositoryTest.class);
	
	@Inject
	private AddressBookRepository addressBookRepository;
	
	@Test
	public void findAllTest() throws Exception {
		List<AddressBook> all = addressBookRepository.findAll();
		logger.info("------------------------------------------------------");
		for(AddressBook a:all){
			logger.info(a.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
