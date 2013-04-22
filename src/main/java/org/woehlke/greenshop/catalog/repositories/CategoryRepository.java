package org.woehlke.greenshop.catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
	List<Category> findByparentId(long parentId);
}
