package org.woehlke.greenshop.admin.web.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.model.CategoryTree;
import org.woehlke.greenshop.catalog.model.CategoryTreeNode;
import org.woehlke.greenshop.catalog.service.CategoryService;
import org.woehlke.greenshop.catalog.service.LanguageService;
import org.woehlke.greenshop.catalog.service.ProductService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class CategoryAndProductController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryAndProductController.class);

    @Inject
    private CategoryService categoryService;

    @Inject
    private ProductService productService;

    @Inject
    private LanguageService languageService;

    @RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
    public String rootCategories(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        CategoryTree rootCategories =  categoryService.getCategoriesTree(0L, language);
        model.addAttribute("rootCategories",rootCategories);
        CategoryTreeNode thisCategory = null;
        if(rootCategories.getChildren().size()>0){
            thisCategory = rootCategories.getChildren().iterator().next();
            logger.info(thisCategory.toString());
        } else {
            logger.info("thisCategory: null");
        }
        model.addAttribute("thisCategory",thisCategory);
        List<ProductDescription> thisCategoryProducts = productService.findProductsByCategoryId(0L, language);
        model.addAttribute("thisCategoryProducts",thisCategoryProducts);
        if(thisCategoryProducts.isEmpty()){
            model.addAttribute("thisProductId",0L);
            model.addAttribute("thisProduct",null);
        } else {
            ProductDescription pd = thisCategoryProducts.iterator().next();
            model.addAttribute("thisProduct",pd);
            model.addAttribute("thisProductId",pd.getProduct().getId());
        }
        logger.info("################################################");
        logger.info(rootCategories.toString());
        logger.info("################################################");
        return "admin/categories";
    }

    @RequestMapping(value = "/admin/categories/{categoryId}/parent/{parentId}/product/{productId}", method = RequestMethod.GET)
    public String rootCategoryId(
            @PathVariable long categoryId,
            @PathVariable long parentId,
            @PathVariable long productId,
            Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        performCategoryAndProduct(categoryId, parentId, productId, model);
        return "admin/categories";
    }

    @RequestMapping(value = "/admin/categories/{categoryId}/parent/{parentId}/product/{productId}/setActive", method = RequestMethod.GET)
    public String rootCategoryIdSetActive(
            @PathVariable long categoryId,
            @PathVariable long parentId,
            @PathVariable long productId,
            Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        productService.setProductActive(productId);
        performCategoryAndProduct(categoryId, parentId, productId,model);
        return "admin/categories";
    }

    @RequestMapping(value = "/admin/categories/{categoryId}/parent/{parentId}/product/{productId}/setInactive", method = RequestMethod.GET)
    public String rootCategoryIdSetInactive(
            @PathVariable long categoryId,
            @PathVariable long parentId,
            @PathVariable long productId,
            Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        productService.setProductInactive(productId);
        performCategoryAndProduct(categoryId, parentId, productId,model);
        return "admin/categories";
    }

    private void performCategoryAndProduct(
            long categoryId,
            long parentId,
            long productId,Model model){
        Language language = languageService.findLanguageByCode("en");
        CategoryTree rootCategories =  categoryService.getCategoriesTree(parentId, language);
        model.addAttribute("rootCategories",rootCategories);
        model.addAttribute("categoryId",categoryId);
        model.addAttribute("parentId",parentId);
        CategoryTreeNode thisCategory = null;
        if(categoryId != 0){
            thisCategory = categoryService.findCategoryById(categoryId, language);
        } else {
            if(rootCategories.getChildren().size()>0) {
                thisCategory = rootCategories.getChildren().iterator().next();
            } else {
                logger.info("################################################");
                logger.info("children.size: 0");
            }
        }
        model.addAttribute("thisCategory",thisCategory);
        List<ProductDescription> thisCategoryProducts = productService.findProductsByCategoryId(parentId, language);
        model.addAttribute("thisCategoryProducts",thisCategoryProducts);
        ProductDescription pd = null;
        if(productId==0L){
            if (!thisCategoryProducts.isEmpty()) {
                pd = thisCategoryProducts.iterator().next();
                productId = pd.getProduct().getId();
            }
        } else {
            pd = productService.findProductById(productId,language);
            model.addAttribute("thisProduct",pd);
        }
        model.addAttribute("thisProduct",pd);
        model.addAttribute("thisProductId",productId);
        logger.info("################################################");
        logger.info(rootCategories.toString());
        logger.info("################################################");
    }
}
