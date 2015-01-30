package org.woehlke.greenshop.customer.service;

import org.woehlke.greenshop.customer.entities.Zone;

import java.util.List;
import java.util.Map;

/**
 * Created by tw on 30.01.15.
 */
public interface ZoneService {

    List<Zone> findAllZones();

    Zone findZoneById(long zoneId);

    Map<Long, List<Zone>> getZoneMap();

}
