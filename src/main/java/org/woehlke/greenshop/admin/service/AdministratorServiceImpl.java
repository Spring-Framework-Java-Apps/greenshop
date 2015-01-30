package org.woehlke.greenshop.admin.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.Administrator;
import org.woehlke.greenshop.admin.model.AdministratorBean;
import org.woehlke.greenshop.admin.repository.AdministratorRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
@Named("administratorService")
@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class AdministratorServiceImpl implements AdministratorService {

    @Inject
    private AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> findAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator findAdministratorById(long administratorId) {
        return administratorRepository.findOne(administratorId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUserName(username);
        if(administrator == null) throw new UsernameNotFoundException(username);
        return new AdministratorBean(administrator);
    }
}
