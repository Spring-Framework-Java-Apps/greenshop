package org.woehlke.greenshop.admin;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.Administrator;
import org.woehlke.greenshop.admin.entities.TaxClass;
import org.woehlke.greenshop.admin.entities.TaxRate;
import org.woehlke.greenshop.admin.entities.TaxZone;
import org.woehlke.greenshop.admin.model.AdministratorBean;
import org.woehlke.greenshop.admin.repository.AdministratorRepository;
import org.woehlke.greenshop.admin.repository.TaxClassRepository;
import org.woehlke.greenshop.admin.repository.TaxRateRepository;
import org.woehlke.greenshop.admin.repository.TaxZoneRepository;
import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.ReviewProduct;
import org.woehlke.greenshop.catalog.repositories.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 31.12.14.
 */
@Named("adminService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {

    @Inject
    private AdministratorRepository administratorRepository;

    @Inject
    private ManufacturerRepository manufacturerRepository;

    @Inject
    private ProductRepository productRepository;

    @Inject
    private SpecialRepository specialRepository;

    @Inject
    private ReviewRepository reviewRepository;

    @Inject
    private ProductDescriptionRepository productDescriptionRepository;

    @Inject
    private ReviewDescriptionRepository reviewDescriptionRepository;

    @Inject
    private TaxClassRepository taxClassRepository;

    @Inject
    private TaxRateRepository taxRateRepository;

    @Inject
    private TaxZoneRepository taxZoneRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUserName(username);
        if(administrator == null) throw new UsernameNotFoundException(username);
        return new AdministratorBean(administrator);
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAllOrderByName();
    }

    @Override
    public int countProductsOfThisManufacturer(Manufacturer thisManufacturer) {
        List<Product> list = productRepository.findByManufacturer(thisManufacturer);
        return list.size();
    }

    @Override
    public Manufacturer getManufacturerById(long manufacturerId) {
        return manufacturerRepository.findOne(manufacturerId);
    }

    @Override
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public void updateSpecial(Special special) {
        specialRepository.save(special);
    }

    @Override
    public ReviewProduct getReviewById(long reviewId, Language language) {
        Review review = reviewRepository.findOne(reviewId);
        ReviewDescriptionId reviewDescriptionId = new ReviewDescriptionId();
        reviewDescriptionId.setLanguage(language);
        reviewDescriptionId.setReview(review);
        ReviewDescription reviewDescription = reviewDescriptionRepository.findOne(reviewDescriptionId);
        ProductDescriptionId id = new ProductDescriptionId();
        id.setLanguage(language);
        id.setProduct(review.getProduct());
        ProductDescription productDescription=productDescriptionRepository.findOne(id);
        ReviewProduct reviewProduct = new ReviewProduct();
        reviewProduct.setProduct(productDescription);
        reviewProduct.setReview(reviewDescription);
        return reviewProduct;
    }

    @Override
    public List<Administrator> findAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator findAdministratorById(long administratorId) {
        return administratorRepository.findOne(administratorId);
    }

    @Override
    public List<TaxClass> findAllTaxClasses() {
        return taxClassRepository.findAll();
    }

    @Override
    public TaxClass findTaxClassById(long taxClassId) {
        return taxClassRepository.findOne(taxClassId);
    }

    @Override
    public List<TaxRate> findAllTaxRates() {
        return taxRateRepository.findAll();
    }

    @Override
    public TaxRate findTaxRateById(long taxRateId) {
        return taxRateRepository.findOne(taxRateId);
    }

    @Override
    public List<TaxZone> findAllTaxZones() {
        return taxZoneRepository.findAll();
    }

    @Override
    public TaxZone findTaxZoneById(long taxZoneId) {
        return taxZoneRepository.findOne(taxZoneId);
    }
}
