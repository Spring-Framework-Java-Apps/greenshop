package org.woehlke.greenshop.catalog;

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
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Product;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ProductOption;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.catalog.repositories.CategoryDescriptionRepositoryDao;
import org.woehlke.greenshop.catalog.repositories.ProductRepository;
import org.woehlke.greenshop.catalog.service.LanguageService;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CatalogServiceImplTest {

	private static final Logger logger = LoggerFactory.getLogger(CatalogServiceImplTest.class);
	
	@Inject
	private CatalogService catalogService;
	
	@Inject
	private ProductRepository productRepository;

    @Inject
    private LanguageService languageService;
	
	@Test
	public void findProductOptionsByProductTest(){
		Language language = languageService.findLanguageByCode("en");
		List<Product> listProduct = productRepository.findAll();
		for(Product product:listProduct){
			ProductDescription productDescription = catalogService.findProductById(product.getId(), language);
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
	
	@Test
	public void getCategoriesTreeTest() throws Exception {
		logger.info("#---------------------------------------");
		Language language = languageService.findLanguageByCode("en");
		long rootCategoryId[] = {21L,11L,9L,1L,2L,3L,0L};
		for(long categoryId:rootCategoryId){
			CategoryTree categoryTree = catalogService.getCategoriesTree(categoryId, language);
			Assert.assertEquals(categoryId, categoryTree.getThisCategoryId());
			logger.info("#---------------------------------------");
			for(CategoryTreeNode node:categoryTree.getCategoriesMenuList()){
				String level="";
				for(int i=0;i<node.getLevel();i++){
					level+=" ";
				}
				StringBuilder info = new StringBuilder();
				info.append("#");
				info.append(level);
				info.append(node.getCategoryDescription().getName());
				if(node.isHasChildCategories()){
					info.append("-> ");
				}
				info.append("(");
				info.append(node.getNumberOfProducts());
				info.append(")");
				logger.info(info.toString());
			}
			logger.info("#---------------------------------------");
			for(CategoryTreeNode node:categoryTree.getThisLevelCategories()){
				String level="";
				for(int i=0;i<node.getLevel();i++){
					level+=" ";
				}
				StringBuilder info = new StringBuilder();
				info.append("#");
				info.append(level);
				info.append(node.getCategoryDescription().getName());
				if(node.isHasChildCategories()){
					info.append("-> ");
				}
				info.append("(");
				info.append(node.getNumberOfProducts());
				info.append(")");
				logger.info(info.toString());
			}
			for(CategoryTreeNode node:categoryTree.getChildren()){
				String level="";
				for(int i=0;i<node.getLevel();i++){
					level+=" ";
				}
				StringBuilder info = new StringBuilder();
				info.append("#");
				info.append(level);
				info.append(node.getCategoryDescription().getName());
				if(node.isHasChildCategories()){
					info.append("-> ");
				}
				info.append("(");
				info.append(node.getNumberOfProducts());
				info.append(")");
				logger.info(info.toString());
			}
		}
	}
	
	@Test
	public void getNumberOfProductsPerCategoryTest() throws Exception {
		CategoryTree tree = new CategoryTree();
		tree = catalogService.getNumberOfProductsPerCategory(tree);
		logger.info("#---------------------------------------");
		for(long id:tree.getCategoryIdToNumberOfProducts().keySet()){
			logger.info("# "+id+" : "+tree.getCategoryIdToNumberOfProducts().get(id));
		}
		logger.info("#---------------------------------------");
		for(long id:tree.getHasChildrenMap().keySet()){
			logger.info("# "+id+" : "+tree.getHasChildrenMap().get(id));
		}
	}
	
	@Test
	public void getProductsByCategoryTest() throws Exception {
		Language language = languageService.findLanguageByCode("en");
		long rootCategoryId[] = {24L,11L,9L,1L,2L,3L,0L};
		for(long categoryId:rootCategoryId){
			ProductsByCategory p = catalogService.getProductsByCategory(categoryId,language);
			logger.info("@ ---------------------------------------");
			for(SpecialProduct pd:p.getProducts()){
				logger.info("@ ["+categoryId+"]: "+pd.getProductDescription().getProduct().getId()+" : "+pd.getProductDescription().getName());
			}
			logger.info("@ ---------------------------------------");
		}
	}
}
