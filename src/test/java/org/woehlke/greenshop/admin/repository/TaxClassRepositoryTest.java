package org.woehlke.greenshop.admin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.admin.entities.TaxClass;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 05.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class TaxClassRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(TaxClassRepositoryTest.class);

    @Inject
    private TaxClassRepository taxClassRepository;

    @Test
    public void getAllTest(){
        List<TaxClass> all = taxClassRepository.findAll();
        logger.info("------------------------------------------------------");
        for(TaxClass one:all){
            logger.info(one.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
