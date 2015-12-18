package org.woehlke.greenshop.oodm.catalog.repositories;

import java.util.List;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.Manufacturer;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductDescriptionRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(ProductDescriptionRepositoryTest.class);
	
	@Inject
	private ProductDescriptionRepository productDescriptionRepository; 
	
	@Inject
	private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;
	
	@Inject
	private LanguageRepository languageRepository;
	
	@Inject
	private ManufacturerRepository manufacturerRepository;
	
	@Test
	public void testGetAll() throws Exception {
		List<ProductDescription> all = productDescriptionRepository.findAll();
		logger.info("------------------------------------------------------");
		for (ProductDescription p : all){
			logger.info("* "+p.toString());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findByLanguageOrderByProductDateAddedTest() throws Exception {
		Language language=languageRepository.findByCode("en");
		int limit = 9;
		List<ProductDescription> page = productDescriptionRepositoryDao.findByLanguageOrderByDateAdded(language, limit);
		logger.info("------------------------------------------------------");
		for (ProductDescription p : page){
			logger.info("# "+p.toString());
			Assert.assertEquals(language.getId(), p.getLanguage().getId());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findByManufacturerTest()  throws Exception {
		Language language=languageRepository.findByCode("en");
		Manufacturer manufacturer =  manufacturerRepository.findOne(4L);
		List<ProductDescription> page = productDescriptionRepositoryDao.findByManufacturer(manufacturer, language);
		logger.info("------------------------------------------------------");
		for (ProductDescription p : page){
			logger.info("@ "+p.toString());
			Assert.assertEquals(manufacturer.getId(), p.getProduct().getManufacturer().getId());
			Assert.assertEquals(language.getId(), p.getLanguage().getId());
		}
		logger.info("------------------------------------------------------");
	}
	
}
