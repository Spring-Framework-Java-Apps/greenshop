package org.woehlke.greenshop.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Null;


@Entity
@Table(name="products_description")
@IdClass(ProductDescriptionId.class)
public class ProductDescription {
	
	@Id
	@ManyToOne
	@JoinColumn(name="products_id")
	private Product product;
	
	@Id
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;
	
	@Column(name="products_viewed")
	private int viewed;
	
	@Null
	@Column(name="products_description",columnDefinition="text")
	private String description;

	@Null
	@Max(255)
	@Column(name="products_url",columnDefinition="varchar(255)")
	private String products_url;
	
	@Column(name="products_name")
	private String name;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getViewed() {
		return viewed;
	}

	public void setViewed(int viewed) {
		this.viewed = viewed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProducts_url() {
		return products_url;
	}

	public void setProducts_url(String products_url) {
		this.products_url = products_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductDescription [product=" + product + ", language="
				+ language + ", viewed=" + viewed + ", description="
				+ description + ", products_url=" + products_url + ", name="
				+ name + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((products_url == null) ? 0 : products_url.hashCode());
		result = prime * result + viewed;
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
		ProductDescription other = (ProductDescription) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (products_url == null) {
			if (other.products_url != null)
				return false;
		} else if (!products_url.equals(other.products_url))
			return false;
		if (viewed != other.viewed)
			return false;
		return true;
	}

}
