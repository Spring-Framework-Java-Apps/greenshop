package org.woehlke.greenshop.oodm.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.checkout.entities.OrderProductAttribute;

public interface OrderProductAttributeRepository extends JpaRepository<OrderProductAttribute, Long> {

}
