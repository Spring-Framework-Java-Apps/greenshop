package org.woehlke.greenshop.backend.localization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.backend.AdminMenuCategory;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.service.LanguageService;
import org.woehlke.greenshop.oodm.checkout.OrderService;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatus;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatusId;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class OrderStatusController {

    @Inject
    private OrderService orderService;

    @Inject
    private LanguageService languageService;

    @RequestMapping(value = "/admin/ordersStatus", method = RequestMethod.GET)
    public String ordersStatus(Model model){
        Language language = languageService.findLanguageByCode("en");
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<OrderStatus> orderStatuses = orderService.findAllOrderStatuses(language);
        model.addAttribute("orderStatuses",orderStatuses);
        OrderStatus thisOrderStatus = null;
        if(orderStatuses.size()>0){
            thisOrderStatus =  orderStatuses.iterator().next();
        }
        model.addAttribute("thisOrderStatus",thisOrderStatus);
        return "admin/localization/ordersStatus";
    }

    @RequestMapping(value = "/admin/ordersStatus/{ordersStatusId}", method = RequestMethod.GET)
    public String ordersStatusId(@PathVariable long ordersStatusId, Model model){
        Language language = languageService.findLanguageByCode("en");
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<OrderStatus> orderStatuses = orderService.findAllOrderStatuses(language);
        model.addAttribute("orderStatuses",orderStatuses);
        OrderStatusId thisOrderStatusId = new OrderStatusId();
        thisOrderStatusId.setId(ordersStatusId);
        thisOrderStatusId.setLanguage(language);
        OrderStatus thisOrderStatus = orderService.findOrderStatusById(thisOrderStatusId);
        model.addAttribute("thisOrderStatus",thisOrderStatus);
        return "admin/localization/ordersStatus";
    }
}
