package org.woehlke.greenshop.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.customer.entities.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
