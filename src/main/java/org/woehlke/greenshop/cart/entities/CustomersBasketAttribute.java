package org.woehlke.greenshop.cart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.woehlke.greenshop.customer.entities.Customer;

/**
 * mysql> select * from customers_basket_attributes;
+--------------------------------+--------------+-------------+---------------------+---------------------------+
| customers_basket_attributes_id | customers_id | products_id | products_options_id | products_options_value_id |
+--------------------------------+--------------+-------------+---------------------+---------------------------+
|                              4 |            9 | 26{3}9      |                   3 |                         9 |
+--------------------------------+--------------+-------------+---------------------+---------------------------+
1 row in set (0.00 sec)

mysql> desc customers_basket_attributes;
+--------------------------------+----------+------+-----+---------+----------------+
| Field                          | Type     | Null | Key | Default | Extra          |
+--------------------------------+----------+------+-----+---------+----------------+
| customers_basket_attributes_id | int(11)  | NO   | PRI | NULL    | auto_increment |
| customers_id                   | int(11)  | NO   | MUL | NULL    |                |
| products_id                    | tinytext | NO   |     | NULL    |                |
| products_options_id            | int(11)  | NO   |     | NULL    |                |
| products_options_value_id      | int(11)  | NO   |     | NULL    |                |
+--------------------------------+----------+------+-----+---------+----------------+
5 rows in set (0.01 sec)
 * 
 * @author tw
 *
 */
@Entity
@Table(name="customers_basket_attributes")
public class CustomersBasketAttribute {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customers_basket_attributes_id",columnDefinition = "INT(11)")
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name="customers_id")
	private Customer customer;

	@NotNull
	@Column(name="products_id",columnDefinition = "tinytext")
	private String productId;

	@NotNull
	@Column(name="products_options_id",columnDefinition = "INT(11)")
	private Long productOptionId;

	@NotNull
	@Column(name="products_options_value_id",columnDefinition = "INT(11)")
	private Long productOptionValueId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getProductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(Long productOptionId) {
		this.productOptionId = productOptionId;
	}

	public Long getProductOptionValueId() {
		return productOptionValueId;
	}

	public void setProductOptionValueId(Long productOptionValueId) {
		this.productOptionValueId = productOptionValueId;
	}

	@Override
	public String toString() {
		return "CustomersBasketAttribute [id=" + id + ", customer=" + customer
				+ ", productId=" + productId + ", productOptionId="
				+ productOptionId + ", productOptionValueId="
				+ productOptionValueId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productOptionId == null) ? 0 : productOptionId.hashCode());
		result = prime
				* result
				+ ((productOptionValueId == null) ? 0 : productOptionValueId
						.hashCode());
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
		CustomersBasketAttribute other = (CustomersBasketAttribute) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productOptionId == null) {
			if (other.productOptionId != null)
				return false;
		} else if (!productOptionId.equals(other.productOptionId))
			return false;
		if (productOptionValueId == null) {
			if (other.productOptionValueId != null)
				return false;
		} else if (!productOptionValueId.equals(other.productOptionValueId))
			return false;
		return true;
	}

	
}
