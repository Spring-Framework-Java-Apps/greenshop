package org.woehlke.greenshop.oodm.catalog.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.repositories.LanguageRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("languageService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class LanguageServiceImpl implements LanguageService {

    @Inject
    private LanguageRepository languageRepository;

    @Override
    public Language findLanguageByCode(String code) {
        return languageRepository.findByCode(code);
    }

    @Override
    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language findLanguageById(long languageId) {
        return languageRepository.findOne(languageId);
    }
}
