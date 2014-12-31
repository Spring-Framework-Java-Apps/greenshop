package org.woehlke.greenshop.admin;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.admin.entities.Administrator;
import org.woehlke.greenshop.admin.model.AdministratorBean;
import org.woehlke.greenshop.admin.repository.AdministratorRepository;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by tw on 31.12.14.
 */
@Named("adminService")
@Transactional(readOnly=true,propagation= Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {

    @Inject
    private AdministratorRepository administratorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUserName(username);
        if(administrator == null) throw new UsernameNotFoundException(username);
        return new AdministratorBean(administrator);
    }
}
