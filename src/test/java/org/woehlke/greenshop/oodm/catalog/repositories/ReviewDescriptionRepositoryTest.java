package org.woehlke.greenshop.oodm.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.ReviewDescription;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 25.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ReviewDescriptionRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ReviewDescriptionRepositoryTest.class);

    @Inject
    private ReviewDescriptionRepository reviewDescriptionRepository;

    @Test
    public void testGetAll() throws Exception {
        List<ReviewDescription> all = reviewDescriptionRepository.findAll();
        logger.info("------------------------------------------------------");
        for (ReviewDescription p : all){
            logger.info(p.toString());
        }
        logger.info("------------------------------------------------------");
    }

}
