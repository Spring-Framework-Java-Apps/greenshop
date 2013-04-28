package org.woehlke.greenshop.checkout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.catalog.CatalogService;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.entities.OrderProduct;
import org.woehlke.greenshop.checkout.entities.OrderStatus;
import org.woehlke.greenshop.checkout.entities.OrderStatusId;
import org.woehlke.greenshop.checkout.entities.OrderTotal;
import org.woehlke.greenshop.checkout.model.OrderHistoryBean;
import org.woehlke.greenshop.checkout.model.OrderHistoryDetailsBean;
import org.woehlke.greenshop.checkout.repository.OrderProductAttributeRepository;
import org.woehlke.greenshop.checkout.repository.OrderProductRepository;
import org.woehlke.greenshop.checkout.repository.OrderRepository;
import org.woehlke.greenshop.checkout.repository.OrderStatusRepository;
import org.woehlke.greenshop.checkout.repository.OrderTotalRepository;
import org.woehlke.greenshop.customer.entities.Customer;


@Named("orderService")
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Inject
	private OrderRepository orderRepository;
	
	@Inject
	private OrderProductRepository orderProductRepository;
	
	@Inject
	private OrderProductAttributeRepository orderProductAttributeRepository;
	
	@Inject
	private OrderTotalRepository orderTotalRepository;
	
	@Inject
	private OrderStatusRepository orderStatusRepository;
	
	@Inject
	protected CatalogService catalogService;

	@Override
	public List<Order> findOrdersForCustomer(Customer customer) {
		return orderRepository.findByCustomer(customer);
	}

	@Override
	public OrderHistoryDetailsBean findOrderDetailsById(long orderId) {
		Language language = catalogService.findLanguageByCode("en");
		OrderHistoryDetailsBean o = new OrderHistoryDetailsBean();
		Order order = orderRepository.findOne(orderId);
		o.setOrder(order);
		OrderStatusId id = new OrderStatusId();
		id.setLanguage(language);
		id.setId(order.getOrdersStatus());
		OrderStatus orderStatus = orderStatusRepository.findOne(id);
		o.setOrderStatus(orderStatus);
		List<OrderProduct> orderProducts = orderProductRepository.findByOrder(order);
		o.setOrderProducts(orderProducts);
		return o;
	}

	@Override
	public List<OrderHistoryBean> getOrderHistoryForCustomer(Customer customer) {
		List<OrderHistoryBean> orderHistory = new ArrayList<OrderHistoryBean>();
		Language language = catalogService.findLanguageByCode("en");
		List<Order> orders = orderRepository.findByCustomer(customer);
		for(Order order:orders){
			OrderTotal orderTotal = orderTotalRepository.findByOrderAndTotalClass(order,"ot_total");
			List<OrderProduct> orderProducts  = orderProductRepository.findByOrder(order);
			OrderStatusId orderStatusId = new OrderStatusId();
			orderStatusId.setLanguage(language);
			orderStatusId.setId(order.getOrdersStatus());
			OrderStatus orderStatus=orderStatusRepository.findOne(orderStatusId);
			int quantityOfProducts = 0;
			for(OrderProduct orderProduct:orderProducts){
				quantityOfProducts += orderProduct.getProductsQuantity();
			}
			OrderHistoryBean orderHistoryBean = new OrderHistoryBean();
			orderHistoryBean.setOrderId(order.getId());
			orderHistoryBean.setQuantityOfProducts(quantityOfProducts);
			orderHistoryBean.setCost(orderTotal.getValue());
			orderHistoryBean.setStatus(orderStatus.getOrdersStatusName());
			orderHistoryBean.setShippedTo(order.getDeliveryName());
			orderHistoryBean.setDate(order.getDatePurchased());
			orderHistory.add(orderHistoryBean);
		}
		return orderHistory;
	}
	
	
}
