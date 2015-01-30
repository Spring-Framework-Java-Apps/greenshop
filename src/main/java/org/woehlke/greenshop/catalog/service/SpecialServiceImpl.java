package org.woehlke.greenshop.catalog.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.Special;
import org.woehlke.greenshop.catalog.model.SpecialProduct;
import org.woehlke.greenshop.catalog.repositories.ProductDescriptionRepositoryDao;
import org.woehlke.greenshop.catalog.repositories.SpecialRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tw on 30.01.15.
 */
@Named("specialService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class SpecialServiceImpl implements SpecialService {

    @Inject
    private SpecialRepository specialRepository;

    @Inject
    private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void updateSpecial(Special special) {
        specialRepository.save(special);
    }

    @Override
    public SpecialProduct findSpecialProductById(long productId, Language language) {
        ProductDescription productDescription =
                productDescriptionRepositoryDao.findByProductIdAndLanguage(productId, language);
        Special special = specialRepository.findByProduct(productDescription.getProduct());
        SpecialProduct specialProduct = new SpecialProduct();
        specialProduct.setProductDescription(productDescription);
        specialProduct.setSpecial(special);
        return specialProduct;
    }

    @Override
    public SpecialProduct getRandomSpecial(Language language) {
        SpecialProduct specialProduct = new SpecialProduct();
        List<Special> specials = specialRepository.findAll();
        int listLength = specials.size();
        Random random = new Random();
        int index = random.nextInt(listLength);
        Special special = specials.get(index);
        specialProduct.setSpecial(special);
        ProductDescription productDescription =
                productDescriptionRepositoryDao.findByProductIdAndLanguage(
                        special.getProduct().getId(),language);
        specialProduct.setProductDescription(productDescription);
        return specialProduct;
    }

    @Override
    public List<SpecialProduct> getSpecialProducts(Language language) {
        List<SpecialProduct> specialProducts = new ArrayList<SpecialProduct>();
        List<Special> specials = specialRepository.findAll();
        for(Special special:specials){
            SpecialProduct specialProduct = new SpecialProduct();
            specialProduct.setSpecial(special);
            ProductDescription productDescription =
                    productDescriptionRepositoryDao.findByProductIdAndLanguage(
                            special.getProduct().getId(),language);
            specialProduct.setProductDescription(productDescription);
            specialProducts.add(specialProduct);
        }
        return specialProducts;
    }
}
