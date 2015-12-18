package org.woehlke.greenshop.oodm.catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.Product;
import org.woehlke.greenshop.oodm.catalog.entities.ProductAttribute;

public interface ProductAttributeRepository extends 
	JpaRepository<ProductAttribute,Long> {
	
	List<ProductAttribute> findByProduct(Product product);
}
