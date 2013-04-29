package org.woehlke.greenshop.checkout.model;

import java.util.Date;

public class OrderStatusHistoryBean {
	
	private Date dateAdded;
	private String status;
	private String comments;
	
	public OrderStatusHistoryBean(Date dateAdded, String status, String comments) {
		super();
		this.dateAdded = dateAdded;
		this.status = status;
		this.comments = comments;
	}

	public OrderStatusHistoryBean() {
		super();
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
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
		OrderStatusHistoryBean other = (OrderStatusHistoryBean) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderStatusHistoryBean [dateAdded=" + dateAdded + ", status="
				+ status + ", comments=" + comments + "]";
	}
	
	
}
