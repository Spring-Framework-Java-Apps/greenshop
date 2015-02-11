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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.entities.TaxClass;
import org.woehlke.greenshop.admin.service.TaxClassService;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class TaxClassController {

    private static final Logger logger = LoggerFactory.getLogger(TaxClassController.class);

    @Inject
    private TaxClassService taxClassService;

    private final static int PAGE_SIZE = 20;

    private final static String FIRST_PAGE = "0";

    @RequestMapping(value = "/admin/taxClasses", method = RequestMethod.GET)
    public String taxClasses(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "title");
        Page<TaxClass> taxClasses = taxClassService.findAll(pageRequest);
        model.addAttribute("taxClasses",taxClasses);
        TaxClass thisTaxClass = null;
        if(taxClasses.getContent().size()>0){
            thisTaxClass =  taxClasses.iterator().next();
        }
        model.addAttribute("thisTaxClass",thisTaxClass);
        return "admin/taxes/taxClasses";
    }

    @RequestMapping(value = "/admin/taxClasses/{taxClassId}", method = RequestMethod.GET)
    public String taxClassId(@PathVariable long taxClassId,
                             @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                             Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "title");
        Page<TaxClass> taxClasses = taxClassService.findAll(pageRequest);
        model.addAttribute("taxClasses",taxClasses);
        TaxClass thisTaxClass = null;
        if(taxClasses.getContent().size()>0){
            thisTaxClass =  taxClassService.findById(taxClassId);
        }
        model.addAttribute("thisTaxClass",thisTaxClass);
        return "admin/taxes/taxClasses";
    }

    @RequestMapping(value = "/admin/taxClasses/insert", method = RequestMethod.GET)
    public String taxClassInsertForm(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "title");
        Page<TaxClass> taxClasses = taxClassService.findAll(pageRequest);
        model.addAttribute("taxClasses",taxClasses);
        TaxClass thisTaxClass = new TaxClass();
        model.addAttribute("thisTaxClass",thisTaxClass);
        return "admin/taxes/taxClassesInsertForm";
    }

    @RequestMapping(value = "/admin/taxClasses/insert", method = RequestMethod.POST)
    public String taxClassInsertPerform(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                     @Valid TaxClass thisTaxClass, BindingResult result, Model model){
        logger.info("TaxClass: "+thisTaxClass.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "title");
            Page<TaxClass> taxClasses = taxClassService.findAll(pageRequest);
            model.addAttribute("taxClasses",taxClasses);
            model.addAttribute("thisTaxClass",thisTaxClass);
            return "admin/taxes/taxClassesInsertForm";
        } else {
            taxClassService.create(thisTaxClass);
            return "redirect:/admin/taxClasses/"+thisTaxClass.getId()+ "?page="+page;
        }
    }

    @RequestMapping(value = "/admin/taxClasses/{taxClassId}/edit", method = RequestMethod.GET)
    public String taxClassEditForm(@PathVariable long taxClassId,
                                @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxClass thisTaxClass =  taxClassService.findById(taxClassId);
        model.addAttribute("thisTaxClass",thisTaxClass);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "title");
        Page<TaxClass> taxClasses = taxClassService.findAll(pageRequest);
        model.addAttribute("taxClasses",taxClasses);
        return "admin/taxes/taxClassesEditForm";
    }

    @RequestMapping(value = "/admin/taxClasses/{taxClassId}/edit", method = RequestMethod.POST)
    public String taxClassEditSave(@PathVariable long taxClassId,
                                @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                @Valid TaxClass thisTaxClass, BindingResult result, Model model){
        logger.info("TaxClass: "+thisTaxClass.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            model.addAttribute("thisTaxClass",thisTaxClass);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "title");
            Page<TaxClass> taxClasses = taxClassService.findAll(pageRequest);
            model.addAttribute("taxClasses",taxClasses);
            return "admin/taxes/taxClassesEditForm";
        } else {
            TaxClass loadedTaxClass =  taxClassService.findById(taxClassId);
            loadedTaxClass.setTitle(thisTaxClass.getTitle());
            loadedTaxClass.setDescription(thisTaxClass.getDescription());
            taxClassService.update(loadedTaxClass);
            return "redirect:/admin/taxClasses/"+taxClassId+"?page="+page;
        }
    }

    @RequestMapping(value = "/admin/taxClasses/{taxClassId}/delete", method = RequestMethod.GET)
    public String taxClassDeleteForm(@PathVariable long taxClassId,
                                  @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                  Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxClass thisTaxClass =  taxClassService.findById(taxClassId);
        model.addAttribute("thisTaxClass",thisTaxClass);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "title");
        Page<TaxClass> taxClasses = taxClassService.findAll(pageRequest);
        model.addAttribute("taxClasses",taxClasses);
        return "admin/taxes/taxClassesDeleteForm";
    }

    @RequestMapping(value = "/admin/taxClasses/{taxClassId}/delete", method = RequestMethod.POST)
    public String taxClassDeleteSave(@PathVariable long taxClassId,
                                  @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                  Model model){
        TaxClass thisTaxClass =  taxClassService.findById(taxClassId);
        taxClassService.delete(thisTaxClass);
        return "redirect:/admin/taxClasses?page="+page;
    }
}
