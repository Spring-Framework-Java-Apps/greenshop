package org.woehlke.greenshop.catalog.model;

import java.util.List;

import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.Manufacturer;

public class ProductsByCategory {
	
	private CategoryDescription thisCategory;
	private List<SpecialProduct> products;
	private List<CategoryDescription> childCategories;
	private List<Manufacturer> manufacturers;
	private long manufacturerId = 0;

	public List<SpecialProduct> getProducts() {
		return products;
	}

	public void setProducts(List<SpecialProduct> products) {
		this.products = products;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ProductsByCategory)) return false;

		ProductsByCategory that = (ProductsByCategory) o;

		if (manufacturerId != that.manufacturerId) return false;
		if (childCategories != null ? !childCategories.equals(that.childCategories) : that.childCategories != null)
			return false;
		if (manufacturers != null ? !manufacturers.equals(that.manufacturers) : that.manufacturers != null)
			return false;
		if (products != null ? !products.equals(that.products) : that.products != null) return false;
		if (thisCategory != null ? !thisCategory.equals(that.thisCategory) : that.thisCategory != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = thisCategory != null ? thisCategory.hashCode() : 0;
		result = 31 * result + (products != null ? products.hashCode() : 0);
		result = 31 * result + (childCategories != null ? childCategories.hashCode() : 0);
		result = 31 * result + (manufacturers != null ? manufacturers.hashCode() : 0);
		result = 31 * result + (int) (manufacturerId ^ (manufacturerId >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "ProductsByCategory{" +
				"thisCategory=" + thisCategory +
				", products=" + products +
				", childCategories=" + childCategories +
				", manufacturers=" + manufacturers +
				", manufacturerId=" + manufacturerId +
				'}';
	}
}
