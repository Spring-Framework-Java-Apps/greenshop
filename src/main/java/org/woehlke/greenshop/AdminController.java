package org.woehlke.greenshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminService;
import org.woehlke.greenshop.catalog.entities.Manufacturer;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
@Controller
public class AdminController {

    @Inject
    private AdminService adminService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
     public String home(Model model){
        return "admin/home";
    }

    @RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
    public String rootCategories(Model model){
        return "admin/categories";
    }

    @RequestMapping(value = "/admin/manufacturers", method = RequestMethod.GET)
    public String manufacturers(Model model){
        List<Manufacturer> manufacturers = adminService.getAllManufacturers();
        model.addAttribute("manufacturers",manufacturers);
        int productsOfThisManufacturer = 0;
        Manufacturer thisManufacturer = null;
        if(manufacturers.size()>0){
            thisManufacturer = manufacturers.iterator().next();
            productsOfThisManufacturer = adminService.countProductsOfThisManufacturer(thisManufacturer);
        }
        model.addAttribute("thisManufacturer",thisManufacturer);
        model.addAttribute("productsOfThisManufacturer",productsOfThisManufacturer);
        return "admin/manufacturers";
    }

    @RequestMapping(value = "/admin/manufacturers/{manufacturerId}", method = RequestMethod.GET)
    public String manufacturersId(
            @PathVariable long manufacturerId , Model model){
        List<Manufacturer> manufacturers = adminService.getAllManufacturers();
        model.addAttribute("manufacturers",manufacturers);
        int productsOfThisManufacturer = 0;
        Manufacturer thisManufacturer = null;
        if(manufacturers.size()>0){
            thisManufacturer = adminService.getManufacturerById(manufacturerId);
            productsOfThisManufacturer = adminService.countProductsOfThisManufacturer(thisManufacturer);
        }
        model.addAttribute("thisManufacturer",thisManufacturer);
        model.addAttribute("productsOfThisManufacturer",productsOfThisManufacturer);
        return "admin/manufacturers";
    }

    @RequestMapping(value = "/admin/reviews", method = RequestMethod.GET)
    public String reviews(Model model){
        return "admin/reviews";
    }

    @RequestMapping(value = "/admin/specials", method = RequestMethod.GET)
    public String specials(Model model){
        return "admin/specials";
    }
}
