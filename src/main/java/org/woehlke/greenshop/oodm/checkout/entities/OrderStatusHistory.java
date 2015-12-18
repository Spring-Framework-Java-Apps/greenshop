package org.woehlke.greenshop.oodm.checkout.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 * 
mysql> desc orders_status_history;
+--------------------------+----------+------+-----+---------+----------------+
| Field                    | Type     | Null | Key | Default | Extra          |
+--------------------------+----------+------+-----+---------+----------------+
| orders_status_history_id | int(11)  | NO   | PRI | NULL    | auto_increment |
| orders_id                | int(11)  | NO   | MUL | NULL    |                |
| orders_status_id         | int(5)   | NO   |     | NULL    |                |
| date_added               | datetime | NO   |     | NULL    |                |
| customer_notified        | int(1)   | YES  |     | 0       |                |
| comments                 | text     | YES  |     | NULL    |                |
+--------------------------+----------+------+-----+---------+----------------+
mysql> select * from orders_status_history;
+--------------------------+-----------+------------------+---------------------+-------------------+----------+
| orders_status_history_id | orders_id | orders_status_id | date_added          | customer_notified | comments |
+--------------------------+-----------+------------------+---------------------+-------------------+----------+
|                        1 |         1 |                1 | 2013-01-28 12:13:14 |                 1 |          |
|                        2 |         2 |                1 | 2013-03-25 17:30:07 |                 1 |          |
|                        3 |         3 |                1 | 2013-03-25 18:48:19 |                 1 |          |
+--------------------------+-----------+------------------+---------------------+-------------------+----------+
 *
 * @author tw
 *
 */
@Entity
@Table(name="orders_status_history")
public class OrderStatusHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orders_status_history_id",columnDefinition = "INT(11)")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Order order;
	
	@NotNull
	@Column(name="orders_status_id",columnDefinition = "int(5)")
	private long ordersStatusId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_added",columnDefinition = "datetime")
	private Date dateAdded;
	
	@Column(name="customer_notified",columnDefinition = "int(1)")
	private int customerNotified;
	
	@Column(name="comments",columnDefinition = "text")
	private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getOrdersStatusId() {
		return ordersStatusId;
	}

	public void setOrdersStatusId(long ordersStatusId) {
		this.ordersStatusId = ordersStatusId;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getCustomerNotified() {
		return customerNotified;
	}

	public void setCustomerNotified(int customerNotified) {
		this.customerNotified = customerNotified;
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
		result = prime * result + customerNotified;
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ (int) (ordersStatusId ^ (ordersStatusId >>> 32));
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
		OrderStatusHistory other = (OrderStatusHistory) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (customerNotified != other.customerNotified)
			return false;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (ordersStatusId != other.ordersStatusId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderStatusHistory [id=" + id + ", order=" + order
				+ ", ordersStatusId=" + ordersStatusId + ", dateAdded="
				+ dateAdded + ", customerNotified=" + customerNotified
				+ ", comments=" + comments + "]";
	}
	
	
}
