package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.ProductOption;
import org.woehlke.greenshop.catalog.entities.ProductOptionId;

public interface ProductOptionRepository extends 
	JpaRepository<ProductOption,ProductOptionId> {

}
