package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {

}
