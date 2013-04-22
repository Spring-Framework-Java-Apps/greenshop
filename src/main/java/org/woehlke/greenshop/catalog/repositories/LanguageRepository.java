package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.Language;

public interface LanguageRepository extends JpaRepository<Language,Long> {

	Language findByCode(String code);
}
