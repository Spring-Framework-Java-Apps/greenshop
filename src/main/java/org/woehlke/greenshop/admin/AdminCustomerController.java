package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminCustomerController {

    @RequestMapping(value = "/admin/customers", method = RequestMethod.GET)
    public String customers(Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/customers";
    }

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public String orders(Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        return "admin/orders";
    }
}
