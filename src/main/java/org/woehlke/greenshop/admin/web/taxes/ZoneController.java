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
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.service.CountryService;
import org.woehlke.greenshop.customer.service.ZoneService;
import org.woehlke.greenshop.customer.entities.Zone;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class ZoneController {

    private static final Logger logger = LoggerFactory.getLogger(ZoneController.class);

    @Inject
    private ZoneService zoneService;

    @Inject
    private CountryService countryService;

    private final static int PAGE_SIZE = 20;

    private final static String FIRST_PAGE = "0";

    @RequestMapping(value = "/admin/zones", method = RequestMethod.GET)
    public String zones(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name","name");
        Page<Zone> zones = zoneService.findAll(pageRequest);
        model.addAttribute("zones",zones);
        Zone thisZone = null;
        if(zones.getContent().size()>0){
            thisZone = zones.iterator().next();
        }
        model.addAttribute("thisZone",thisZone);
        return "admin/taxes/zones";
    }

    @RequestMapping(value = "/admin/zones/{zoneId}", method = RequestMethod.GET)
    public String zoneId(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                         @PathVariable long zoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Zone thisZone = zoneService.findById(zoneId);
        model.addAttribute("thisZone",thisZone);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name","name");
        Page<Zone> zones = zoneService.findAll(pageRequest);
        model.addAttribute("zones",zones);
        return "admin/taxes/zones";
    }

    @RequestMapping(value = "/admin/zones/insert", method = RequestMethod.GET)
    public String zonesInsertForm(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name","name");
        Page<Zone> zones = zoneService.findAll(pageRequest);
        model.addAttribute("zones",zones);
        Zone thisZone = new Zone();
        model.addAttribute("thisZone",thisZone);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries", countries);
        return "admin/taxes/zonesInsertForm";
    }

    @RequestMapping(value = "/admin/zones/insert", method = RequestMethod.POST)
    public String zonesInsertPerform(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                     @Valid Zone thisZone, BindingResult result, Model model){
        logger.info("Zone: "+thisZone.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name","name");
            Page<Zone> zones = zoneService.findAll(pageRequest);
            model.addAttribute("zones",zones);
            model.addAttribute("thisZone",thisZone);
            List<Country> countries = countryService.findAllCountriesOrderByName();
            model.addAttribute("countries", countries);
            return "admin/taxes/countriesInsertForm";
        } else {
            zoneService.createZone(thisZone);
            return "redirect:/admin/zones/"+thisZone.getId()+ "?page="+page;
        }
    }

    @RequestMapping(value = "/admin/zones/{zoneId}/edit", method = RequestMethod.GET)
    public String zonesEditForm(@PathVariable long zoneId,
                                @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Zone thisZone = zoneService.findById(zoneId);
        model.addAttribute("thisZone",thisZone);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name","name");
        Page<Zone> zones = zoneService.findAll(pageRequest);
        model.addAttribute("zones",zones);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        return "admin/taxes/zonesEditForm";
    }

    @RequestMapping(value = "/admin/zones/{zoneId}/edit", method = RequestMethod.POST)
    public String zonesEditSave(@PathVariable long zoneId,
                                @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                @Valid Zone thisZone, BindingResult result, Model model){
        logger.info("Zone: "+thisZone.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name","name");
            Page<Zone> zones = zoneService.findAll(pageRequest);
            model.addAttribute("zones",zones);
            model.addAttribute("thisZone",thisZone);
            List<Country> countries = countryService.findAllCountriesOrderByName();
            model.addAttribute("countries",countries);
            return "admin/taxes/zonesEditForm";
        } else {
            thisZone.setId(zoneId);
            zoneService.update(thisZone);
            return "redirect:/admin/zones/"+zoneId+"?page="+page;
        }
    }

    @RequestMapping(value = "/admin/zones/{zoneId}/delete", method = RequestMethod.GET)
    public String zonesDeleteForm(@PathVariable long zoneId,
                                  @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                  Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Zone thisZone = zoneService.findById(zoneId);
        model.addAttribute("thisZone",thisZone);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name","name");
        Page<Zone> zones = zoneService.findAll(pageRequest);
        model.addAttribute("zones",zones);
        return "admin/taxes/zonesDeleteForm";
    }

    @RequestMapping(value = "/admin/zones/{zoneId}/delete", method = RequestMethod.POST)
    public String zonesDeleteSave(@PathVariable long zoneId,
                                  @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                  Model model){
        Zone thisZone = zoneService.findById(zoneId);
        zoneService.delete(thisZone);
        return "redirect:/admin/zones?page="+page;
    }
}
