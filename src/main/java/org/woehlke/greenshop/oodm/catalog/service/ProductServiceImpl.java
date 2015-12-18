package org.woehlke.greenshop.oodm.catalog.service;

import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.catalog.entities.*;
import org.woehlke.greenshop.oodm.catalog.model.ProductsByManufacturer;
import org.woehlke.greenshop.oodm.catalog.model.SpecialProduct;
import org.woehlke.greenshop.oodm.catalog.repositories.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;

    @Inject
    private SpecialRepository specialRepository;

    @Inject
    private ProductDescriptionRepository productDescriptionRepository;

    @Inject
    private ProductDescriptionDao productDescriptionDao;

    @Inject
    private CategoryDescriptionRepository categoryDescriptionRepository;

    @Inject
    private CategoryRepository categoryRepository;

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

    @Override
    public ProductDescription findProductById(long productId, Language language) {
        return productDescriptionRepositoryDao.findByProductIdAndLanguage(productId, language);
    }

    @Override
    public List<SpecialProduct> recommenderNewProducts(Language language) {
        int limit = 9;
        List<SpecialProduct> newProducts = new ArrayList<SpecialProduct>();
        List<ProductDescription> productDescriptions =
                productDescriptionRepositoryDao.findByLanguageOrderByDateAdded(language, limit);
        for(ProductDescription productDescription : productDescriptions){
            SpecialProduct newProduct = new SpecialProduct();
            newProduct.setProductDescription(productDescription);
            Special special = specialRepository.findByProduct(productDescription.getProduct());
            newProduct.setSpecial(special);
            newProducts.add(newProduct);
        }
        return newProducts;
    }

    @Override
    public SpecialProduct getRandomNewProduct(Language language) {
        int limit = 100;
        SpecialProduct newProduct = new SpecialProduct();
        List<ProductDescription> productDescriptions =
                productDescriptionRepositoryDao.findByLanguageOrderByDateAdded(language, limit);
        int listLength = productDescriptions.size();
        Random random = new Random();
        int index = random.nextInt(listLength);
        ProductDescription productDescription = productDescriptions.get(index);
        newProduct.setProductDescription(productDescription);
        Special special = specialRepository.findByProduct(productDescription.getProduct());
        newProduct.setSpecial(special);
        return newProduct;
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public SpecialProduct viewProduct(SpecialProduct thisProduct) {
        ProductDescription productDescription = thisProduct.getProductDescription();
        productDescription.incViewed();
        productDescription = productDescriptionDao.update(productDescription);
        thisProduct.setProductDescription(productDescription);
        return thisProduct;
    }

    @Override
    public ProductsByManufacturer findProductsByManufacturer(
            Manufacturer manufacturer, Language language) {
        List<ProductDescription> products = productDescriptionRepositoryDao.findByManufacturer(manufacturer, language);
        ProductsByManufacturer productsByManufacturer = new ProductsByManufacturer();
        productsByManufacturer.setProducts(products);
        List<Category> categories = new ArrayList<Category>();
        for(ProductDescription product:products){
            List<Category> categoriesOfOneProduct = product.getProduct().getCategories();
            for(Category categoryOfOneProduct:categoriesOfOneProduct){
                if(!categories.contains(categoryOfOneProduct)){
                    categories.add(categoryOfOneProduct);
                }
            }
        }
        List<CategoryDescription> categoriesOfProducts=new ArrayList<CategoryDescription>();
        for(Category category:categories){
            CategoryDescriptionId id = new CategoryDescriptionId();
            id.setCategory(category);
            id.setLanguage(language);
            CategoryDescription cd = categoryDescriptionRepository.findOne(id);
            categoriesOfProducts.add(cd);
        }
        productsByManufacturer.setCategoriesOfProducts(categoriesOfProducts);
        return productsByManufacturer;
    }

    @Override
    public ProductsByManufacturer findProductsByManufacturerAndCategory(
            Manufacturer manufacturer, long categoryId, Language language) {
        Category thisCategory=categoryRepository.findOne(categoryId);
        List<ProductDescription> products = productDescriptionRepositoryDao.findByCategoryAndManufacturer(thisCategory,manufacturer,language);
        ProductsByManufacturer productsByManufacturer = new ProductsByManufacturer();
        productsByManufacturer.setProducts(products);
        List<Category> categories = new ArrayList<Category>();
        for(ProductDescription product:products){
            List<Category> categoriesOfOneProduct = product.getProduct().getCategories();
            for(Category categoryOfOneProduct:categoriesOfOneProduct){
                if(!categories.contains(categoryOfOneProduct)){
                    categories.add(categoryOfOneProduct);
                }
            }
        }
        List<CategoryDescription> categoriesOfProducts=new ArrayList<CategoryDescription>();
        for(Category category:categories){
            CategoryDescriptionId id = new CategoryDescriptionId();
            id.setCategory(category);
            id.setLanguage(language);
            CategoryDescription cd = categoryDescriptionRepository.findOne(id);
            categoriesOfProducts.add(cd);
        }
        productsByManufacturer.setCategoriesOfProducts(categoriesOfProducts);
        return productsByManufacturer;
    }

}
