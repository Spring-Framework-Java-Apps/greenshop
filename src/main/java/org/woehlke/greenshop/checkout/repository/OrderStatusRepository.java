package org.woehlke.greenshop.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.checkout.entities.OrderStatus;
import org.woehlke.greenshop.checkout.entities.OrderStatusId;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,OrderStatusId> {

    List<OrderStatus> findByLanguage(Language language);
}
