package org.woehlke.greenshop.oodm.catalog.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by tw on 25.12.14.
 */
public class WriteReviewBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Length(min=50)
    @SafeHtml
    @NotBlank
    private String reviewText;

    @Min(1)
    @Max(5)
    private int rating;


    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WriteReviewBean)) return false;

        WriteReviewBean that = (WriteReviewBean) o;

        if (rating != that.rating) return false;
        if (reviewText != null ? !reviewText.equals(that.reviewText) : that.reviewText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewText != null ? reviewText.hashCode() : 0;
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return "WriteReviewBean{" +
                "reviewText='" + reviewText + '\'' +
                ", rating=" + rating +
                '}';
    }
}
