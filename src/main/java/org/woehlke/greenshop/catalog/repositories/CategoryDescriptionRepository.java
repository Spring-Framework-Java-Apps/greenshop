package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.CategoryDescriptionId;

public interface CategoryDescriptionRepository extends JpaRepository<CategoryDescription,CategoryDescriptionId> {

}
