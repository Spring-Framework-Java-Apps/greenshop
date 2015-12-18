package org.woehlke.greenshop.oodm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.customer.entities.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
