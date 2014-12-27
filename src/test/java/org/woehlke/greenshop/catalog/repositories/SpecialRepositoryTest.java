package org.woehlke.greenshop.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.Special;

import javax.inject.Inject;

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
        for (Special p : specialRepository.findAll()){
            logger.info(p.toString());
        }
    }
}
