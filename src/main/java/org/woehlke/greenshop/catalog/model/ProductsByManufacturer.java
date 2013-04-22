package org.woehlke.greenshop.catalog.model;

import java.util.List;

import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.ProductDescription;

public class ProductsByManufacturer {
	private List<ProductDescription> products;
	private List<CategoryDescription> categoriesOfProducts;
	private long categoryId = 0;

	public List<ProductDescription> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDescription> products) {
		this.products = products;
	}

	public List<CategoryDescription> getCategoriesOfProducts() {
		return categoriesOfProducts;
	}

	public void setCategoriesOfProducts(
			List<CategoryDescription> categoriesOfProducts) {
		this.categoriesOfProducts = categoriesOfProducts;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ProductsByManufacturer [products=" + products
				+ ", categoriesOfProducts=" + categoriesOfProducts
				+ ", categoryId=" + categoryId + "]";
	}
	
	
}
