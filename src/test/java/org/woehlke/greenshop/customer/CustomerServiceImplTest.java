package org.woehlke.greenshop.customer;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.model.CreateNewCustomerFormBean;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CustomerServiceImplTest {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImplTest.class);
	
	@Inject
	private CustomerService customerService;
	
	@Test
	public void dateMapperTest() throws Exception {
		String date = "17/6/1968";
		Date dob = new Date(date);
		String date2 = "01/01/2013";
		Date dob2 = new Date(date);
	}
	
	@Test
	public void createNewCustomerTest() throws Exception {
		String email = "junittest@junittest.de";
		CreateNewCustomerFormBean createNewCustomerFormBean = new CreateNewCustomerFormBean();
		createNewCustomerFormBean.setCountry(81L); // Germany
		createNewCustomerFormBean.setGender("m");
		createNewCustomerFormBean.setDob("01/01/1980");
		createNewCustomerFormBean.setEmailAddress(email);
		createNewCustomerFormBean.setFirstname("firstname");
		createNewCustomerFormBean.setLastname("lastname");
		createNewCustomerFormBean.setNewsletter(true);
		createNewCustomerFormBean.setPassword("password");
		createNewCustomerFormBean.setPostcode("10551");
		createNewCustomerFormBean.setState("Berlin");
		createNewCustomerFormBean.setStreetAddress("Turmstrasse 48");
		createNewCustomerFormBean.setTelephone("03012345678");
		createNewCustomerFormBean.setCity("Berlin");
		createNewCustomerFormBean.setSuburb("Moabit");
		createNewCustomerFormBean.setCompany("Company GmbH");
		logger.info("------------------------------------------------------");
		customerService.createNewCustomer(createNewCustomerFormBean);
		Customer c = customerService.findCustomerByEmail(email);
		customerService.deleteCustomer(c);
		logger.info("------------------------------------------------------");
	}
}
