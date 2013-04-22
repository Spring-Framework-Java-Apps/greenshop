package org.woehlke.greenshop.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.customer.entities.AddressFormat;

public interface AddressFormatRepository extends JpaRepository<AddressFormat,Long> {

}
