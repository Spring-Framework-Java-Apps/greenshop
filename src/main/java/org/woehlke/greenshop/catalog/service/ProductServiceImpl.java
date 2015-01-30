package org.woehlke.greenshop.catalog.service;

import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.repositories.ProductDescriptionRepository;
import org.woehlke.greenshop.catalog.repositories.ProductRepository;
import org.woehlke.greenshop.catalog.repositories.ProductRepositoryDao;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("productService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private ProductRepositoryDao productRepositoryDao;

    @Inject
    private ProductDescriptionRepository productDescriptionRepository;

    @Override
    public int countProductsOfThisManufacturer(Manufacturer thisManufacturer) {
        List<Product> list = productRepository.findByManufacturer(thisManufacturer);
        return list.size();
    }

    @Override
    public List<ProductDescription> findProductsViewed(Language language) {
        Sort sort = new Sort(Sort.Direction.DESC,"viewed");
        return productDescriptionRepository.findAll(sort);
    }

    @Override
    public List<ProductDescription> findProductsByCategoryId(long categoryId, Language language) {
        List<ProductDescription> productsByCategoryId = new ArrayList<>();
        List<Product> products = productRepositoryDao.findByCategoryId(categoryId);
        for(Product product :products){
            ProductDescriptionId id = new ProductDescriptionId();
            id.setProduct(product);
            id.setLanguage(language);
            ProductDescription productDescription = productDescriptionRepository.findOne(id);
            productsByCategoryId.add(productDescription);
        }
        return productsByCategoryId;
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void setProductActive(long productId) {
        Product product = productRepository.findOne(productId);
        product.setStatus(true);
        productRepository.save(product);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void setProductInactive(long productId) {
        Product product = productRepository.findOne(productId);
        product.setStatus(false);
        productRepository.save(product);
    }
}
