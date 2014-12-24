package org.woehlke.greenshop.customer.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.customer.entities.ProductNotification;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 24.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductNotificationRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductNotificationRepositoryTest.class);

    @Inject
    private ProductNotificationRepository productNotificationRepository;

    @Test
    public void findAllTest() throws Exception {
        List<ProductNotification> all = productNotificationRepository.findAll();
        for(ProductNotification a:all){
            logger.info(a.toString());
        }
    }
}
