package org.woehlke.greenshop.admin.web.taxes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.entities.TaxRate;
import org.woehlke.greenshop.admin.service.TaxRateService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class TaxRateController {

    @Inject
    private TaxRateService taxRateService;

    @RequestMapping(value = "/admin/taxRates", method = RequestMethod.GET)
    public String taxRates(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxRate> taxRates = taxRateService.findAllTaxRates();
        model.addAttribute("taxRates",taxRates);
        TaxRate thisTaxRate = null;
        if(taxRates.size()>0){
            thisTaxRate =  taxRates.iterator().next();
        }
        model.addAttribute("thisTaxRate",thisTaxRate);
        return "admin/taxes/taxRates";
    }

    @RequestMapping(value = "/admin/taxRates/{taxRateId}", method = RequestMethod.GET)
    public String taxRateId(@PathVariable long taxRateId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxRate> taxRates = taxRateService.findAllTaxRates();
        model.addAttribute("taxRates",taxRates);
        TaxRate thisTaxRate = null;
        if(taxRates.size()>0){
            thisTaxRate =  taxRateService.findTaxRateById(taxRateId);
        }
        model.addAttribute("thisTaxRate",thisTaxRate);
        return "admin/taxes/taxRates";
    }
}
