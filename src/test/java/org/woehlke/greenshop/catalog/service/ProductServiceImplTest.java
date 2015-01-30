package org.woehlke.greenshop.catalog.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Product;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ProductOption;
import org.woehlke.greenshop.catalog.model.ProductAttributes;
import org.woehlke.greenshop.catalog.model.ProductOptionAttribute;
import org.woehlke.greenshop.catalog.repositories.ProductRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ProductServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImplTest.class);

    @Inject
    private CatalogService catalogService;

    @Inject
    private ProductRepository productRepository;

    @Inject
    private LanguageService languageService;

    @Inject
    private ProductService productService;

    @Test
    public void findProductOptionsByProductTest(){
        Language language = languageService.findLanguageByCode("en");
        List<Product> listProduct = productRepository.findAll();
        for(Product product:listProduct){
            ProductDescription productDescription = productService.findProductById(product.getId(), language);
            ProductAttributes productAttributes = catalogService.findProductOptionsByProduct(productDescription);
            Assert.assertNotNull(productAttributes.getProductDescription());
            Assert.assertNotNull(productAttributes.getMapProductOptionAttribute());
            Assert.assertEquals(product.getId(), productAttributes.getProductDescription().getProduct().getId());
            for(ProductOption po:productAttributes.getMapProductOptionAttribute().keySet()){
                StringBuilder sb = new StringBuilder("");
                for(ProductOptionAttribute pov:productAttributes.getMapProductOptionAttribute().get(po)){
                    sb.append(pov.getOptionValue());
                    sb.append(",");
                }
                logger.info(po.getName()+" -> ("+sb.toString()+")");
            }
        }
    }
}
