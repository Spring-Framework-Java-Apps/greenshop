package org.woehlke.greenshop.oodm.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.Special;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 27.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class SpecialRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(SpecialRepositoryTest.class);

    @Inject
    private SpecialRepository specialRepository;

    @Test
    public void testGetAll() throws Exception {
        List<Special> all = specialRepository.findAll();
        logger.info("------------------------------------------------------");
        for (Special p : all){
            logger.info(p.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
