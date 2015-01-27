package org.woehlke.greenshop.admin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.admin.entities.TaxZone2Zone;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 27.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class TaxZone2ZoneRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(TaxZone2ZoneRepositoryTest.class);

    @Inject
    private TaxZone2ZoneRepository taxZone2ZoneRepository;

    @Test
    public void getAllTest(){
        List<TaxZone2Zone> all = taxZone2ZoneRepository.findAll();
        logger.info("------------------------------------------------------");
        for(TaxZone2Zone one:all){
            logger.info(one.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
