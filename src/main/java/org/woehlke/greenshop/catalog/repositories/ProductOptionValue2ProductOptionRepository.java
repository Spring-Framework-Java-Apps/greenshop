package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.ProductOptionValue2ProductOption;

public interface ProductOptionValue2ProductOptionRepository extends 
	JpaRepository<ProductOptionValue2ProductOption,Long>{

}
