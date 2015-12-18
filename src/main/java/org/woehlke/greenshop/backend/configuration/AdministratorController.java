package org.woehlke.greenshop.backend.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.backend.AdminMenuCategory;
import org.woehlke.greenshop.oodm.admin.entities.Administrator;
import org.woehlke.greenshop.oodm.admin.service.AdministratorService;

import javax.inject.Inject;
import javax.validation.Valid;
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

    @RequestMapping(value = "/admin/administrators/{administratorId}/edit", method = RequestMethod.GET)
    public String administratorEditForm(
            @PathVariable long administratorId, Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Administrator thisAdministrator = administratorService.findAdministratorById(administratorId);
        model.addAttribute("thisAdministrator",thisAdministrator);
        List<Administrator> administrators = administratorService.findAllAdministrators();
        model.addAttribute("administrators",administrators);
        return "admin/configuration/administratorsEdit";
    }

    @RequestMapping(value = "/admin/administrators/{administratorId}/edit", method = RequestMethod.POST)
    public String administratorEditSave(
            @PathVariable long administratorId,
            @Valid Administrator thisAdministrator, BindingResult result, Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        if(result.hasErrors()){
            model.addAttribute("thisAdministrator",thisAdministrator);
            List<Administrator> administrators = administratorService.findAllAdministrators();
            model.addAttribute("administrators",administrators);
            return "admin/configuration/administratorsEdit";
        } else {
            thisAdministrator.setId(administratorId);
            administratorService.update(thisAdministrator);
            return "redirect:/admin/administrators/"+administratorId;
        }
    }

    @RequestMapping(value = "/admin/administrators/insert", method = RequestMethod.GET)
    public String administratorInsertForm(Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Administrator thisAdministrator = new Administrator();
        model.addAttribute("thisAdministrator",thisAdministrator);
        List<Administrator> administrators = administratorService.findAllAdministrators();
        model.addAttribute("administrators",administrators);
        return "admin/configuration/administratorsInsert";
    }

    @RequestMapping(value = "/admin/administrators/insert", method = RequestMethod.POST)
    public String administratorInsertSave(
            @Valid Administrator thisAdministrator, BindingResult result, Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        if(result.hasErrors()){
            model.addAttribute("thisAdministrator",thisAdministrator);
            List<Administrator> administrators = administratorService.findAllAdministrators();
            model.addAttribute("administrators",administrators);
            return "admin/configuration/administratorsInsert";
        } else {
            administratorService.create(thisAdministrator);
            long administratorId = thisAdministrator.getId();
            return "redirect:/admin/administrators/"+administratorId;
        }
    }

    @RequestMapping(value = "/admin/administrators/{administratorId}/delete", method = RequestMethod.GET)
    public String administratorDeleteForm(
            @PathVariable long administratorId, Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Administrator thisAdministrator = administratorService.findAdministratorById(administratorId);
        model.addAttribute("thisAdministrator",thisAdministrator);
        List<Administrator> administrators = administratorService.findAllAdministrators();
        model.addAttribute("administrators",administrators);
        return "admin/configuration/administratorsDelete";
    }

    @RequestMapping(value = "/admin/administrators/{administratorId}/delete", method = RequestMethod.POST)
    public String administratorDeleteSave(
            @PathVariable long administratorId,
            @Valid Administrator thisAdministrator, BindingResult result, Model model){
        int menuCategory = AdminMenuCategory.CONFIGURATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        if(result.hasErrors()){
            model.addAttribute("thisAdministrator",thisAdministrator);
            List<Administrator> administrators = administratorService.findAllAdministrators();
            model.addAttribute("administrators",administrators);
            return "admin/configuration/administratorsDelete";
        } else {
            thisAdministrator.setId(administratorId);
            administratorService.delete(thisAdministrator);
            return "redirect:/admin/administrators";
        }
    }
}
