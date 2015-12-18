package org.woehlke.greenshop.backend.localization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.backend.AdminMenuCategory;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.service.LanguageService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 04.01.15.
 */
@Controller
public class LanguageController {

    @Inject
    private LanguageService languageService;

    @RequestMapping(value = "/admin/languages", method = RequestMethod.GET)
    public String languages(Model model){
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Language> languages = languageService.findAllLanguages();
        model.addAttribute("languages",languages);
        Language thisLanguage = null;
        if(languages.size()>0){
            thisLanguage = languages.iterator().next();
        }
        model.addAttribute("thisLanguage",thisLanguage);
        return "admin/localization/languages";
    }

    @RequestMapping(value = "/admin/languages/{languageId}", method = RequestMethod.GET)
    public String languageId(@PathVariable long languageId, Model model){
        int menuCategory = AdminMenuCategory.LOCALISATION.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Language> languages = languageService.findAllLanguages();
        model.addAttribute("languages", languages);
        Language thisLanguage = languageService.findLanguageById(languageId);
        model.addAttribute("thisLanguage",thisLanguage);
        return "admin/localization/languages";
    }
}
