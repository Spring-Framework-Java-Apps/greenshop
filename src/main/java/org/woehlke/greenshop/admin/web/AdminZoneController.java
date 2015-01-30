package org.woehlke.greenshop.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.woehlke.greenshop.admin.AdminMenuCategory;
import org.woehlke.greenshop.customer.service.ZoneService;
import org.woehlke.greenshop.customer.entities.Zone;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Controller
public class AdminZoneController {

    @Inject
    private ZoneService zoneService;

    @RequestMapping(value = "/admin/zones", method = RequestMethod.GET)
    public String zones(Model model){
        int menuCategory = AdminMenuCategory.LOCATION_TAXES.ordinal();
        model.addAttribute("menuCategory",menuCategory);
        List<Zone> zones = zoneService.findAllZones();
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
        Zone thisZone = zoneService.findZoneById(zoneId);
        model.addAttribute("thisZone",thisZone);
        List<Zone> zones = zoneService.findAllZones();
        model.addAttribute("zones",zones);
        return "admin/zones";
    }
}
