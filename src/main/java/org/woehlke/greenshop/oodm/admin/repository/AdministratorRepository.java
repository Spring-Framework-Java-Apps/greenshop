package org.woehlke.greenshop.oodm.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.admin.entities.Administrator;

/**
 * Created by tw on 31.12.14.
 */
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByUserName(String username);
}
