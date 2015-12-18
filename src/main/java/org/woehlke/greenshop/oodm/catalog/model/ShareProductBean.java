package org.woehlke.greenshop.oodm.catalog.model;

import java.io.Serializable;

/**
 * Created by tw on 24.12.14.
 */
public class ShareProductBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productName;

    private String productUrl;

    private String productImageUrl;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShareProductBean)) return false;

        ShareProductBean that = (ShareProductBean) o;

        if (productImageUrl != null ? !productImageUrl.equals(that.productImageUrl) : that.productImageUrl != null)
            return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productUrl != null ? !productUrl.equals(that.productUrl) : that.productUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (productUrl != null ? productUrl.hashCode() : 0);
        result = 31 * result + (productImageUrl != null ? productImageUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShareProductBean{" +
                "productName='" + productName + '\'' +
                ", productUrl='" + productUrl + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }
}
