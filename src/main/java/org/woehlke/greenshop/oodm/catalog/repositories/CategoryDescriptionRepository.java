package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.oodm.catalog.entities.CategoryDescriptionId;

public interface CategoryDescriptionRepository extends JpaRepository<CategoryDescription,CategoryDescriptionId> {

}
