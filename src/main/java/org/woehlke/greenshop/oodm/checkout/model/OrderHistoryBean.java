package org.woehlke.greenshop.oodm.checkout.model;

import java.util.Date;

public class OrderHistoryBean {
	private long orderId;
	private String status;
	private String shippedTo;
	private int quantityOfProducts;
	private Double cost;
	private Date date;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShippedTo() {
		return shippedTo;
	}
	public void setShippedTo(String shippedTo) {
		this.shippedTo = shippedTo;
	}
	public int getQuantityOfProducts() {
		return quantityOfProducts;
	}
	public void setQuantityOfProducts(int quantityOfProducts) {
		this.quantityOfProducts = quantityOfProducts;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + quantityOfProducts;
		result = prime * result
				+ ((shippedTo == null) ? 0 : shippedTo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderHistoryBean other = (OrderHistoryBean) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderId != other.orderId)
			return false;
		if (quantityOfProducts != other.quantityOfProducts)
			return false;
		if (shippedTo == null) {
			if (other.shippedTo != null)
				return false;
		} else if (!shippedTo.equals(other.shippedTo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
