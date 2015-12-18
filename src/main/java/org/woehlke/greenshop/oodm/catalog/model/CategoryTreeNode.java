package org.woehlke.greenshop.oodm.catalog.model;

import org.woehlke.greenshop.oodm.catalog.entities.CategoryDescription;

public class CategoryTreeNode {
	private CategoryDescription categoryDescription;
	private int level;
	private long numberOfProducts;
	private long numberOfChildCategories;
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

	public long getNumberOfChildCategories() {
		return numberOfChildCategories;
	}

	public void setNumberOfChildCategories(long numberOfChildCategories) {
		this.numberOfChildCategories = numberOfChildCategories;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryTreeNode)) return false;

		CategoryTreeNode that = (CategoryTreeNode) o;

		if (hasChildCategories != that.hasChildCategories) return false;
		if (level != that.level) return false;
		if (numberOfChildCategories != that.numberOfChildCategories) return false;
		if (numberOfProducts != that.numberOfProducts) return false;
		if (categoryDescription != null ? !categoryDescription.equals(that.categoryDescription) : that.categoryDescription != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = categoryDescription != null ? categoryDescription.hashCode() : 0;
		result = 31 * result + level;
		result = 31 * result + (int) (numberOfProducts ^ (numberOfProducts >>> 32));
		result = 31 * result + (int) (numberOfChildCategories ^ (numberOfChildCategories >>> 32));
		result = 31 * result + (hasChildCategories ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CategoryTreeNode{" +
				"categoryDescription=" + categoryDescription +
				", level=" + level +
				", numberOfProducts=" + numberOfProducts +
				", numberOfChildCategories=" + numberOfChildCategories +
				", hasChildCategories=" + hasChildCategories +
				'}';
	}
}
