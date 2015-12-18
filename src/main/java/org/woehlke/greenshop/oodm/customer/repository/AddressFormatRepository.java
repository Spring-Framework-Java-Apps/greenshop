package org.woehlke.greenshop.oodm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.customer.entities.AddressFormat;

public interface AddressFormatRepository extends JpaRepository<AddressFormat,Long> {

}
