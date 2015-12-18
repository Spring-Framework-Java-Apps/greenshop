package org.woehlke.greenshop.oodm.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.ProductImage;

import javax.inject.Inject;
import java.util.List;

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
        List<ProductImage> all = productImageRepository.findAll();
        logger.info("------------------------------------------------------");
        for (ProductImage p : all){
            logger.info(p.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
