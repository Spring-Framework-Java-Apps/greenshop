package org.woehlke.greenshop.catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	@Query("select p from Product p where MONTH(p.dateAdded)=:month and YEAR(p.dateAdded)=:year and p.status=true order by p.dateAdded DESC")
	List<Product> findByMonth(@Param("month") int month, @Param("year") int year);

	List<Product> findByManufacturer(Manufacturer thisManufacturer);
}
