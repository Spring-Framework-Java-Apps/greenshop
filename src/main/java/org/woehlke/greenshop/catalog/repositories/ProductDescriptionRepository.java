package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ProductDescriptionId;

public interface ProductDescriptionRepository extends 
	JpaRepository<ProductDescription,ProductDescriptionId> {
	
}
