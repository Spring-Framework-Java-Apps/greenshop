package org.woehlke.greenshop.catalog.service;

import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Special;
import org.woehlke.greenshop.catalog.model.SpecialProduct;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface SpecialService {

    void updateSpecial(Special special);

    SpecialProduct findSpecialProductById(long productId, Language language);

    SpecialProduct getRandomSpecial(Language language);

    List<SpecialProduct> getSpecialProducts(Language language);
}
