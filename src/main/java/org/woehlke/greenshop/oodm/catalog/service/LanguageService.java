package org.woehlke.greenshop.oodm.catalog.service;

import org.woehlke.greenshop.oodm.catalog.entities.Language;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface LanguageService {

    Language findLanguageByCode(String code);

    List<Language> findAllLanguages();

    Language findLanguageById(long languageId);
}
