package org.woehlke.greenshop.oodm.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.beans.Transient;


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

	@Column(name="products_description",columnDefinition="text")
	private String description;

	@Column(name="products_url",columnDefinition="varchar(255)")
	private String productsUrl;
	
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

	public String getProductsUrl() {
		return productsUrl;
	}

	public void setProductsUrl(String products_url) {
		this.productsUrl = products_url;
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
				+ description + ", products_url=" + productsUrl + ", name="
				+ name + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductDescription)) return false;

		ProductDescription that = (ProductDescription) o;

		if (language != null ? !language.equals(that.language) : that.language != null) return false;
		if (product != null ? !product.equals(that.product) : that.product != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = product != null ? product.hashCode() : 0;
		result = 31 * result + (language != null ? language.hashCode() : 0);
		return result;
	}

	@Transient
	public void incViewed() {
		viewed++;
	}
}
