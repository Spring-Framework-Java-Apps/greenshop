package org.woehlke.greenshop.oodm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.customer.entities.CustomerInfo;

/**
 * Created by tw on 22.12.14.
 */
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Long> {
}
