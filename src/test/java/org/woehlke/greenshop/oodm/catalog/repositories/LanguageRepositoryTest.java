package org.woehlke.greenshop.oodm.catalog.repositories;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.Language;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class LanguageRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(LanguageRepositoryTest.class);
	
	@Inject
	private LanguageRepository languageRepository;
	
	@Test
	public void testGetAll() throws Exception {
		List<Language> all=languageRepository.findAll();
		logger.info("------------------------------------------------------");
		for (Language p : all){
			logger.info(p.toString());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findByCodeTest() throws Exception {
		logger.info("------------------------------------------------------");
		Language p = languageRepository.findByCode("en");
		logger.info("------------------------------------------------------");
		Assert.assertEquals("en", p.getCode());
	}
}
