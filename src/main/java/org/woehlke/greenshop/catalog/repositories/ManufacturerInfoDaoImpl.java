package org.woehlke.greenshop.catalog.repositories;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.catalog.entities.ManufacturerInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by tw on 24.12.14.
 */
@Repository
public class ManufacturerInfoDaoImpl implements ManufacturerInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ManufacturerInfo update(ManufacturerInfo manufacturerInfo) {
        return entityManager.merge(manufacturerInfo);
    }
}
