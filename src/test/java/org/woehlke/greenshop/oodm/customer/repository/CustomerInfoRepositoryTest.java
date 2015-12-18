package org.woehlke.greenshop.oodm.customer.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.customer.entities.CustomerInfo;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 24.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CustomerInfoRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Inject
    private CustomerInfoRepository customerInfoRepository;

    @Test
    public void findAllTest() throws Exception {
        List<CustomerInfo> all = customerInfoRepository.findAll();
        logger.info("------------------------------------------------------");
        for(CustomerInfo a:all){
            logger.info(a.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
