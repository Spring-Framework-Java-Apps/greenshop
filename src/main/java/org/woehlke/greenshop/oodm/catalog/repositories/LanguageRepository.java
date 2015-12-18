package org.woehlke.greenshop.oodm.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.Language;

public interface LanguageRepository extends JpaRepository<Language,Long> {

	Language findByCode(String code);
}
