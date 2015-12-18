package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.ProductOptionValue2ProductOption;

public interface ProductOptionValue2ProductOptionRepository extends 
	JpaRepository<ProductOptionValue2ProductOption,Long>{

}
