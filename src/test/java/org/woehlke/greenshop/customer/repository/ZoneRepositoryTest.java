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
import org.woehlke.greenshop.customer.entities.Zone;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ZoneRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(ZoneRepositoryTest.class);
	
	@Inject
	private ZoneRepository zoneRepository;
	
	@Test
	public void findAllTest() throws Exception {
		List<Zone> all = zoneRepository.findAll();
		for(Zone a:all){
			logger.info(a.toString());
		}
	}
	
}
