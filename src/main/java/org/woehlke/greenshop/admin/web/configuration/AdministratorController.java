package org.woehlke.greenshop.admin.web.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.entities.Administrator;
import org.woehlke.greenshop.admin.service.AdministratorService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdministratorController {

    @Inject
    private AdministratorService administratorService;

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
        List<Administrator> administrators = administratorService.findAllAdministrators();
        model.addAttribute("administrators",administrators);
        Administrator thisAdministrator = null;
        if(administrators.size()>0){
            thisAdministrator = administrators.iterator().next();
        }
        model.addAttribute("thisAdministrator",thisAdministrator);
        return "admin/configuration/administrators";
    }

    @RequestMapping(value = "/admin/administrators/{administratorId}", method = RequestMethod.GET)
    public String administratorId(
            @PathVariable long administratorId, Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Administrator thisAdministrator = administratorService.findAdministratorById(administratorId);
        model.addAttribute("thisAdministrator",thisAdministrator);
        List<Administrator> administrators = administratorService.findAllAdministrators();
        model.addAttribute("administrators",administrators);
        return "admin/configuration/administrators";
    }
}
