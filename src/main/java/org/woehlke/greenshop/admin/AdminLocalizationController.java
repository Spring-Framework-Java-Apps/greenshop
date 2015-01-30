package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.service.LanguageService;
import org.woehlke.greenshop.checkout.entities.OrderStatus;
import org.woehlke.greenshop.checkout.entities.OrderStatusId;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminLocalizationController {

    @Inject
    private AdminService adminService;

    @Inject
    private LanguageService languageService;

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
        List<Language> languages = adminService.findAllLanguages();
        model.addAttribute("languages",languages);
        Language thisLanguage = null;
        if(languages.size()>0){
            thisLanguage = languages.iterator().next();
        }
        model.addAttribute("thisLanguage",thisLanguage);
        return "admin/languages";
    }

    @RequestMapping(value = "/admin/languages/{languageId}", method = RequestMethod.GET)
    public String languageId(@PathVariable long languageId, Model model){
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Language> languages = adminService.findAllLanguages();
        model.addAttribute("languages",languages);
        Language thisLanguage = adminService.findLanguageById(languageId);
        model.addAttribute("thisLanguage",thisLanguage);
        return "admin/languages";
    }

    @RequestMapping(value = "/admin/ordersStatus", method = RequestMethod.GET)
    public String ordersStatus(Model model){
        Language language = languageService.findLanguageByCode("en");
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<OrderStatus> orderStatuses = adminService.findAllOrderStatuses(language);
        model.addAttribute("orderStatuses",orderStatuses);
        OrderStatus thisOrderStatus = null;
        if(orderStatuses.size()>0){
            thisOrderStatus =  orderStatuses.iterator().next();
        }
        model.addAttribute("thisOrderStatus",thisOrderStatus);
        return "admin/ordersStatus";
    }

    @RequestMapping(value = "/admin/ordersStatus/{ordersStatusId}", method = RequestMethod.GET)
    public String ordersStatusId(@PathVariable long ordersStatusId, Model model){
        Language language = languageService.findLanguageByCode("en");
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<OrderStatus> orderStatuses = adminService.findAllOrderStatuses(language);
        model.addAttribute("orderStatuses",orderStatuses);
        OrderStatusId thisOrderStatusId = new OrderStatusId();
        thisOrderStatusId.setId(ordersStatusId);
        thisOrderStatusId.setLanguage(language);
        OrderStatus thisOrderStatus = adminService.findOrderStatusById(thisOrderStatusId);
        model.addAttribute("thisOrderStatus",thisOrderStatus);
        return "admin/ordersStatus";
    }
}
