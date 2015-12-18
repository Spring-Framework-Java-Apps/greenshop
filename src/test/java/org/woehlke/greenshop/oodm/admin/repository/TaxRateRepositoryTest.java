package org.woehlke.greenshop.oodm.admin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.admin.entities.TaxRate;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 05.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class TaxRateRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(TaxRateRepositoryTest.class);

    @Inject
    private TaxRateRepository taxRateRepository;

    @Test
    public void getAllTest(){
        List<TaxRate> all = taxRateRepository.findAll();
        logger.info("------------------------------------------------------");
        for(TaxRate one:all){
            logger.info(one.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
