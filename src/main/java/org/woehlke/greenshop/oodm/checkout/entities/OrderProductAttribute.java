package org.woehlke.greenshop.oodm.checkout.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 
mysql> desc orders_products_attributes;
+-------------------------------+---------------+------+-----+---------+----------------+
| Field                         | Type          | Null | Key | Default | Extra          |
+-------------------------------+---------------+------+-----+---------+----------------+
| orders_products_attributes_id | int(11)       | NO   | PRI | NULL    | auto_increment |
| orders_id                     | int(11)       | NO   | MUL | NULL    |                |
| orders_products_id            | int(11)       | NO   |     | NULL    |                |
| products_options              | varchar(32)   | NO   |     | NULL    |                |
| products_options_values       | varchar(32)   | NO   |     | NULL    |                |
| options_values_price          | decimal(15,4) | NO   |     | NULL    |                |
| price_prefix                  | char(1)       | NO   |     | NULL    |                |
+-------------------------------+---------------+------+-----+---------+----------------+
7 rows in set (0.02 sec)
 *
 * @author tw
 *
 */
@Entity
@Table(name="orders_products_attributes")
public class OrderProductAttribute {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orders_products_attributes_id",columnDefinition = "INT(11)")
	private Long id;
	
	@NotNull
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="orders_id")
	private Order order;
	
	@NotNull
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="orders_products_id")
	private OrderProduct orderProduct;
	
	@NotNull
	@Column(name="products_options", columnDefinition = "varchar(32)")
	private String productOption;
	
	@NotNull
	@Column(name="products_options_values",columnDefinition = "varchar(32)")
	private String productOptionValue;
	
	@NotNull
	@Column(name="options_values_price",columnDefinition = "decimal(15,4)")
	private Double optionValuePrice;
	
	@NotNull
	@Column(name="price_prefix",columnDefinition = "char(1)")
	private String pricePrefix;

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

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	public String getProductOption() {
		return productOption;
	}

	public void setProductOption(String productOption) {
		this.productOption = productOption;
	}

	public String getProductOptionValue() {
		return productOptionValue;
	}

	public void setProductOptionValue(String productOptionValue) {
		this.productOptionValue = productOptionValue;
	}

	public Double getOptionValuePrice() {
		return optionValuePrice;
	}

	public void setOptionValuePrice(Double optionValuePrice) {
		this.optionValuePrice = optionValuePrice;
	}

	public String getPricePrefix() {
		return pricePrefix;
	}

	public void setPricePrefix(String pricePrefix) {
		this.pricePrefix = pricePrefix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((optionValuePrice == null) ? 0 : optionValuePrice.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((orderProduct == null) ? 0 : orderProduct.hashCode());
		result = prime * result
				+ ((pricePrefix == null) ? 0 : pricePrefix.hashCode());
		result = prime * result
				+ ((productOption == null) ? 0 : productOption.hashCode());
		result = prime
				* result
				+ ((productOptionValue == null) ? 0 : productOptionValue
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
		OrderProductAttribute other = (OrderProductAttribute) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optionValuePrice == null) {
			if (other.optionValuePrice != null)
				return false;
		} else if (!optionValuePrice.equals(other.optionValuePrice))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (orderProduct == null) {
			if (other.orderProduct != null)
				return false;
		} else if (!orderProduct.equals(other.orderProduct))
			return false;
		if (pricePrefix == null) {
			if (other.pricePrefix != null)
				return false;
		} else if (!pricePrefix.equals(other.pricePrefix))
			return false;
		if (productOption == null) {
			if (other.productOption != null)
				return false;
		} else if (!productOption.equals(other.productOption))
			return false;
		if (productOptionValue == null) {
			if (other.productOptionValue != null)
				return false;
		} else if (!productOptionValue.equals(other.productOptionValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderProductAttribute [id=" + id + ", order=" + order
				+ ", orderProduct=" + orderProduct + ", productOption="
				+ productOption + ", productOptionsValue="
				+ productOptionValue + ", optionValuePrice="
				+ optionValuePrice + ", pricePrefix=" + pricePrefix + "]";
	}
	
}
