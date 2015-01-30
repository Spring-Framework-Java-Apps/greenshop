package org.woehlke.greenshop.catalog.service;

import org.woehlke.greenshop.catalog.entities.Language;

/**
 * Created by tw on 30.01.15.
 */
public interface LanguageService {

    Language findLanguageByCode(String code);
}
