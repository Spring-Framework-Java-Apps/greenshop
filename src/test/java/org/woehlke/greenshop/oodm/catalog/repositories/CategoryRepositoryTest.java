package org.woehlke.greenshop.oodm.catalog.repositories;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.Category;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CategoryRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(CategoryRepositoryTest.class);
	
	@Inject
	private CategoryRepository categoryRepository;
	
	@Test
	public void testGetAll() throws Exception {
		List<Category> all=categoryRepository.findAll();
		logger.info("------------------------------------------------------");
		for (Category p : all){
			logger.info(p.toString());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findByparentIdOrderBySortOrderTest() throws Exception {
		for (Category root : categoryRepository.findByparentId(0L)){
			logger.info("------------------------------------------------------");
			for (Category c : categoryRepository.findByparentId(root.getId())){
				logger.info("child: "+c.toString());
			}
			logger.info("------------------------------------------------------");
			logger.info("root:  "+root.toString());
			logger.info("------------------------------------------------------");
		}
	}
}
