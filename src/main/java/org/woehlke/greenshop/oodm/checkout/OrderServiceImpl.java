package org.woehlke.greenshop.oodm.checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.admin.model.OrderAdminBean;
import org.woehlke.greenshop.oodm.catalog.CatalogService;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.checkout.entities.Order;
import org.woehlke.greenshop.oodm.checkout.entities.OrderProduct;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatus;
import org.woehlke.greenshop.oodm.checkout.entities.OrderStatusId;
import org.woehlke.greenshop.oodm.checkout.entities.OrderTotal;
import org.woehlke.greenshop.oodm.checkout.model.OrderHistoryBean;
import org.woehlke.greenshop.oodm.checkout.model.OrderHistoryDetailsBean;
import org.woehlke.greenshop.oodm.checkout.model.OrderStatusHistoryBean;
import org.woehlke.greenshop.oodm.checkout.repository.OrderProductRepository;
import org.woehlke.greenshop.oodm.checkout.repository.OrderRepository;
import org.woehlke.greenshop.oodm.checkout.repository.OrderStatusHistoryRepository;
import org.woehlke.greenshop.oodm.checkout.repository.OrderStatusRepository;
import org.woehlke.greenshop.oodm.checkout.repository.OrderTotalRepository;
import org.woehlke.greenshop.oodm.customer.entities.Customer;


@Named("orderService")
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Inject
	private OrderProductRepository orderProductRepository;

	@Inject
	private OrderStatusHistoryRepository orderStatusHistoryRepository;
	
	@Inject
	protected CatalogService catalogService;

    @Inject
    private OrderStatusRepository orderStatusRepository;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private OrderTotalRepository orderTotalRepository;


    @Override
    public List<OrderStatus> findAllOrderStatuses(Language language) {
        return orderStatusRepository.findByLanguage(language);
    }

    @Override
    public Optional<OrderStatus> findOrderStatusById(OrderStatusId ordersStatusId) {
        return orderStatusRepository.findById(ordersStatusId);
    }

    @Override
    public List<OrderAdminBean> getAllOrders(Language language) {
        List<OrderAdminBean> orders = new ArrayList<>();
        List<Order> myOrders = orderRepository.findAll();
        for(Order myOrder:myOrders){
            OrderAdminBean bean = new OrderAdminBean();
            bean.setOrderId(myOrder.getId());
            bean.setCustomerName(myOrder.getCustomersName());
            bean.setOrderPlaced(myOrder.getDatePurchased());
            OrderTotal orderTotal = orderTotalRepository.findByOrderAndTotalClass(myOrder,"ot_total");
            bean.setOrderTotal(orderTotal.getValue());
            OrderStatusId orderStatusId = new OrderStatusId();
            orderStatusId.setLanguage(language);
            orderStatusId.setId(myOrder.getOrdersStatus());
			Optional<OrderStatus> orderStatus=orderStatusRepository.findById(orderStatusId);
            bean.setOrderStatus(orderStatus.get());
            bean.setPaymentMethod(myOrder.getPaymentMethod());
            orders.add(bean);
        }
        return orders;
    }

    @Override
    public OrderAdminBean findOrderById(long orderId, Language language) {
		Optional<Order> myOrderOptional = orderRepository.findById(orderId);
		Order myOrder = myOrderOptional.get();
        OrderAdminBean bean = new OrderAdminBean();
        bean.setOrderId(myOrder.getId());
        bean.setCustomerName(myOrder.getCustomersName());
        bean.setOrderPlaced(myOrder.getDatePurchased());
        OrderTotal orderTotal = orderTotalRepository.findByOrderAndTotalClass(myOrder,"ot_total");
        bean.setOrderTotal(orderTotal.getValue());
        OrderStatusId orderStatusId = new OrderStatusId();
        orderStatusId.setLanguage(language);
        orderStatusId.setId(myOrder.getOrdersStatus());
		Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(orderStatusId);
        OrderStatus orderStatus=orderStatusOptional.get();
        bean.setOrderStatus(orderStatus);
        bean.setPaymentMethod(myOrder.getPaymentMethod());
        return bean;
    }

	@Override
	public List<Order> findOrdersForCustomer(Customer customer) {
		return orderRepository.findByCustomer(customer);
	}

	@Override
	public OrderHistoryDetailsBean findOrderDetailsById(long orderId, Language language) {
		//Language language = catalogService.findLanguageByCode("en");
		OrderHistoryDetailsBean o = new OrderHistoryDetailsBean();
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		Order order = orderOptional.get();
		o.setOrder(order);
		OrderStatusId id = new OrderStatusId();
		id.setLanguage(language);
		id.setId(order.getOrdersStatus());
		Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(id);
		OrderStatus orderStatus = orderStatusOptional.get();
		o.setOrderStatus(orderStatus);
		List<OrderProduct> orderProducts = orderProductRepository.findByOrder(order);
		o.setOrderProducts(orderProducts);
		List<OrderStatusHistoryBean> orderStatusHistoryBeans = orderStatusHistoryRepository.findByOrder(order, language);
		List<OrderTotal> orderTotal = orderTotalRepository.findByOrder(order);
		o.setOrderTotal(orderTotal);
		o.setOrderStatusHistoryBeans(orderStatusHistoryBeans);
		return o;
	}

	@Override
	public List<OrderHistoryBean> getOrderHistoryForCustomer(Customer customer,Language language) {
		List<OrderHistoryBean> orderHistory = new ArrayList<OrderHistoryBean>();
		//Language language = catalogService.findLanguageByCode("en");
		List<Order> orders = orderRepository.findByCustomer(customer);
		for(Order order:orders){
			OrderTotal orderTotal = orderTotalRepository.findByOrderAndTotalClass(order,"ot_total");
			List<OrderProduct> orderProducts  = orderProductRepository.findByOrder(order);
			OrderStatusId orderStatusId = new OrderStatusId();
			orderStatusId.setLanguage(language);
			orderStatusId.setId(order.getOrdersStatus());
			Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(orderStatusId);
			OrderStatus orderStatus = orderStatusOptional.get();
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
