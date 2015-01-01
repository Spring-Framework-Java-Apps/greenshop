package org.woehlke.greenshop.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.ProductImage;

import javax.inject.Inject;

/**
 * Created by tw on 01.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductImageRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductImageRepositoryTest.class);

    @Inject
    private ProductImageRepository productImageRepository;

    @Test
    public void testGetAll() throws Exception {
        for (ProductImage p : productImageRepository.findAll()){
            logger.info(p.toString());
        }
    }
}
