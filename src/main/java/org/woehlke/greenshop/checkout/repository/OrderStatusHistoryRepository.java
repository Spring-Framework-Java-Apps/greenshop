package org.woehlke.greenshop.checkout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.entities.OrderStatusHistory;
import org.woehlke.greenshop.checkout.model.OrderStatusHistoryBean;

public interface OrderStatusHistoryRepository extends JpaRepository<OrderStatusHistory, Long> {

	@Query("select new org.woehlke.greenshop.checkout.model.OrderStatusHistoryBean(osh.dateAdded,os.ordersStatusName,osh.comments) from OrderStatusHistory osh, OrderStatus os where osh.ordersStatusId=os.id and osh.order=:order and os.language=:language")
	List<OrderStatusHistoryBean> findByOrder(@Param("order") Order order, @Param("language") Language language); 
}
