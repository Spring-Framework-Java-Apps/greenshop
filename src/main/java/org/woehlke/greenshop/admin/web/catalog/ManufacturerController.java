package org.woehlke.greenshop.admin.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.service.ManufacturerService;
import org.woehlke.greenshop.catalog.service.ProductService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class ManufacturerController {

    @Inject
    private ManufacturerService manufacturerService;

    @Inject
    private ProductService productService;

    @RequestMapping(value = "/admin/manufacturers", method = RequestMethod.GET)
    public String manufacturers(Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        model.addAttribute("manufacturers",manufacturers);
        int productsOfThisManufacturer = 0;
        Manufacturer thisManufacturer = null;
        if(manufacturers.size()>0){
            thisManufacturer = manufacturers.iterator().next();
            productsOfThisManufacturer = productService.countProductsOfThisManufacturer(thisManufacturer);
        }
        model.addAttribute("thisManufacturer",thisManufacturer);
        model.addAttribute("productsOfThisManufacturer",productsOfThisManufacturer);
        return "admin/catalog/manufacturers";
    }

    @RequestMapping(value = "/admin/manufacturers/{manufacturerId}", method = RequestMethod.GET)
    public String manufacturersId(
            @PathVariable long manufacturerId , Model model){
        int menuCategory = AdminMenuCategory.CATALOG.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        model.addAttribute("manufacturers",manufacturers);
        int productsOfThisManufacturer = 0;
        Manufacturer thisManufacturer = null;
        if(manufacturers.size()>0){
            thisManufacturer = manufacturerService.getManufacturerById(manufacturerId);
            productsOfThisManufacturer = productService.countProductsOfThisManufacturer(thisManufacturer);
        }
        model.addAttribute("thisManufacturer",thisManufacturer);
        model.addAttribute("productsOfThisManufacturer",productsOfThisManufacturer);
        return "admin/catalog/manufacturers";
    }
}
