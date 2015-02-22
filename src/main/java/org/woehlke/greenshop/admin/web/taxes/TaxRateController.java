package org.woehlke.greenshop.admin.web.taxes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.entities.TaxClass;
import org.woehlke.greenshop.admin.entities.TaxRate;
import org.woehlke.greenshop.admin.entities.TaxZone;
import org.woehlke.greenshop.admin.service.TaxClassService;
import org.woehlke.greenshop.admin.service.TaxRateService;
import org.woehlke.greenshop.admin.service.TaxZoneService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class TaxRateController {

    private static final Logger logger = LoggerFactory.getLogger(TaxRateController.class);

    @Inject
    private TaxRateService taxRateService;

    @Inject
    private TaxZoneService taxZoneService;

    @Inject
    private TaxClassService taxClassService;

    private final static int PAGE_SIZE = 20;

    private final static String FIRST_PAGE = "0";

    @RequestMapping(value = "/admin/taxRates", method = RequestMethod.GET)
    public String taxRates(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "priority");
        Page<TaxRate> taxRates = taxRateService.findAll(pageRequest);
        model.addAttribute("taxRates",taxRates);
        TaxRate thisTaxRate = null;
        if(taxRates.getContent().size()>0){
            thisTaxRate =  taxRates.iterator().next();
        }
        model.addAttribute("thisTaxRate",thisTaxRate);
        return "admin/taxes/taxRates";
    }

    @RequestMapping(value = "/admin/taxRates/{taxRateId}", method = RequestMethod.GET)
    public String taxRateId(@PathVariable long taxRateId,
                            @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                            Model model) {
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory", menuCategory);
        Pageable pageRequest = new PageRequest(page, PAGE_SIZE, Sort.Direction.ASC, "priority");
        Page<TaxRate> taxRates = taxRateService.findAll(pageRequest);
        model.addAttribute("taxRates", taxRates);
        TaxRate thisTaxRate = null;
        if (taxRates.getContent().size() > 0) {
            thisTaxRate = taxRateService.findById(taxRateId);
        }
        model.addAttribute("thisTaxRate", thisTaxRate);
        return "admin/taxes/taxRates";
    }

    @RequestMapping(value = "/admin/taxRates/insert", method = RequestMethod.GET)
    public String taxRateInsertForm(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "priority");
        Page<TaxRate> taxRates = taxRateService.findAll(pageRequest);
        model.addAttribute("taxRates",taxRates);
        TaxRate thisTaxRate = new TaxRate();
        model.addAttribute("thisTaxRate",thisTaxRate);
        List<TaxZone> taxZones = taxZoneService.findAll();
        model.addAttribute("taxZones",taxZones);
        List<TaxClass> taxClasses = taxClassService.findAll();
        model.addAttribute("taxClasses",taxClasses);
        return "admin/taxes/taxRatesInsertForm";
    }

    @RequestMapping(value = "/admin/taxRates/insert", method = RequestMethod.POST)
    public String taxRateInsertPerform(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                       @Valid TaxRate thisTaxRate, BindingResult result, Model model){
        logger.info("TaxRate: "+thisTaxRate.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "priority");
            Page<TaxRate> taxRates = taxRateService.findAll(pageRequest);
            model.addAttribute("taxRates",taxRates);
            model.addAttribute("thisTaxRate",thisTaxRate);
            return "admin/taxes/taxRatesInsertForm";
        } else {
            taxRateService.create(thisTaxRate);
            return "redirect:/admin/taxRates/"+thisTaxRate.getId()+ "?page="+page;
        }
    }

    @RequestMapping(value = "/admin/taxRates/{taxRateId}/edit", method = RequestMethod.GET)
    public String taxRateEditForm(@PathVariable long taxRateId,
                                   @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                   Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxRate thisTaxRate =  taxRateService.findById(taxRateId);
        model.addAttribute("thisTaxRate",thisTaxRate);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "priority");
        Page<TaxRate> taxRates = taxRateService.findAll(pageRequest);
        model.addAttribute("taxRates",taxRates);
        List<TaxZone> taxZones = taxZoneService.findAll();
        model.addAttribute("taxZones",taxZones);
        List<TaxClass> taxClasses = taxClassService.findAll();
        model.addAttribute("taxClasses",taxClasses);
        return "admin/taxes/taxRatesEditForm";
    }

    @RequestMapping(value = "/admin/taxRates/{taxRateId}/edit", method = RequestMethod.POST)
    public String taxRateEditSave(@PathVariable long taxRateId,
                                   @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                   @Valid TaxRate thisTaxRate, BindingResult result, Model model){
        logger.info("TaxRate: "+thisTaxRate.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            model.addAttribute("thisTaxRate",thisTaxRate);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "priority");
            Page<TaxRate> taxRates = taxRateService.findAll(pageRequest);
            model.addAttribute("taxRates",taxRates);
            return "admin/taxes/taxRatesEditForm";
        } else {
            TaxRate loadedTaxRate =  taxRateService.findById(taxRateId);
            loadedTaxRate.setLastModified(new Date());
            loadedTaxRate.setPriority(thisTaxRate.getPriority());
            loadedTaxRate.setTaxRate(thisTaxRate.getTaxRate());
            loadedTaxRate.setTaxClass(thisTaxRate.getTaxClass());
            loadedTaxRate.setTaxZone(thisTaxRate.getTaxZone());
            taxRateService.update(loadedTaxRate);
            return "redirect:/admin/taxRates/"+taxRateId+"?page="+page;
        }
    }

    @RequestMapping(value = "/admin/taxRates/{taxRateId}/delete", method = RequestMethod.GET)
    public String taxRateDeleteForm(@PathVariable long taxRateId,
                                     @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                     Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxRate thisTaxRate =  taxRateService.findById(taxRateId);
        model.addAttribute("thisTaxRate",thisTaxRate);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "priority");
        Page<TaxRate> taxRates = taxRateService.findAll(pageRequest);
        model.addAttribute("taxRates",taxRates);
        return "admin/taxes/taxRatesDeleteForm";
    }

    @RequestMapping(value = "/admin/taxRates/{taxRateId}/delete", method = RequestMethod.POST)
    public String taxRateDeleteSave(@PathVariable long taxRateId,
                                     @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                     Model model){
        TaxRate thisTaxRate =  taxRateService.findById(taxRateId);
        taxRateService.delete(thisTaxRate);
        return "redirect:/admin/taxRates?page="+page;
    }
}
