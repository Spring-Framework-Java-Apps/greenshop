package org.woehlke.greenshop.catalog.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.CategoryTreeNode;
import org.woehlke.greenshop.catalog.model.ProductsByCategory;
import org.woehlke.greenshop.catalog.model.SpecialProduct;

import javax.inject.Inject;

/**
 * Created by tw on 30.01.15.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CategoryServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImplTest.class);

    @Inject
    private LanguageService languageService;

    @Inject
    private CategoryService categoryService;

    @Test
    public void getCategoriesTreeTest() throws Exception {
        logger.info("#---------------------------------------");
        Language language = languageService.findLanguageByCode("en");
        long rootCategoryId[] = {21L,11L,9L,1L,2L,3L,0L};
        for(long categoryId:rootCategoryId){
            CategoryTree categoryTree = categoryService.getCategoriesTree(categoryId, language);
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
        tree = categoryService.getNumberOfProductsPerCategory(tree);
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
            ProductsByCategory p = categoryService.getProductsByCategory(categoryId,language);
            logger.info("@ ---------------------------------------");
            for(SpecialProduct pd:p.getProducts()){
                logger.info("@ ["+categoryId+"]: "+pd.getProductDescription().getProduct().getId()+" : "+pd.getProductDescription().getName());
            }
            logger.info("@ ---------------------------------------");
        }
    }
}
