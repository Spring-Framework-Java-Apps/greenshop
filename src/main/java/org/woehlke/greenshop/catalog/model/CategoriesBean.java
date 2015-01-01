package org.woehlke.greenshop.catalog.model;

import org.woehlke.greenshop.catalog.entities.CategoryDescription;

import java.util.List;
import java.util.Map;

/**
 * Created by tw on 01.01.15.
 */
public class CategoriesBean {

    private List<CategoryDescription> categories;

    private Map<CategoryDescription,Integer> category2level;

    public List<CategoryDescription> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDescription> categories) {
        this.categories = categories;
    }

    public Map<CategoryDescription, Integer> getCategory2level() {
        return category2level;
    }

    public void setCategory2level(Map<CategoryDescription, Integer> category2level) {
        this.category2level = category2level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriesBean)) return false;

        CategoriesBean that = (CategoriesBean) o;

        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        if (category2level != null ? !category2level.equals(that.category2level) : that.category2level != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categories != null ? categories.hashCode() : 0;
        result = 31 * result + (category2level != null ? category2level.hashCode() : 0);
        return result;
    }
}
