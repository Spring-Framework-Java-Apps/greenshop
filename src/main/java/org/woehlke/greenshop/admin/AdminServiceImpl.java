package org.woehlke.greenshop.admin;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.Administrator;
import org.woehlke.greenshop.admin.model.AdministratorBean;
import org.woehlke.greenshop.admin.repository.AdministratorRepository;
import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.repositories.ManufacturerRepository;
import org.woehlke.greenshop.catalog.repositories.ProductRepository;
import org.woehlke.greenshop.catalog.repositories.SpecialRepository;

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
}
