package org.woehlke.greenshop.admin.web.taxes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.customer.service.AddressFormatService;
import org.woehlke.greenshop.customer.service.CountryService;
import org.woehlke.greenshop.customer.entities.AddressFormat;
import org.woehlke.greenshop.customer.entities.Country;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Inject
    private CountryService countryService;

    @Inject
    private AddressFormatService addressFormatService;

    @RequestMapping(value = "/admin/countries", method = RequestMethod.GET)
    public String countries(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Country> countries = countryService.findAllCountriesOrderByName();
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
        Country thisCountry = countryService.findCountryById(countryId);
        model.addAttribute("thisCountry",thisCountry);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        return "admin/countries";
    }

    @RequestMapping(value = "/admin/countries/insert", method = RequestMethod.GET)
    public String countriesInsertForm(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        Country thisCountry = new Country();
        model.addAttribute("thisCountry",thisCountry);
        List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
        model.addAttribute("addressFormats",addressFormats);
        return "admin/countriesInsertForm";
    }

    @RequestMapping(value = "/admin/countries/insert", method = RequestMethod.POST)
    public String countriesInsertPerform(@Valid Country thisCountry, BindingResult result, Model model){
        logger.info("Country: "+thisCountry.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            List<Country> countries = countryService.findAllCountriesOrderByName();
            model.addAttribute("countries",countries);
            model.addAttribute("thisCountry",thisCountry);
            List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
            model.addAttribute("addressFormats",addressFormats);
            return "admin/countriesInsertForm";
        } else {
            countryService.createCountry(thisCountry);
            return "redirect:/admin/countries/"+thisCountry.getId();
        }
    }

    @RequestMapping(value = "/admin/countries/{countryId}/edit", method = RequestMethod.GET)
    public String countriesEditForm(@PathVariable long countryId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Country thisCountry = countryService.findCountryById(countryId);
        model.addAttribute("thisCountry",thisCountry);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
        model.addAttribute("addressFormats",addressFormats);
        return "admin/countriesEditForm";
    }

    @RequestMapping(value = "/admin/countries/{countryId}/edit", method = RequestMethod.POST)
    public String countriesEditSave(@PathVariable long countryId, @Valid Country thisCountry, BindingResult result, Model model){
        logger.info("Country: "+thisCountry.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            List<Country> countries = countryService.findAllCountriesOrderByName();
            model.addAttribute("countries",countries);
            model.addAttribute("thisCountry",thisCountry);
            List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
            model.addAttribute("addressFormats",addressFormats);
            return "admin/countriesEditForm";
        } else {
            thisCountry.setId(countryId);
            countryService.updateCountry(thisCountry);
            return "redirect:/admin/countries/"+countryId;
        }
    }

    @RequestMapping(value = "/admin/countries/{countryId}/delete", method = RequestMethod.GET)
    public String countriesDeleteForm(@PathVariable long countryId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Country thisCountry = countryService.findCountryById(countryId);
        model.addAttribute("thisCountry",thisCountry);
        List<Country> countries = countryService.findAllCountriesOrderByName();
        model.addAttribute("countries",countries);
        return "admin/countriesDeleteForm";
    }

    @RequestMapping(value = "/admin/countries/{countryId}/delete", method = RequestMethod.POST)
    public String countriesDeleteSave(@PathVariable long countryId, Model model){
        Country thisCountry = countryService.findCountryById(countryId);
        countryService.deleteCountry(thisCountry);
        return "redirect:/admin/countries";
    }
}
