package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminLocalizationController {

    @RequestMapping(value = "/admin/currencies", method = RequestMethod.GET)
    public String currencies(Model model){
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/currencies";
    }

    @RequestMapping(value = "/admin/languages", method = RequestMethod.GET)
    public String languages(Model model){
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/languages";
    }

    @RequestMapping(value = "/admin/ordersStatus", method = RequestMethod.GET)
    public String ordersStatus(Model model){
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/ordersStatus";
    }
}
