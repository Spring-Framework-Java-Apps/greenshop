package org.woehlke.greenshop.checkout;

import java.util.List;

import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.model.OrderHistoryBean;
import org.woehlke.greenshop.checkout.model.OrderHistoryDetailsBean;
import org.woehlke.greenshop.customer.entities.Customer;

public interface OrderService {

	List<Order> findOrdersForCustomer(Customer customer);

	OrderHistoryDetailsBean findOrderDetailsById(long orderId,Language language);

	List<OrderHistoryBean> getOrderHistoryForCustomer(Customer customer,Language language);

}
