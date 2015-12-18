package org.woehlke.greenshop.oodm.cart.model;

import java.util.ArrayList;
import java.util.List;

import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.model.ProductOptionAttribute;

public class TransientProduct {
	
	private ProductDescription productDescription;
	private List<ProductOptionAttribute> productOptionAttributeList = new ArrayList<ProductOptionAttribute>();
	
	public Double getPrice(){
		Double price = productDescription.getProduct().getPrice();
		for(ProductOptionAttribute poa:productOptionAttributeList){
			Double relativePrice = poa.getProductAttribute().getPrice();
			String pricePrefix = poa.getProductAttribute().getPricePrefix();
			if(pricePrefix.equals("-")){
				price -= relativePrice;
			} else {
				price += relativePrice;
			}
		}
		return price;
	}
	
	public String getParameterForUrl(){
		StringBuffer b = new StringBuffer();
		for(ProductOptionAttribute poa:productOptionAttributeList){
			b.append("id_");
			b.append(poa.getProductOption().getId());
			b.append("=");
			b.append(poa.getProductOptionValue().getId());
			b.append("&");
		}
		return b.toString();
	}
	
	public String getProductIdWithAttributes(){
		StringBuffer s = new StringBuffer();
		s.append(this.getProductDescription().getProduct().getId());
		for(ProductOptionAttribute a:this.getProductOptionAttributeList()){
			s.append("{");
			s.append(a.getProductOption().getId());
			s.append("}");
			s.append(a.getProductOptionValue().getId());
		}
		return s.toString();
	}
	
	public ProductDescription getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}
	public List<ProductOptionAttribute> getProductOptionAttributeList() {
		return productOptionAttributeList;
	}
	public void setProductOptionAttributeList(
			List<ProductOptionAttribute> productOptionAttributeList) {
		this.productOptionAttributeList = productOptionAttributeList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((productDescription == null) ? 0 : productDescription
						.hashCode());
		result = prime
				* result
				+ ((productOptionAttributeList == null) ? 0
						: productOptionAttributeList.hashCode());
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
		TransientProduct other = (TransientProduct) obj;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productOptionAttributeList == null) {
			if (other.productOptionAttributeList != null)
				return false;
		} else if (!productOptionAttributeList
				.equals(other.productOptionAttributeList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransientProduct [productDescription=" + productDescription
				+ ", productOptionAttributeList=" + productOptionAttributeList
				+ "]";
	}

}
