package org.woehlke.greenshop.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.customer.entities.Zone;
import org.woehlke.greenshop.customer.repository.ZoneRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tw on 30.01.15.
 */
@Named("zoneService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class ZoneServiceImpl implements ZoneService {

    @Inject
    private ZoneRepository zoneRepository;

    @Override
    public Page<Zone> findAllZones(Pageable pageRequest) {
        return zoneRepository.findAll(pageRequest);
    }

    @Override
    public Zone findZoneById(long zoneId) {
        return zoneRepository.findOne(zoneId);
    }

    @Override
    public Map<Long, List<Zone>> getZoneMap() {
        List<Zone> zones = zoneRepository.findAll();
        Map<Long, List<Zone>> zoneMap = new LinkedHashMap<>();
        List<Zone> subZoneList = new ArrayList<>();
        long countryId = 0;
        for(Zone zone: zones){
            if(countryId != zone.getCountry().getId()){
                if(subZoneList.size()>0){
                    zoneMap.put(countryId,subZoneList);
                    subZoneList = new ArrayList<>();
                }
                countryId = zone.getCountry().getId();
            }
            subZoneList.add(zone);
        }
        return zoneMap;
    }

}
