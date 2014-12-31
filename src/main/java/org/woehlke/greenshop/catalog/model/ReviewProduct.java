package org.woehlke.greenshop.catalog.model;

import org.woehlke.greenshop.catalog.entities.ProductDescription;
import org.woehlke.greenshop.catalog.entities.ReviewDescription;

/**
 * Created by tw on 31.12.14.
 */
public class ReviewProduct {

    private ReviewDescription review;
    private ProductDescription product;

    public ReviewDescription getReview() {
        return review;
    }

    public void setReview(ReviewDescription review) {
        this.review = review;
    }

    public ProductDescription getProduct() {
        return product;
    }

    public void setProduct(ProductDescription product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewProduct)) return false;

        ReviewProduct that = (ReviewProduct) o;

        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = review != null ? review.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReviewProduct{" +
                "review=" + review +
                ", product=" + product +
                '}';
    }
}
