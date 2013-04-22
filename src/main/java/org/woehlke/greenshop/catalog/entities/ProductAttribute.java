package org.woehlke.greenshop.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products_attributes")
public class ProductAttribute {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="products_attributes_id",columnDefinition = "INT(11)")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="products_id")
	private Product product;
	
	@NotNull
	@Column(name="options_id",columnDefinition = "INT(11)")
	private long optionId;

	@NotNull
	@Column(name="options_values_id",columnDefinition = "INT(11)")
	private long valueId;
	
	@Column(name="options_values_price",columnDefinition = "decimal(15,4)",precision=15,scale=4)
	private Double price;
	
	@Column(name="price_prefix",columnDefinition = "CHAR(1)")
	private String pricePrefix;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getValueId() {
		return valueId;
	}

	public void setValueId(long valueId) {
		this.valueId = valueId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPricePrefix() {
		return pricePrefix;
	}

	public void setPricePrefix(String pricePrefix) {
		this.pricePrefix = pricePrefix;
	}

	@Override
	public String toString() {
		return "ProductAttribute [id=" + id + ", product=" + product
				+ ", optionId=" + optionId + ", valueId=" + valueId
				+ ", price=" + price + ", pricePrefix=" + pricePrefix + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (optionId ^ (optionId >>> 32));
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((pricePrefix == null) ? 0 : pricePrefix.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + (int) (valueId ^ (valueId >>> 32));
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
		ProductAttribute other = (ProductAttribute) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optionId != other.optionId)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (pricePrefix == null) {
			if (other.pricePrefix != null)
				return false;
		} else if (!pricePrefix.equals(other.pricePrefix))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (valueId != other.valueId)
			return false;
		return true;
	}
	
}
