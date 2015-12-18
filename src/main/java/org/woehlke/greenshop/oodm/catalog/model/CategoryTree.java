package org.woehlke.greenshop.oodm.catalog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.woehlke.greenshop.oodm.catalog.entities.CategoryDescription;

public class CategoryTree {

	private List<CategoryTreeNode> categoriesMenuList;
	private CategoryDescription thisCategory;
	private long thisCategoryId;
	private Map<Long,Long> categoryIdToNumberOfProducts;
	private Map<Long,Boolean> hasChildrenMap;
	private List<CategoryDescription> breadcrumb;

	public List<CategoryTreeNode> getThisLevelCategories(){
		if(thisCategoryId==0){
			return categoriesMenuList;
		}  else {
			List<CategoryTreeNode> thisLevelCategories = new ArrayList<>();
			for(CategoryTreeNode oneCategory:categoriesMenuList){
				if(oneCategory.getCategoryDescription().getCategory().getParentId() == this.thisCategory.getCategory().getParentId()){
					thisLevelCategories.add(oneCategory);
				}
			}
			return thisLevelCategories;
		}
	}

	public List<CategoryTreeNode> getChildren() {
		List<CategoryTreeNode> children = new ArrayList<>();
		for(CategoryTreeNode oneCategory:categoriesMenuList){
			if(oneCategory.getCategoryDescription().getCategory().getParentId() == this.thisCategoryId){
				children.add(oneCategory);
			}
		}
		return children;
	}

	/*
	public long getNumberOfProducts(){
		for (Long categoryId:categoryIdToNumberOfProducts.keySet()){
			if(categoryId==thisCategoryId){
			 	return categoryIdToNumberOfProducts.get(categoryId);
			}
		}
		return 0;
	}

	public int getNumberOfChildren(){
	 	return getChildren().size();
	}
	*/

	public List<CategoryTreeNode> getCategoriesMenuList() {
		return categoriesMenuList;
	}

	public void setCategoriesMenuList(List<CategoryTreeNode> categoriesMenuList) {
		this.categoriesMenuList = categoriesMenuList;
	}

	public CategoryDescription getThisCategory() {
		return thisCategory;
	}

	public void setThisCategory(CategoryDescription thisCategory) {
		this.thisCategory = thisCategory;
	}

	public long getThisCategoryId() {
		return thisCategoryId;
	}

	public void setThisCategoryId(long thisCategoryId) {
		this.thisCategoryId = thisCategoryId;
	}

	public Map<Long, Long> getCategoryIdToNumberOfProducts() {
		return categoryIdToNumberOfProducts;
	}

	public void setCategoryIdToNumberOfProducts(Map<Long, Long> categoryIdToNumberOfProducts) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CategoryTree)) return false;

		CategoryTree that = (CategoryTree) o;

		if (thisCategoryId != that.thisCategoryId) return false;
		if (breadcrumb != null ? !breadcrumb.equals(that.breadcrumb) : that.breadcrumb != null) return false;
		if (categoriesMenuList != null ? !categoriesMenuList.equals(that.categoriesMenuList) : that.categoriesMenuList != null)
			return false;
		if (categoryIdToNumberOfProducts != null ? !categoryIdToNumberOfProducts.equals(that.categoryIdToNumberOfProducts) : that.categoryIdToNumberOfProducts != null)
			return false;
		if (hasChildrenMap != null ? !hasChildrenMap.equals(that.hasChildrenMap) : that.hasChildrenMap != null)
			return false;
		if (thisCategory != null ? !thisCategory.equals(that.thisCategory) : that.thisCategory != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = categoriesMenuList != null ? categoriesMenuList.hashCode() : 0;
		result = 31 * result + (thisCategory != null ? thisCategory.hashCode() : 0);
		result = 31 * result + (int) (thisCategoryId ^ (thisCategoryId >>> 32));
		result = 31 * result + (categoryIdToNumberOfProducts != null ? categoryIdToNumberOfProducts.hashCode() : 0);
		result = 31 * result + (hasChildrenMap != null ? hasChildrenMap.hashCode() : 0);
		result = 31 * result + (breadcrumb != null ? breadcrumb.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CategoryTree{" +
				"categoriesMenuList=" + categoriesMenuList +
				", thisCategory=" + thisCategory +
				", thisCategoryId=" + thisCategoryId +
				", categoryIdToNumberOfProducts=" + categoryIdToNumberOfProducts +
				", hasChildrenMap=" + hasChildrenMap +
				", breadcrumb=" + breadcrumb +
				'}';
	}
}
