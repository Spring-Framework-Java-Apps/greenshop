package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.ProductOptionValue;
import org.woehlke.greenshop.catalog.entities.ProductOptionValueId;

public interface ProductOptionValueRepository extends 
	JpaRepository<ProductOptionValue,ProductOptionValueId>  {

}
