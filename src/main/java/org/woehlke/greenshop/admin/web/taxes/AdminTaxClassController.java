package org.woehlke.greenshop.admin.web.taxes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.entities.TaxClass;
import org.woehlke.greenshop.admin.service.TaxClassService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class AdminTaxClassController {

    @Inject
    private TaxClassService taxClassService;

    @RequestMapping(value = "/admin/taxClasses", method = RequestMethod.GET)
    public String taxClasses(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxClass> taxClasses = taxClassService.findAllTaxClasses();
        model.addAttribute("taxClasses",taxClasses);
        TaxClass thisTaxClass = null;
        if(taxClasses.size()>0){
            thisTaxClass =  taxClasses.iterator().next();
        }
        model.addAttribute("thisTaxClass",thisTaxClass);
        return "admin/taxClasses";
    }

    @RequestMapping(value = "/admin/taxClasses/{taxClassId}", method = RequestMethod.GET)
    public String taxClassId(@PathVariable long taxClassId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxClass> taxClasses = taxClassService.findAllTaxClasses();
        model.addAttribute("taxClasses",taxClasses);
        TaxClass thisTaxClass = null;
        if(taxClasses.size()>0){
            thisTaxClass =  taxClassService.findTaxClassById(taxClassId);
        }
        model.addAttribute("thisTaxClass",thisTaxClass);
        return "admin/taxClasses";
    }
}
