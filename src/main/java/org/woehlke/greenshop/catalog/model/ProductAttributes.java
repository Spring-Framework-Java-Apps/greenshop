package org.woehlke.greenshop.catalog.model;

import java.util.List;
import java.util.Map;

import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ProductOption;

public class ProductAttributes {
	private ProductDescription productDescription;
	private Map<ProductOption,List<ProductOptionAttribute>> mapProductOptionAttribute;
	public ProductDescription getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}
	public Map<ProductOption, List<ProductOptionAttribute>> getMapProductOptionAttribute() {
		return mapProductOptionAttribute;
	}
	public void setMapProductOptionAttribute(
			Map<ProductOption, List<ProductOptionAttribute>> mapProductOptionAttribute) {
		this.mapProductOptionAttribute = mapProductOptionAttribute;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((mapProductOptionAttribute == null) ? 0
						: mapProductOptionAttribute.hashCode());
		result = prime
				* result
				+ ((productDescription == null) ? 0 : productDescription
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
		ProductAttributes other = (ProductAttributes) obj;
		if (mapProductOptionAttribute == null) {
			if (other.mapProductOptionAttribute != null)
				return false;
		} else if (!mapProductOptionAttribute
				.equals(other.mapProductOptionAttribute))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductAttributes [productDescription=" + productDescription
				+ ", mapProductOptionAttribute=" + mapProductOptionAttribute
				+ "]";
	}
}
