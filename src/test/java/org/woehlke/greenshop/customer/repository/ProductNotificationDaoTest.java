package org.woehlke.greenshop.customer.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.entities.ProductNotification;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 24.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductNotificationDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductNotificationDaoTest.class);

    @Inject
    private ProductNotificationDao productNotificationDao;

    @Inject
    private CustomerRepository customerRepository;

    @Test
    public void findAllTest() throws Exception {
        List<Customer> all = customerRepository.findAll();
        for(Customer customer:all){
            List<ProductNotification> productNotificationList =
                    productNotificationDao.findAllProductNotificationsForCustomerId(customer.getId());
            for(ProductNotification productNotification :productNotificationList){
                logger.info(productNotification.toString());
            }
        }
    }
}
