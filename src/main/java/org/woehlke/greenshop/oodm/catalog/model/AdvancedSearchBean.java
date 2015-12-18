package org.woehlke.greenshop.oodm.catalog.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by tw on 01.01.15.
 */
public class AdvancedSearchBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotEmpty
    @SafeHtml
    private String searchKeywords;

    private Long category;

    private Boolean includeSubcategories;

    private Long manufacturer;

    private String priceFrom;

    private String priceTo;

    private String dateFrom;

    private String dateTo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSearchKeywords() {
        return searchKeywords;
    }

    public void setSearchKeywords(String searchKeywords) {
        this.searchKeywords = searchKeywords;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Boolean getIncludeSubcategories() {
        return includeSubcategories;
    }

    public void setIncludeSubcategories(Boolean includeSubcategories) {
        this.includeSubcategories = includeSubcategories;
    }

    public Long getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Long manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvancedSearchBean)) return false;

        AdvancedSearchBean that = (AdvancedSearchBean) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;
        if (includeSubcategories != null ? !includeSubcategories.equals(that.includeSubcategories) : that.includeSubcategories != null)
            return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (priceFrom != null ? !priceFrom.equals(that.priceFrom) : that.priceFrom != null) return false;
        if (priceTo != null ? !priceTo.equals(that.priceTo) : that.priceTo != null) return false;
        if (searchKeywords != null ? !searchKeywords.equals(that.searchKeywords) : that.searchKeywords != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = searchKeywords != null ? searchKeywords.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (includeSubcategories != null ? includeSubcategories.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (priceFrom != null ? priceFrom.hashCode() : 0);
        result = 31 * result + (priceTo != null ? priceTo.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdvancedSearchBean{" +
                "searchKeywords='" + searchKeywords + '\'' +
                ", category=" + category +
                ", includeSubcategories=" + includeSubcategories +
                ", manufacturer=" + manufacturer +
                ", priceFrom='" + priceFrom + '\'' +
                ", priceTo='" + priceTo + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                '}';
    }
}
