package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.ProductDescription;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminReportsController {

    @Inject
    private AdminService adminService;

    @Inject
    private CatalogService catalogService;

    @RequestMapping(value = "/admin/productsViewed", method = RequestMethod.GET)
    public String productsViewed(Model model){
        int menuCategory = AdminMenuCategory.REPORTS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = catalogService.findLanguageByCode("en");
        List<ProductDescription> productsViewed = adminService.findProductsViewed(language);
        model.addAttribute("productsViewed",productsViewed);
        return "admin/productsViewed";
    }

    @RequestMapping(value = "/admin/productsPurchased", method = RequestMethod.GET)
    public String productsPurchased(Model model){
        int menuCategory = AdminMenuCategory.REPORTS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/productsPurchased";
    }

    @RequestMapping(value = "/admin/customerOrdersTotal", method = RequestMethod.GET)
    public String customerOrdersTotal(Model model){
        int menuCategory = AdminMenuCategory.REPORTS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/customerOrdersTotal";
    }
}
