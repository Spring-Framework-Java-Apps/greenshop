package org.woehlke.greenshop.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.checkout.entities.OrderProductAttribute;

public interface OrderProductAttributeRepository extends JpaRepository<OrderProductAttribute, Long> {

}
