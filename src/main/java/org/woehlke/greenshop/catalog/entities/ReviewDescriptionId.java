package org.woehlke.greenshop.catalog.entities;

import java.io.Serializable;

/**
 * Created by tw on 25.12.14.
 */
public class ReviewDescriptionId implements Serializable {

    private Review review;

    private Language language;

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewDescriptionId)) return false;

        ReviewDescriptionId that = (ReviewDescriptionId) o;

        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = review != null ? review.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReviewDescriptionId{" +
                "review=" + review +
                ", language=" + language +
                '}';
    }
}
