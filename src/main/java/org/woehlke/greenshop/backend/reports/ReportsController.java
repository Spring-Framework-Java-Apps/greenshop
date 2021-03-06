package org.woehlke.greenshop.backend.reports;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.backend.AdminMenuCategory;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.service.LanguageService;
import org.woehlke.greenshop.oodm.catalog.service.ProductService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class ReportsController {

    @Inject
    private ProductService productService;

    @Inject
    private LanguageService languageService;

    @RequestMapping(value = "/admin/productsViewed", method = RequestMethod.GET)
    public String productsViewed(Model model){
        int menuCategory = AdminMenuCategory.REPORTS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        List<ProductDescription> productsViewed = productService.findProductsViewed(language);
        model.addAttribute("productsViewed",productsViewed);
        return "admin/reports/productsViewed";
    }

    @RequestMapping(value = "/admin/productsPurchased", method = RequestMethod.GET)
    public String productsPurchased(Model model){
        int menuCategory = AdminMenuCategory.REPORTS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/reports/productsPurchased";
    }

    @RequestMapping(value = "/admin/customerOrdersTotal", method = RequestMethod.GET)
    public String customerOrdersTotal(Model model){
        int menuCategory = AdminMenuCategory.REPORTS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/reports/customerOrdersTotal";
    }
}
