package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminConfigurationController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String home(Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/home";
    }

    @RequestMapping(value = "/admin/administrators", method = RequestMethod.GET)
    public String administrators(Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/administrators";
    }
}
