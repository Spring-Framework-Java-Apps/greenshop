package org.woehlke.greenshop.oodm.checkout;

import java.util.List;
import java.util.Optional;

import org.woehlke.greenshop.oodm.admin.model.OrderAdminBean;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.checkout.entities.Order;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatus;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatusId;
import org.woehlke.greenshop.oodm.checkout.model.OrderHistoryBean;
import org.woehlke.greenshop.oodm.checkout.model.OrderHistoryDetailsBean;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

public interface OrderService {

	List<Order> findOrdersForCustomer(Customer customer);

	OrderHistoryDetailsBean findOrderDetailsById(long orderId,Language language);

	List<OrderHistoryBean> getOrderHistoryForCustomer(Customer customer,Language language);

    List<OrderStatus> findAllOrderStatuses(Language language);

    Optional<OrderStatus> findOrderStatusById(OrderStatusId ordersStatusId);

    List<OrderAdminBean> getAllOrders(Language language);

    OrderAdminBean findOrderById(long orderId, Language language);
}
