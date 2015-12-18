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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.woehlke.greenshop.backend.AdminMenuCategory;
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

    private final static int PAGE_SIZE = 20;

    private final static String FIRST_PAGE = "0";

    @RequestMapping(value = "/admin/countries", method = RequestMethod.GET)
    public String countries(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<Country> countries = countryService.findAllCountriesOrderByName(pageRequest);
        model.addAttribute("countries",countries);
        Country thisCountry = null;
        if(countries.getContent().size()>0){
            thisCountry = countries.iterator().next();
        }
        model.addAttribute("thisCountry",thisCountry);
        return "admin/taxes/countries";
    }

    @RequestMapping(value = "/admin/countries/{countryId}", method = RequestMethod.GET)
    public String countries( @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                            @PathVariable long countryId, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Country thisCountry = countryService.findCountryById(countryId);
        model.addAttribute("thisCountry",thisCountry);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<Country> countries = countryService.findAllCountriesOrderByName(pageRequest);
        model.addAttribute("countries",countries);
        return "admin/taxes/countries";
    }

    @RequestMapping(value = "/admin/countries/insert", method = RequestMethod.GET)
    public String countriesInsertForm(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<Country> countries = countryService.findAllCountriesOrderByName(pageRequest);
        model.addAttribute("countries",countries);
        Country thisCountry = new Country();
        model.addAttribute("thisCountry",thisCountry);
        List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
        model.addAttribute("addressFormats",addressFormats);
        return "admin/taxes/countriesInsertForm";
    }

    @RequestMapping(value = "/admin/countries/insert", method = RequestMethod.POST)
    public String countriesInsertPerform(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                         @Valid Country thisCountry, BindingResult result, Model model){
        logger.info("Country: "+thisCountry.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "name");
            Page<Country> countries = countryService.findAllCountriesOrderByName(pageRequest);
            model.addAttribute("countries",countries);
            model.addAttribute("thisCountry",thisCountry);
            List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
            model.addAttribute("addressFormats",addressFormats);
            return "admin/taxes/countriesInsertForm";
        } else {
            countryService.createCountry(thisCountry);
            return "redirect:/admin/countries/"+thisCountry.getId()+"?page="+page;
        }
    }

    @RequestMapping(value = "/admin/countries/{countryId}/edit", method = RequestMethod.GET)
    public String countriesEditForm(@PathVariable long countryId,
                                    @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                    Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Country thisCountry = countryService.findCountryById(countryId);
        model.addAttribute("thisCountry",thisCountry);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<Country> countries = countryService.findAllCountriesOrderByName(pageRequest);
        model.addAttribute("countries",countries);
        List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
        model.addAttribute("addressFormats",addressFormats);
        return "admin/taxes/countriesEditForm";
    }

    @RequestMapping(value = "/admin/countries/{countryId}/edit", method = RequestMethod.POST)
    public String countriesEditSave(@PathVariable long countryId,
                                    @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                    @Valid Country thisCountry, BindingResult result, Model model){
        logger.info("Country: "+thisCountry.toString());
        if(result.hasErrors()){
            int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
            model.addAttribute("menuCategory",menuCategory);
            Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "name");
            Page<Country> countries = countryService.findAllCountriesOrderByName(pageRequest);
            model.addAttribute("countries",countries);
            model.addAttribute("thisCountry",thisCountry);
            List<AddressFormat> addressFormats = addressFormatService.findAllAddressFormat();
            model.addAttribute("addressFormats",addressFormats);
            return "admin/taxes/countriesEditForm";
        } else {
            thisCountry.setId(countryId);
            countryService.updateCountry(thisCountry);
            return "redirect:/admin/countries/"+countryId+"?page="+page;
        }
    }

    @RequestMapping(value = "/admin/countries/{countryId}/delete", method = RequestMethod.GET)
    public String countriesDeleteForm(@PathVariable long countryId,
                                      @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                      Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Country thisCountry = countryService.findCountryById(countryId);
        model.addAttribute("thisCountry",thisCountry);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "name");
        Page<Country> countries = countryService.findAllCountriesOrderByName(pageRequest);
        model.addAttribute("countries",countries);
        return "admin/taxes/countriesDeleteForm";
    }

    @RequestMapping(value = "/admin/countries/{countryId}/delete", method = RequestMethod.POST)
    public String countriesDeleteSave(@PathVariable long countryId,
                                      @RequestParam(value="page",defaultValue=FIRST_PAGE) int page,
                                      Model model){
        Country thisCountry = countryService.findCountryById(countryId);
        countryService.deleteCountry(thisCountry);
        return "redirect:/admin/countries?page="+page;
    }
}
