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
    public Page<Zone> findAll(Pageable pageRequest) {
        return zoneRepository.findAll(pageRequest);
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

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void createZone(Zone thisZone) {
        thisZone=zoneRepository.save(thisZone);
    }

    @Override
    public Zone findById(long zoneId) {
        return zoneRepository.findOne(zoneId);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void update(Zone thisZone) {
        thisZone=zoneRepository.save(thisZone);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void delete(Zone thisZone) {
        zoneRepository.delete(thisZone);
    }

}
