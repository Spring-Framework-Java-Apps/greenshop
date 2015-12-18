package org.woehlke.greenshop.oodm.checkout.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
mysql> select * from orders_total;
+-----------------+-----------+-----------------------+-------------------------+---------+-------------+------------+
| orders_total_id | orders_id | title                 | text                    | value   | class       | sort_order |
+-----------------+-----------+-----------------------+-------------------------+---------+-------------+------------+
|               1 |         1 | Sub-Total:            | $29.99                  | 29.9900 | ot_subtotal |          1 |
|               2 |         1 | Flat Rate (Best Way): | $5.00                   |  5.0000 | ot_shipping |          2 |
|               3 |         1 | Total:                | <strong>$34.99</strong> | 34.9900 | ot_total    |          4 |
|               4 |         2 | Sub-Total:            | $71.98                  | 71.9800 | ot_subtotal |          1 |
|               5 |         2 | Flat Rate (Best Way): | $5.00                   |  5.0000 | ot_shipping |          2 |
|               6 |         2 | Total:                | <strong>$76.98</strong> | 76.9800 | ot_total    |          4 |
|               7 |         3 | Sub-Total:            | $69.98                  | 69.9800 | ot_subtotal |          1 |
|               8 |         3 | Flat Rate (Best Way): | $5.00                   |  5.0000 | ot_shipping |          2 |
|               9 |         3 | Total:                | <strong>$74.98</strong> | 74.9800 | ot_total    |          4 |
+-----------------+-----------+-----------------------+-------------------------+---------+-------------+------------+
9 rows in set (0.04 sec)

mysql> desc orders_total;
+-----------------+------------------+------+-----+---------+----------------+
| Field           | Type             | Null | Key | Default | Extra          |
+-----------------+------------------+------+-----+---------+----------------+
| orders_total_id | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| orders_id       | int(11)          | NO   | MUL | NULL    |                |
| title           | varchar(255)     | NO   |     | NULL    |                |
| text            | varchar(255)     | NO   |     | NULL    |                |
| value           | decimal(15,4)    | NO   |     | NULL    |                |
| class           | varchar(32)      | NO   |     | NULL    |                |
| sort_order      | int(11)          | NO   |     | NULL    |                |
+-----------------+------------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)
 * @author tw
 *
 */
@Entity
@Table(name="orders_total")
public class OrderTotal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orders_total_id",columnDefinition = "int(10) unsigned")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Order order;
	
	@Column(name="title",columnDefinition = "varchar(255)")
	private String title;
	
	@Column(name="text",columnDefinition = "varchar(255)")
	private String text;
	
	@Column(name="value",columnDefinition = "decimal(15,4)")
	private Double value;

	@Column(name="class",columnDefinition = "varchar(32)")
	private String totalClass;

	@Column(name="sort_order",columnDefinition = "int(11)")
	private long sortOrder;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getTotalClass() {
		return totalClass;
	}

	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}

	public long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(long sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + (int) (sortOrder ^ (sortOrder >>> 32));
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((totalClass == null) ? 0 : totalClass.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		OrderTotal other = (OrderTotal) obj;
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
		if (sortOrder != other.sortOrder)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (totalClass == null) {
			if (other.totalClass != null)
				return false;
		} else if (!totalClass.equals(other.totalClass))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderTotal [id=" + id + ", order=" + order + ", title=" + title
				+ ", text=" + text + ", value=" + value + ", totalClass="
				+ totalClass + ", sortOrder=" + sortOrder + "]";
	}
	
	
}
