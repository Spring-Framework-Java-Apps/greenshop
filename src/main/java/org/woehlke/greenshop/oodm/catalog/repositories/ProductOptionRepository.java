package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.ProductOption;
import org.woehlke.greenshop.oodm.catalog.entities.ProductOptionId;

public interface ProductOptionRepository extends 
	JpaRepository<ProductOption,ProductOptionId> {

}
