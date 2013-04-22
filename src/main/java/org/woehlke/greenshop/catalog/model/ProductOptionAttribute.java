package org.woehlke.greenshop.catalog.model;

import org.woehlke.greenshop.catalog.entities.ProductAttribute;
import org.woehlke.greenshop.catalog.entities.ProductOption;
import org.woehlke.greenshop.catalog.entities.ProductOptionValue;

public class ProductOptionAttribute {
	
	private ProductAttribute productAttribute;
	private ProductOption productOption;
	private ProductOptionValue productOptionValue;
	private String optionValue;
	public ProductAttribute getProductAttribute() {
		return productAttribute;
	}
	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
	}
	public ProductOption getProductOption() {
		return productOption;
	}
	public void setProductOption(ProductOption productOption) {
		this.productOption = productOption;
	}
	public ProductOptionValue getProductOptionValue() {
		return productOptionValue;
	}
	public void setProductOptionValue(ProductOptionValue productOptionValue) {
		this.productOptionValue = productOptionValue;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((optionValue == null) ? 0 : optionValue.hashCode());
		result = prime
				* result
				+ ((productAttribute == null) ? 0 : productAttribute.hashCode());
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
		ProductOptionAttribute other = (ProductOptionAttribute) obj;
		if (optionValue == null) {
			if (other.optionValue != null)
				return false;
		} else if (!optionValue.equals(other.optionValue))
			return false;
		if (productAttribute == null) {
			if (other.productAttribute != null)
				return false;
		} else if (!productAttribute.equals(other.productAttribute))
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
		return "ProductOptionAttribute [productAttribute=" + productAttribute
				+ ", productOption=" + productOption + ", productOptionValue="
				+ productOptionValue + ", optionValue=" + optionValue + "]";
	}
	
}
