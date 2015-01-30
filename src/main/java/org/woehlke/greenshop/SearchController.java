package org.woehlke.greenshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.model.AdvancedSearchBean;
import org.woehlke.greenshop.catalog.model.CategoriesBean;

import javax.validation.Valid;

/**
 * Created by tw on 01.01.15.
 */
@Controller
@SessionAttributes({"transientBasket"})
public class SearchController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET)
    public String showAdvancedSearchForm(Model model){
        Language language = languageService.findLanguageByCode("en");
        super.getDefaultBoxContent(model);
        AdvancedSearchBean advancedSearchBean = new AdvancedSearchBean();
        model.addAttribute("advancedSearchBean", advancedSearchBean);
        CategoriesBean categoriesBean = super.catalogService.getAllCategories(language);
        model.addAttribute("categoriesBean", categoriesBean);
        return "advancedSearch";
    }

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.POST)
    public String showAdvancedSearchFormPost(
            @Valid AdvancedSearchBean advancedSearchBean,
            BindingResult result,
            Model model){
        super.getDefaultBoxContent(model);
        logger.info(advancedSearchBean.toString());
        return "advancedSearch";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showAdvancedSearchForm(
            @RequestParam String keywords, Model model){
        Language language = languageService.findLanguageByCode("en");
        super.getDefaultBoxContent(model);
        logger.info(keywords);
        return "searchResult";
    }
}
