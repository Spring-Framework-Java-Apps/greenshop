package org.woehlke.greenshop.catalog.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.ManufacturerInfo;

import javax.inject.Inject;

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
        for (ManufacturerInfo p : manufacturerInfoRepository.findAll()){
            logger.info(p.toString());
        }
    }
}
