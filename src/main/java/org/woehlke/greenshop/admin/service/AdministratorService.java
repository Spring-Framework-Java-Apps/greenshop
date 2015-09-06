package org.woehlke.greenshop.admin.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.woehlke.greenshop.admin.entities.Administrator;

import java.util.List;

/**
 * Created by tw on 30.01.15.
 */
public interface AdministratorService extends UserDetailsService {

    List<Administrator> findAllAdministrators();

    Administrator findAdministratorById(long administratorId);

    void update(Administrator thisAdministrator);
}
