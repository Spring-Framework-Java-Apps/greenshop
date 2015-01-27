package org.woehlke.greenshop.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.entities.TaxClass;
import org.woehlke.greenshop.admin.entities.TaxRate;
import org.woehlke.greenshop.admin.entities.TaxZone;
import org.woehlke.greenshop.admin.entities.TaxZone2Zone;
import org.woehlke.greenshop.customer.CustomerService;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Zone;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class AdminLocationTaxesController {

    @Inject
    private CustomerService customerService;

    @Inject
    private AdminService adminService;

    @RequestMapping(value = "/admin/countries", method = RequestMethod.GET)
    public String countries(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Country> countries = customerService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        Country thisCountry = null;
        if(countries.size()>0){
            thisCountry = countries.iterator().next();
        }
        model.addAttribute("thisCountry",thisCountry);
        return "admin/countries";
    }

    @RequestMapping(value = "/admin/countries/{countryId}", method = RequestMethod.GET)
    public String countries(@PathVariable long countryId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Country thisCountry = customerService.findCountryById(countryId);
        model.addAttribute("thisCountry",thisCountry);
        List<Country> countries = customerService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        return "admin/countries";
    }

    @RequestMapping(value = "/admin/zones", method = RequestMethod.GET)
    public String zones(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Zone> zones = customerService.findAllZones();
        model.addAttribute("zones",zones);
        Zone thisZone = null;
        if(zones.size()>0){
            thisZone = zones.iterator().next();
        }
        model.addAttribute("thisZone",thisZone);
        return "admin/zones";
    }

    @RequestMapping(value = "/admin/zones/{zoneId}", method = RequestMethod.GET)
    public String zoneId(@PathVariable long zoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Zone thisZone = customerService.findZoneById(zoneId);
        model.addAttribute("thisZone",thisZone);
        List<Zone> zones = customerService.findAllZones();
        model.addAttribute("zones",zones);
        return "admin/zones";
    }

    @RequestMapping(value = "/admin/taxZones", method = RequestMethod.GET)
    public String taxZones(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = adminService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = null;
        if(taxZones.size()>0){
            thisTaxZone = taxZones.iterator().next();
        }
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxZones";
    }

    @RequestMapping(value = "/admin/taxZones/{taxZoneId}", method = RequestMethod.GET)
    public String taxZoneId(@PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxZone> taxZones = adminService.findAllTaxZones();
        model.addAttribute("taxZones",taxZones);
        TaxZone thisTaxZone = adminService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        return "admin/taxZones";
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}", method = RequestMethod.GET)
    public String taxZone(@PathVariable long taxZoneId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxZone thisTaxZone = adminService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        List<TaxZone2Zone> zones = adminService.findZonesByTaxZone(thisTaxZone);
        model.addAttribute("zones",zones);
        TaxZone2Zone thisZone = null;
        if(zones.size()>0){
            thisZone = zones.iterator().next();
        }
        model.addAttribute("thisZone",thisZone);
        return "admin/taxZone";
    }

    @RequestMapping(value = "/admin/taxZone/{taxZoneId}/zone/{zoneId}", method = RequestMethod.GET)
    public String taxZoneWithZoneId(@PathVariable long taxZoneId, @PathVariable long zoneId,Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        TaxZone thisTaxZone = adminService.findTaxZoneById(taxZoneId);
        model.addAttribute("thisTaxZone",thisTaxZone);
        List<TaxZone2Zone> zones = adminService.findZonesByTaxZone(thisTaxZone);
        model.addAttribute("zones",zones);
        TaxZone2Zone thisZone = adminService.findTaxZone2ZoneById(zoneId);
        model.addAttribute("thisZone",thisZone);
        return "admin/taxZone";
    }

    @RequestMapping(value = "/admin/taxClasses", method = RequestMethod.GET)
    public String taxClasses(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxClass> taxClasses = adminService.findAllTaxClasses();
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
        List<TaxClass> taxClasses = adminService.findAllTaxClasses();
        model.addAttribute("taxClasses",taxClasses);
        TaxClass thisTaxClass = null;
        if(taxClasses.size()>0){
            thisTaxClass =  adminService.findTaxClassById(taxClassId);
        }
        model.addAttribute("thisTaxClass",thisTaxClass);
        return "admin/taxClasses";
    }

    @RequestMapping(value = "/admin/taxRates", method = RequestMethod.GET)
    public String taxRates(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxRate> taxRates = adminService.findAllTaxRates();
        model.addAttribute("taxRates",taxRates);
        TaxRate thisTaxRate = null;
        if(taxRates.size()>0){
            thisTaxRate =  taxRates.iterator().next();
        }
        model.addAttribute("thisTaxRate",thisTaxRate);
        return "admin/taxRates";
    }

    @RequestMapping(value = "/admin/taxRates/{taxRateId}", method = RequestMethod.GET)
    public String taxRateId(@PathVariable long taxRateId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<TaxRate> taxRates = adminService.findAllTaxRates();
        model.addAttribute("taxRates",taxRates);
        TaxRate thisTaxRate = null;
        if(taxRates.size()>0){
            thisTaxRate =  adminService.findTaxRateById(taxRateId);
        }
        model.addAttribute("thisTaxRate",thisTaxRate);
        return "admin/taxRates";
    }
}
