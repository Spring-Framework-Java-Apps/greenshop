package org.woehlke.greenshop.catalog.model;

import java.util.List;

import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ProductDescription;

public class ProductsByCategory {
	
	private CategoryDescription thisCategory;
	private List<ProductDescription> productDescriptions;
	private List<CategoryDescription> childCategories;
	private List<Manufacturer> manufacturers;
	private long manufacturerId = 0;

	public List<ProductDescription> getProductDescriptions() {
		return productDescriptions;
	}

	public void setProductDescriptions(List<ProductDescription> productDescriptions) {
		this.productDescriptions = productDescriptions;
	}

	public CategoryDescription getThisCategory() {
		return thisCategory;
	}

	public void setThisCategory(CategoryDescription thisCategory) {
		this.thisCategory = thisCategory;
	}

	public List<CategoryDescription> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<CategoryDescription> childCategories) {
		this.childCategories = childCategories;
	}

	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	public long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	@Override
	public String toString() {
		return "ProductsByCategory [thisCategory=" + thisCategory
				+ ", productDescriptions=" + productDescriptions
				+ ", childCategories=" + childCategories + ", manufacturers="
				+ manufacturers + ", manufacturerId=" + manufacturerId + "]";
	}
	
	
}
