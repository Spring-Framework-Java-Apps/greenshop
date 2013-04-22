package org.woehlke.greenshop.catalog.model;

import java.util.List;
import java.util.Map;

import org.woehlke.greenshop.catalog.entities.CategoryDescription;

public class CategoryTree {
	private List<CategoryTreeNode> categoriesMenuList;
	private long categoryId;
	private Map<Long,Long> categoryIdToNumberOfProducts;
	private Map<Long,Boolean> hasChildrenMap;
	private List<CategoryDescription> breadcrumb;

	public List<CategoryTreeNode> getCategoriesMenuList() {
		return categoriesMenuList;
	}

	public void setCategoriesMenuList(List<CategoryTreeNode> categoriesMenuList) {
		this.categoriesMenuList = categoriesMenuList;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Map<Long, Long> getCategoryIdToNumberOfProducts() {
		return categoryIdToNumberOfProducts;
	}

	public void setCategoryIdToNumberOfProducts(
			Map<Long, Long> categoryIdToNumberOfProducts) {
		this.categoryIdToNumberOfProducts = categoryIdToNumberOfProducts;
	}

	public Map<Long, Boolean> getHasChildrenMap() {
		return hasChildrenMap;
	}

	public void setHasChildrenMap(Map<Long, Boolean> hasChildrenMap) {
		this.hasChildrenMap = hasChildrenMap;
	}

	public List<CategoryDescription> getBreadcrumb() {
		return breadcrumb;
	}

	public void setBreadcrumb(List<CategoryDescription> breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

	@Override
	public String toString() {
		return "CategoryTree [categoriesMenuList=" + categoriesMenuList
				+ ", categoryId=" + categoryId
				+ ", categoryIdToNumberOfProducts="
				+ categoryIdToNumberOfProducts + ", hasChildrenMap="
				+ hasChildrenMap + ", breadcrumb=" + breadcrumb + "]";
	}
	
}
