package org.woehlke.greenshop.admin.model;

import org.woehlke.greenshop.checkout.entities.OrderStatus;

import java.util.Date;

/**
 * Created by tw on 08.01.15.
 */
public class OrderAdminBean {

    private long orderId;

    private String customerName;

    private Double orderTotal;

    private Date orderPlaced;

    private OrderStatus orderStatus;

    private String paymentMethod;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(Date orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderAdminBean)) return false;

        OrderAdminBean that = (OrderAdminBean) o;

        if (orderId != that.orderId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (orderId ^ (orderId >>> 32));
    }

    @Override
    public String toString() {
        return "OrderAdminBean{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", orderTotal=" + orderTotal +
                ", orderPlaced=" + orderPlaced +
                ", orderStatus=" + orderStatus +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
