package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.ManufacturerInfo;
import org.woehlke.greenshop.catalog.entities.ManufacturerInfoId;

/**
 * Created by tw on 24.12.14.
 */
public interface ManufacturerInfoRepository extends
        JpaRepository<ManufacturerInfo,ManufacturerInfoId> {
}
