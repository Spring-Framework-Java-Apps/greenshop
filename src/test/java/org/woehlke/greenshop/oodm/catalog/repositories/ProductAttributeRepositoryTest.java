package org.woehlke.greenshop.oodm.catalog.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.Product;
import org.woehlke.greenshop.oodm.catalog.entities.ProductAttribute;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductAttributeRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(ProductAttributeRepositoryTest.class);
	
	@Inject
	private ProductAttributeRepository productAttributeRepository;
	
	@Test
	public void findAllTest() throws Exception {
		List<ProductAttribute> list = productAttributeRepository.findAll();
		logger.info("------------------------------------------------------");
		for(ProductAttribute productOption:list){
			logger.info("# "+productOption.toString());
		}
		logger.info("------------------------------------------------------");
	}
	
	@Test
	public void findByProductTest() throws Exception {
		List<ProductAttribute> list1 = productAttributeRepository.findAll();
		List<Product> products = new ArrayList<Product>();
		logger.info("------------------------------------------------------");
		for(ProductAttribute productAttribute:list1){
			Assert.assertTrue(list1.contains(productAttribute));
			Product p = productAttribute.getProduct();
			if(!products.contains(p)){
				products.add(p);
			}
		}
		logger.info("------------------------------------------------------");
		for(Product product:products){
			List<ProductAttribute> list2 =productAttributeRepository.findByProduct(product);
			for(ProductAttribute pa :list2){
				Assert.assertEquals(product.getId(), pa.getProduct().getId());
			}
		}
		logger.info("------------------------------------------------------");
	}
}
