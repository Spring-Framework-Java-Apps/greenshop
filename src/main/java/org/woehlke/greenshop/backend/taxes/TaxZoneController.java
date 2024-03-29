package org.woehlke.greenshop.backend.taxes;

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
import org.woehlke.greenshop.backend.AdminMenuCategory;
import org.woehlke.greenshop.oodm.admin.entities.TaxZone;
import org.woehlke.greenshop.oodm.admin.entities.TaxZone2Zone;
import org.woehlke.greenshop.oodm.admin.model.NewSubZoneInfoBean;
import org.woehlke.greenshop.oodm.admin.service.TaxZone2ZoneService;
import org.woehlke.greenshop.oodm.admin.service.TaxZoneService;
import org.woehlke.greenshop.oodm.customer.service.CountryService;
import org.woehlke.greenshop.oodm.customer.entities.Country;
import org.woehlke.greenshop.oodm.customer.entities.Zone;
import org.woehlke.greenshop.oodm.customer.service.ZoneService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class TaxZoneController {

    private static final Logger logger = LoggerFactory.getLogger(TaxZoneController.class);

    @Inject
    private CountryService countryService;

    @Inject
    private ZoneService zoneService;

    @Inject
    private TaxZoneService taxZoneService;

    @Inject
    private TaxZone2ZoneService taxZone2ZoneService;

    private final static int PAGE_SIZE = 20;

    private final static String FIRST_PAGE = "0";

    @RequestMapping(value = "/admin/taxZones", method = RequestMethod.GET)
    public String taxZones(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = null;
        int numberOfZones = 0;
        if(taxZones.getContent().size()>0){
            thisTaxZone = taxZones.iterator().next();
            numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        }
        model.addAttribute("thisTaxZone",thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        return "admin/taxes/taxZones";
    }

    @RequestMapping(value = "/admin/taxZones/{taxZoneId}", method = RequestMethod.GET)
    public String taxZoneId(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                            @PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        int numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxes/taxZones";
    }

    @RequestMapping(value = "/admin/taxZones/insert", method = RequestMethod.GET)
    public String taxZonesInsertForm(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = new TaxZone();
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxes/taxZonesInsertForm";
    }

    @RequestMapping(value = "/admin/taxZones/insert", method = RequestMethod.POST)
    public String taxZonesInsertSave(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                     @Valid TaxZone thisTaxZone, BindingResult result, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        if(result.hasErrors()){
            logger.info(result.toString());
            logger.info(thisTaxZone.toString());
            model.addAttribute("thisTaxZone",thisTaxZone);
            return "admin/taxes/taxZonesInsertForm";
        } else {
            thisTaxZone.setDateAdded(new Date());
            thisTaxZone = taxZoneService.createTaxZone(thisTaxZone);
            model.addAttribute("thisTaxZone",thisTaxZone);
            return "redirect:/admin/taxZones/"+thisTaxZone.getId()+"?page="+page;
        }
    }

    @RequestMapping(value = "/admin/taxZones/delete/{taxZoneId}", method = RequestMethod.GET)
    public String taxZoneDeleteForm(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                    @PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        int numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxes/taxZonesDeleteForm";
    }

    @RequestMapping(value = "/admin/taxZones/delete/{taxZoneId}", method = RequestMethod.POST)
    public String taxZoneDeletePerform(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                       @PathVariable long taxZoneId,
                                       @Valid TaxZone thisTaxZone,
                                       BindingResult result,
                                       Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        if(thisTaxZone != null) {
            taxZoneService.deleteTaxZones(thisTaxZone);
        }
        return "redirect:/admin/taxZones?page="+page;
    }

    @RequestMapping(value = "/admin/taxZones/edit/{taxZoneId}", method = RequestMethod.GET)
    public String taxZoneEditForm(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                  @PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        int numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxes/taxZonesEditForm";
    }

    @RequestMapping(value = "/admin/taxZones/edit/{taxZoneId}", method = RequestMethod.POST)
    public String taxZoneEditPerform(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                     @PathVariable long taxZoneId,
                                     @Valid TaxZone thisTaxZone,
                                     BindingResult result,
                                     Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = PageRequest.of(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<TaxZone> taxZones = taxZoneService.findAllTaxZones(pageRequest);
        model.addAttribute("taxZones",taxZones);
        if(result.hasErrors()) {
            model.addAttribute("thisTaxZone",thisTaxZone);
            return "admin/taxes/taxZonesEditForm";
        } else {
            taxZoneService.updateTaxZone(thisTaxZone);
            return "redirect:/admin/taxZones/"+taxZoneId+"?page="+page;
        }
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}", method = RequestMethod.GET)
    public String taxZone(@PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        List<TaxZone2Zone> zones = taxZone2ZoneService.findZonesByTaxZone(thisTaxZone);
        model.addAttribute("zones",zones);
        TaxZone2Zone thisZone = null;
        if(zones.size()>0){
            thisZone = zones.iterator().next();
        }
        model.addAttribute("thisZone", thisZone);
        return "admin/taxes/taxZone";
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/zone/{zoneId}", method = RequestMethod.GET)
    public String taxZoneWithZoneId(@PathVariable long taxZoneId, @PathVariable long zoneId,Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        List<TaxZone2Zone> zones = taxZone2ZoneService.findZonesByTaxZone(thisTaxZone);
        model.addAttribute("zones",zones);
        TaxZone2Zone thisZone = taxZone2ZoneService.findTaxZone2ZoneById(zoneId);
        model.addAttribute("thisZone",thisZone);
        return "admin/taxes/taxZone";
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/insert", method = RequestMethod.GET)
    public String taxZoneInsertForm(@PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        List<TaxZone2Zone> zones = taxZone2ZoneService.findZonesByTaxZone(thisTaxZone);
        model.addAttribute("zones",zones);
        TaxZone2Zone thisZone = null;
        if(zones.size()>0){
            thisZone = zones.iterator().next();
        }
        model.addAttribute("thisZone",thisZone);
        Map<Long,List<Zone>> zoneMap = zoneService.getZoneMap();
        model.addAttribute("zoneMap",zoneMap);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        return "admin/taxes/taxZoneInsertForm";
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/insert", method = RequestMethod.POST)
    public String taxZoneInsertSave(@PathVariable long taxZoneId,
                                    @ModelAttribute NewSubZoneInfoBean newSubZoneInfoBean,
                                    BindingResult result,
                                    Model model){
        logger.info("zone_country_id "+newSubZoneInfoBean.getZone_country_id());
        logger.info("zone_id         "+newSubZoneInfoBean.getZone_id());
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        if(result.hasErrors()||newSubZoneInfoBean.getZone_country_id()==null) {
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            model.addAttribute("thisTaxZone",thisTaxZone);
            List<TaxZone2Zone> zones = taxZone2ZoneService.findZonesByTaxZone(thisTaxZone);
            model.addAttribute("zones",zones);
            TaxZone2Zone thisZone = null;
            if(zones.size()>0){
                thisZone = zones.iterator().next();
            }
            model.addAttribute("thisZone",thisZone);
            return "admin/taxes/taxZoneInsertForm";
        } else {
            Country country = countryService.findCountryById(newSubZoneInfoBean.getZone_country_id());
            Zone subZone = null;
            if(newSubZoneInfoBean.getZone_id()!=null){
                subZone = zoneService.findById(newSubZoneInfoBean.getZone_id());
            }
            TaxZone2Zone newTaxZone2Zone = new TaxZone2Zone();
            newTaxZone2Zone.setDateAdded(new Date());
            newTaxZone2Zone.setTaxZone(thisTaxZone);
            newTaxZone2Zone.setZone(subZone);
            newTaxZone2Zone.setZoneCountry(country);
            taxZone2ZoneService.createTaxZone2Zone(newTaxZone2Zone);
            return "redirect:/admin/taxZone/"+taxZoneId;
        }
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/zone/{zoneId}/delete", method = RequestMethod.GET)
    public String taxZoneWithZoneIdDeleteForm(@PathVariable long taxZoneId, @PathVariable long zoneId,Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        List<TaxZone2Zone> zones = taxZone2ZoneService.findZonesByTaxZone(thisTaxZone);
        model.addAttribute("zones",zones);
        TaxZone2Zone thisZone = taxZone2ZoneService.findTaxZone2ZoneById(zoneId);
        model.addAttribute("thisZone",thisZone);
        return "admin/taxes/taxZoneDeleteForm";
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/zone/{zoneId}/delete", method = RequestMethod.POST)
    public String taxZoneWithZoneIdDeletePerform(@PathVariable long taxZoneId, @PathVariable long zoneId,Model model){
        TaxZone2Zone thisZone = taxZone2ZoneService.findTaxZone2ZoneById(zoneId);
        taxZone2ZoneService.deleteTaxZone2Zone(thisZone);
        return "redirect:/admin/taxZone/"+taxZoneId;
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/zone/{zoneId}/edit", method = RequestMethod.GET)
    public String taxZoneWithZoneIdEditForm(@PathVariable long taxZoneId, @PathVariable long zoneId,Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        List<TaxZone2Zone> zones = taxZone2ZoneService.findZonesByTaxZone(thisTaxZone);
        model.addAttribute("zones",zones);
        TaxZone2Zone thisZone = taxZone2ZoneService.findTaxZone2ZoneById(zoneId);
        model.addAttribute("thisZone",thisZone);
        Map<Long,List<Zone>> zoneMap = zoneService.getZoneMap();
        model.addAttribute("zoneMap",zoneMap);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        return "admin/taxes/taxZoneEditForm";
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/zone/{zoneId}/edit", method = RequestMethod.POST)
    public String taxZoneWithZoneIdEditPerform(@PathVariable long taxZoneId,
                                               @PathVariable long zoneId,
                                               @ModelAttribute NewSubZoneInfoBean newSubZoneInfoBean,
                                               BindingResult result,
                                               Model model){
        TaxZone2Zone thisZone = taxZone2ZoneService.findTaxZone2ZoneById(zoneId);
        if(result.hasErrors()||newSubZoneInfoBean.getZone_country_id()==null) {
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
            model.addAttribute("thisTaxZone",thisTaxZone);
            List<TaxZone2Zone> zones = taxZone2ZoneService.findZonesByTaxZone(thisTaxZone);
            model.addAttribute("zones",zones);
            model.addAttribute("thisZone",thisZone);
            return "admin/taxes/taxZoneEditForm";
        } else {
            Country country = countryService.findCountryById(newSubZoneInfoBean.getZone_country_id());
            Zone subZone = null;
            if(newSubZoneInfoBean.getZone_id()!=null){
                subZone = zoneService.findById(newSubZoneInfoBean.getZone_id());
            }
            thisZone.setZoneCountry(country);
            thisZone.setZone(subZone);
            taxZone2ZoneService.updateTaxZone2Zone(thisZone);
            return "redirect:/admin/taxZone/"+taxZoneId+"/zone/"+zoneId;
        }
    }

}
