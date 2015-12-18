package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.ProductOptionValue;
import org.woehlke.greenshop.oodm.catalog.entities.ProductOptionValueId;

public interface ProductOptionValueRepository extends 
	JpaRepository<ProductOptionValue,ProductOptionValueId>  {

}
