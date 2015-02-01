package org.woehlke.greenshop.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.woehlke.greenshop.customer.entities.Zone;

import java.util.List;
import java.util.Map;

/**
 * Created by tw on 30.01.15.
 */
public interface ZoneService {

    Page<Zone> findAllZones(Pageable pageRequest);

    Zone findZoneById(long zoneId);

    Map<Long, List<Zone>> getZoneMap();

}
