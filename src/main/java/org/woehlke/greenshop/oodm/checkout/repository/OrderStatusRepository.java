package org.woehlke.greenshop.oodm.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatus;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatusId;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,OrderStatusId> {

    List<OrderStatus> findByLanguage(Language language);
}
