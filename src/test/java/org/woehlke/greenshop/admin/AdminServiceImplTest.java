package org.woehlke.greenshop.admin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.customer.entities.Zone;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by tw on 29.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class AdminServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImplTest.class);

    @Inject
    private AdminService adminService;

    @Test
    public void getZoneMapTest() throws Exception {
        logger.info("------------------------------------------------------");
        Map<Long, List<Zone>> zoneMap = adminService.getZoneMap();
        logger.info("------------------------------------------------------");
        for(Long countryId:zoneMap.keySet()){
            logger.info("## CountryId: "+countryId+" ##");
            for(Zone zone: zoneMap.get(countryId)){
                logger.info("#### Zone: "+zone.toString());
                Assert.assertEquals(countryId,zone.getCountry().getId());
            }
        }
        logger.info("------------------------------------------------------");
    }
}
