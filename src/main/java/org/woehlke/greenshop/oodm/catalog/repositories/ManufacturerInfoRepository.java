package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.ManufacturerInfo;
import org.woehlke.greenshop.oodm.catalog.entities.ManufacturerInfoId;

/**
 * Created by tw on 24.12.14.
 */
public interface ManufacturerInfoRepository extends
        JpaRepository<ManufacturerInfo,ManufacturerInfoId> {
}
