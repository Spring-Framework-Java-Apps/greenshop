package org.woehlke.greenshop.checkout.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.woehlke.greenshop.catalog.entities.Product;


/**
mysql> desc orders_products;
+--------------------+---------------+------+-----+---------+----------------+
| Field              | Type          | Null | Key | Default | Extra          |
+--------------------+---------------+------+-----+---------+----------------+
| orders_products_id | int(11)       | NO   | PRI | NULL    | auto_increment |
| orders_id          | int(11)       | NO   | MUL | NULL    |                |
| products_id        | int(11)       | NO   | MUL | NULL    |                |
| products_model     | varchar(12)   | YES  |     | NULL    |                |
| products_name      | varchar(64)   | NO   |     | NULL    |                |
| products_price     | decimal(15,4) | NO   |     | NULL    |                |
| final_price        | decimal(15,4) | NO   |     | NULL    |                |
| products_tax       | decimal(7,4)  | NO   |     | NULL    |                |
| products_quantity  | int(2)        | NO   |     | NULL    |                |
+--------------------+---------------+------+-----+---------+----------------+
9 rows in set (0.60 sec)
 * 
 * @author tw
 *
 */
@Entity
@Table(name="orders_products")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orders_products_id",columnDefinition = "INT(11)")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Order order;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="products_id")
	private Product product;

	@OneToMany(mappedBy="orderProduct",fetch = FetchType.EAGER)
	private List<OrderProductAttribute> orderProductAttribute;
	
	@Column(name="products_model",columnDefinition = "varchar(12)")
	private String productsModel;
	
	@NotNull
	@Column(name="products_name",columnDefinition = "varchar(64)")
	private String productsName;
	
	@NotNull
	@Column(name="products_price",columnDefinition = "decimal(15,4)")
	private Double productsPrice;
	
	@NotNull
	@Column(name="final_price",columnDefinition = "decimal(15,4)")
	private Double finalPrice;
	
	@NotNull
	@Column(name="products_tax",columnDefinition = "decimal(7,4)")
	private Double productsTax;
	
	@NotNull
	@Column(name="products_quantity",columnDefinition = "int(2)")
	private int productsQuantity;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductsModel() {
		return productsModel;
	}

	public void setProductsModel(String productsModel) {
		this.productsModel = productsModel;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public Double getProductsPrice() {
		return productsPrice;
	}

	public void setProductsPrice(Double productsPrice) {
		this.productsPrice = productsPrice;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Double getProductsTax() {
		return productsTax;
	}

	public void setProductsTax(Double productsTax) {
		this.productsTax = productsTax;
	}

	public int getProductsQuantity() {
		return productsQuantity;
	}


	public List<OrderProductAttribute> getOrderProductAttribute() {
		return orderProductAttribute;
	}

	public void setOrderProductAttribute(List<OrderProductAttribute> orderProductAttribute) {
		this.orderProductAttribute = orderProductAttribute;
	}

	public void setProductsQuantity(int productsQuantity) {
		this.productsQuantity = productsQuantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((finalPrice == null) ? 0 : finalPrice.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((productsModel == null) ? 0 : productsModel.hashCode());
		result = prime * result
				+ ((productsName == null) ? 0 : productsName.hashCode());
		result = prime * result
				+ ((productsPrice == null) ? 0 : productsPrice.hashCode());
		result = prime * result + productsQuantity;
		result = prime * result
				+ ((productsTax == null) ? 0 : productsTax.hashCode());
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
		OrderProduct other = (OrderProduct) obj;
		if (finalPrice == null) {
			if (other.finalPrice != null)
				return false;
		} else if (!finalPrice.equals(other.finalPrice))
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productsModel == null) {
			if (other.productsModel != null)
				return false;
		} else if (!productsModel.equals(other.productsModel))
			return false;
		if (productsName == null) {
			if (other.productsName != null)
				return false;
		} else if (!productsName.equals(other.productsName))
			return false;
		if (productsPrice == null) {
			if (other.productsPrice != null)
				return false;
		} else if (!productsPrice.equals(other.productsPrice))
			return false;
		if (productsQuantity != other.productsQuantity)
			return false;
		if (productsTax == null) {
			if (other.productsTax != null)
				return false;
		} else if (!productsTax.equals(other.productsTax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", order=" + order + ", product="
				+ product + ", productsModel=" + productsModel
				+ ", productsName=" + productsName + ", productsPrice="
				+ productsPrice + ", finalPrice=" + finalPrice
				+ ", productsTax=" + productsTax + ", productsQuantity="
				+ productsQuantity + "]";
	}

	
	
	
}
