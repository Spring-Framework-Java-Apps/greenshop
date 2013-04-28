package org.woehlke.greenshop.checkout.model;

import java.util.List;

import org.woehlke.greenshop.checkout.entities.Order;
import org.woehlke.greenshop.checkout.entities.OrderProduct;
import org.woehlke.greenshop.checkout.entities.OrderStatus;
import org.woehlke.greenshop.checkout.entities.OrderTotal;

public class OrderHistoryDetailsBean {
	private Order order;
	private OrderStatus orderStatus;
	private List<OrderTotal> orderTotal;
	private List<OrderProduct> orderProducts;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderTotal> getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(List<OrderTotal> orderTotal) {
		this.orderTotal = orderTotal;
	}
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
}
