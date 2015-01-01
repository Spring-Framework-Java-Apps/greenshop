package org.woehlke.greenshop.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.Review;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 25.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ReviewRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ReviewRepositoryTest.class);

    @Inject
    private ReviewRepository reviewRepository;

    @Test
    public void testGetAll() throws Exception {
        List<Review> all = reviewRepository.findAll();
        logger.info("------------------------------------------------------");
        for (Review p : all){
            logger.info(p.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
