package org.woehlke.greenshop.catalog.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.Category;
import org.woehlke.greenshop.catalog.entities.Product;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 11.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductRepositoryDaoImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryDaoImplTest.class);

    @Inject
    private ProductRepositoryDao productRepositoryDao;

    @Inject
    private CategoryRepository categoryRepository;

    @Test
    public void findByCategoryIdIsNot0Test() throws Exception {
        List<Category> categoryList = categoryRepository.findAll();
        for(Category category: categoryList){
            List<Product> products = productRepositoryDao.findByCategoryId(category.getId());
            for(Product product :products){
                Assert.assertTrue(product.getCategories().contains(category));
            }
        }
    }

    @Test
    public void findByCategoryIdIs0Test() throws Exception {
        List<Product> products = productRepositoryDao.findByCategoryId(0L);
        for(Product product :products) {
            Assert.assertTrue(product.getCategories().isEmpty());
        }
    }
}
