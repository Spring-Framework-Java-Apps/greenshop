package org.woehlke.greenshop.admin.web.taxes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.admin.entities.TaxZone;
import org.woehlke.greenshop.admin.entities.TaxZone2Zone;
import org.woehlke.greenshop.admin.model.NewSubZoneInfoBean;
import org.woehlke.greenshop.admin.service.TaxZone2ZoneService;
import org.woehlke.greenshop.admin.service.TaxZoneService;
import org.woehlke.greenshop.customer.service.CountryService;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Zone;
import org.woehlke.greenshop.customer.service.ZoneService;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class AdminTaxZoneController {

    private static final Logger logger = LoggerFactory.getLogger(AdminTaxZoneController.class);

    @Inject
    private CountryService countryService;

    @Inject
    private ZoneService zoneService;

    @Inject
    private TaxZoneService taxZoneService;

    @Inject
    private TaxZone2ZoneService taxZone2ZoneService;

    @RequestMapping(value = "/admin/taxZones", method = RequestMethod.GET)
    public String taxZones(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = null;
        int numberOfZones = 0;
        if(taxZones.size()>0){
            thisTaxZone = taxZones.iterator().next();
            numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        }
        model.addAttribute("thisTaxZone",thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        return "admin/taxZones";
    }

    @RequestMapping(value = "/admin/taxZones/{taxZoneId}", method = RequestMethod.GET)
    public String taxZoneId(@PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        int numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxZones";
    }

    @RequestMapping(value = "/admin/taxZones/insert", method = RequestMethod.GET)
    public String taxZonesInsertForm(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = new TaxZone();
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxZonesInsertForm";
    }

    @RequestMapping(value = "/admin/taxZones/insert", method = RequestMethod.POST)
    public String taxZonesInsertSave(@Valid TaxZone thisTaxZone, BindingResult result, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        if(result.hasErrors()){
            logger.info(result.toString());
            logger.info(thisTaxZone.toString());
            model.addAttribute("thisTaxZone",thisTaxZone);
            return "admin/taxZonesInsertForm";
        } else {
            thisTaxZone.setDateAdded(new Date());
            thisTaxZone = taxZoneService.createTaxZone(thisTaxZone);
            model.addAttribute("thisTaxZone",thisTaxZone);
            return "redirect:/admin/taxZones/"+thisTaxZone.getId();
        }
    }

    @RequestMapping(value = "/admin/taxZones/delete/{taxZoneId}", method = RequestMethod.GET)
    public String taxZoneDeleteForm(@PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        int numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxZonesDeleteForm";
    }

    @RequestMapping(value = "/admin/taxZones/delete/{taxZoneId}", method = RequestMethod.POST)
    public String taxZoneDeletePerform(@PathVariable long taxZoneId,
                                       @Valid TaxZone thisTaxZone,
                                       BindingResult result,
                                       Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        if(thisTaxZone != null) {
            taxZoneService.deleteTaxZones(thisTaxZone);
        }
        return "redirect:/admin/taxZones";
    }

    @RequestMapping(value = "/admin/taxZones/edit/{taxZoneId}", method = RequestMethod.GET)
    public String taxZoneEditForm(@PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = taxZoneService.findTaxZoneById(taxZoneId);
        int numberOfZones = taxZone2ZoneService.getNumberOfZonesForTaxZone(thisTaxZone);
        model.addAttribute("numberOfZones",numberOfZones);
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxZonesEditForm";
    }

    @RequestMapping(value = "/admin/taxZones/edit/{taxZoneId}", method = RequestMethod.POST)
    public String taxZoneEditPerform(@PathVariable long taxZoneId,
                                     @Valid TaxZone thisTaxZone,
                                     BindingResult result,
                                     Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = taxZoneService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        if(result.hasErrors()) {
            model.addAttribute("thisTaxZone",thisTaxZone);
            return "admin/taxZonesEditForm";
        } else {
            taxZoneService.updateTaxZone(thisTaxZone);
            return "redirect:/admin/taxZones/"+taxZoneId;
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
        return "admin/taxZone";
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
        return "admin/taxZone";
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
        return "admin/taxZoneInsertForm";
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
            return "admin/taxZoneInsertForm";
        } else {
            Country country = countryService.findCountryById(newSubZoneInfoBean.getZone_country_id());
            Zone subZone = null;
            if(newSubZoneInfoBean.getZone_id()!=null){
                subZone = zoneService.findZoneById(newSubZoneInfoBean.getZone_id());
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
        return "admin/taxZoneDeleteForm";
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
        return "admin/taxZoneEditForm";
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
            return "admin/taxZoneEditForm";
        } else {
            Country country = countryService.findCountryById(newSubZoneInfoBean.getZone_country_id());
            Zone subZone = null;
            if(newSubZoneInfoBean.getZone_id()!=null){
                subZone = zoneService.findZoneById(newSubZoneInfoBean.getZone_id());
            }
            thisZone.setZoneCountry(country);
            thisZone.setZone(subZone);
            taxZone2ZoneService.updateTaxZone2Zone(thisZone);
            return "redirect:/admin/taxZone/"+taxZoneId+"/zone/"+zoneId;
        }
    }

}
