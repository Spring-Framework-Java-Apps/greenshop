package org.woehlke.greenshop.admin.web.taxes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.customer.service.ZoneService;
import org.woehlke.greenshop.customer.entities.Zone;

import javax.inject.Inject;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class ZoneController {

    @Inject
    private ZoneService zoneService;


    private final static int PAGE_SIZE = 20;

    private final static String FIRST_PAGE = "0";

    @RequestMapping(value = "/admin/zones", method = RequestMethod.GET)
    public String zones(@RequestParam(value="page",defaultValue=FIRST_PAGE) int page, Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name");
        Page<Zone> zones = zoneService.findAllZones(pageRequest);
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
        Zone thisZone = zoneService.findZoneById(zoneId);
        model.addAttribute("thisZone",thisZone);
        Pageable pageRequest = new PageRequest(page,PAGE_SIZE, Sort.Direction.ASC, "country.name");
        Page<Zone> zones = zoneService.findAllZones(pageRequest);
        model.addAttribute("zones",zones);
        return "admin/taxes/zones";
    }
}
