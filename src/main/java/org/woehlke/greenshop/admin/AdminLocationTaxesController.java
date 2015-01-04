package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminLocationTaxesController {

    @RequestMapping(value = "/admin/countries", method = RequestMethod.GET)
    public String countries(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/countries";
    }

    @RequestMapping(value = "/admin/zones", method = RequestMethod.GET)
    public String zones(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/zones";
    }

    @RequestMapping(value = "/admin/taxZones", method = RequestMethod.GET)
    public String taxZones(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/taxZones";
    }

    @RequestMapping(value = "/admin/taxClasses", method = RequestMethod.GET)
    public String taxClasses(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/taxClasses";
    }

    @RequestMapping(value = "/admin/taxRates", method = RequestMethod.GET)
    public String taxRates(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/taxRates";
    }
}
