package org.woehlke.greenshop.catalog.model;

import org.woehlke.greenshop.catalog.entities.CategoryDescription;

public class CategoryTreeNode {
	private CategoryDescription categoryDescription;
	private int level;
	private long numberOfProducts;
	private boolean hasChildCategories;
	public CategoryDescription getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(CategoryDescription categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public long getNumberOfProducts() {
		return numberOfProducts;
	}
	public void setNumberOfProducts(long numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}
	public boolean isHasChildCategories() {
		return hasChildCategories;
	}
	public void setHasChildCategories(boolean hasChildCategories) {
		this.hasChildCategories = hasChildCategories;
	}
	
	@Override
	public String toString() {
		return "CategoryTreeNode [categoryDescription=" + categoryDescription
				+ ", level=" + level + ", numberOfProducts=" + numberOfProducts
				+ ", hasChildCategories=" + hasChildCategories + "]";
	}
	
}
