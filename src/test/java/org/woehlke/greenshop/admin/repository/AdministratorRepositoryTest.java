package org.woehlke.greenshop.admin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.admin.entities.Administrator;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class AdministratorRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(AdministratorRepositoryTest.class);

    @Inject
    private AdministratorRepository administratorRepository;

    @Test
    public void getAllTest(){
        List<Administrator> all = administratorRepository.findAll();
        logger.info("------------------------------------------------------");
        for(Administrator one:all){
            logger.info(one.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
