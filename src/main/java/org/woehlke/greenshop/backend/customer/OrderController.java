package org.woehlke.greenshop.backend.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.backend.AdminMenuCategory;
import org.woehlke.greenshop.admin.model.OrderAdminBean;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.service.LanguageService;
import org.woehlke.greenshop.checkout.OrderService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class OrderController {

    @Inject
    private OrderService orderService;

    @Inject
    private LanguageService languageService;

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public String orders(Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        List<OrderAdminBean> orders = orderService.getAllOrders(language);
        model.addAttribute("orders",orders);
        OrderAdminBean thisOrder = null;
        if(orders.size()>0){
            thisOrder = orders.iterator().next();
        }
        model.addAttribute("thisOrder",thisOrder);
        return "admin/customer/orders";
    }

    @RequestMapping(value = "/admin/orders/{orderId}", method = RequestMethod.GET)
    public String orderId(@PathVariable long orderId, Model model){
        int menuCategory = AdminMenuCategory.CUSTOMERS.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Language language = languageService.findLanguageByCode("en");
        List<OrderAdminBean> orders = orderService.getAllOrders(language);
        model.addAttribute("orders",orders);
        OrderAdminBean thisOrder = orderService.findOrderById(orderId,language);
        model.addAttribute("thisOrder",thisOrder);
        return "admin/customer/orders";
    }
}
