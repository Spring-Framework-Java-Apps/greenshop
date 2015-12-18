package org.woehlke.greenshop.oodm.catalog.repositories;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.oodm.catalog.entities.Language;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CategoryDescriptionRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryDescriptionRepositoryTest.class);
	
	@Inject
	private CategoryDescriptionRepository categoryDescriptionRepository;
	
	@Inject
	private CategoryDescriptionRepositoryDao categoryDescriptionRepositoryDao;
	
	@Inject
	private LanguageRepository languageRepository;
	
	@Test
	public void testGetAll() throws Exception {
		List<CategoryDescription> all=categoryDescriptionRepository.findAll();
		logger.info("------------------------------------------------------");
		for (CategoryDescription p : all){
			logger.info(p.toString());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findRootCategoriesTest() throws Exception {
		Language language=languageRepository.findByCode("en");
		List<CategoryDescription> all=categoryDescriptionRepositoryDao.findRootCategories(language);
		logger.info("------------------------------------------------------");
		for (CategoryDescription p : all){
			Assert.assertEquals(0L, p.getCategory().getParentId());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findCategoriesByParentIdTest() throws Exception {
		Language language=languageRepository.findByCode("en");
		logger.info("------------------------------------------------------");
		for (CategoryDescription p : categoryDescriptionRepositoryDao.findRootCategories(language)){
			for (CategoryDescription p2 : categoryDescriptionRepositoryDao.findCategoriesByParentId(p.getCategory().getId(),language)){
				Assert.assertEquals(p.getCategory().getId().longValue(), p2.getCategory().getParentId());
			}	
		}
		logger.info("------------------------------------------------------");
	}
}
