package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.woehlke.greenshop.oodm.catalog.entities.Manufacturer;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {

    @Query("select m from Manufacturer m order by m.name")
    List<Manufacturer> findAllOrderByName();
}
