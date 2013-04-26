package org.woehlke.greenshop.checkout;

import java.util.List;

import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.model.OrderHistoryBean;
import org.woehlke.greenshop.customer.entities.Customer;

public interface OrderService {

	List<Order> findOrdersForCustomer(Customer customer);

	Order findOrderById(long orderId);

	List<OrderHistoryBean> getOrderHistoryForCustomer(Customer customer);

}