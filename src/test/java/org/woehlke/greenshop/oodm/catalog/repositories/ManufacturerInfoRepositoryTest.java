package org.woehlke.greenshop.oodm.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.ManufacturerInfo;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 24.12.14.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ManufacturerInfoRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ManufacturerInfoRepositoryTest.class);

    @Inject
    private ManufacturerInfoRepository manufacturerInfoRepository;

    @Test
    public void testGetAll() throws Exception {
        List<ManufacturerInfo> all = manufacturerInfoRepository.findAll();
        logger.info("------------------------------------------------------");
        for (ManufacturerInfo p : all){
            logger.info(p.toString());
        }
        logger.info("------------------------------------------------------");
    }
}
