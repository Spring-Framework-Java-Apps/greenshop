package org.woehlke.greenshop.catalog.entities;

import javax.persistence.*;

/**
 mysql> show columns from reviews_description;
 +--------------+---------+------+-----+---------+-------+
 | Field        | Type    | Null | Key | Default | Extra |
 +--------------+---------+------+-----+---------+-------+
 | reviews_id   | int(11) | NO   | PRI | NULL    |       |
 | languages_id | int(11) | NO   | PRI | NULL    |       |
 | reviews_text | text    | NO   |     | NULL    |       |
 +--------------+---------+------+-----+---------+-------+
 */
@Entity
@Table(name="reviews_description")
@IdClass(ReviewDescriptionId.class)
public class ReviewDescription {

    @Id
    @ManyToOne
    @JoinColumn(name="reviews_id")
    private Review review;

    @Id
    @ManyToOne
    @JoinColumn(name="languages_id")
    private Language language;

    @Column(name="reviews_text",columnDefinition = "text")
    private String reviewText;


    private final static int SHORT_TEXT_LENGTH = 70;

    public String getReviewTextShort() {
        if(reviewText.length() > SHORT_TEXT_LENGTH){
            String shortText = reviewText.substring(0,SHORT_TEXT_LENGTH);
            return shortText+"...";
        } else {
            return reviewText;
        }
    }

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

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewDescription)) return false;

        ReviewDescription that = (ReviewDescription) o;

        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;
        if (reviewText != null ? !reviewText.equals(that.reviewText) : that.reviewText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = review != null ? review.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (reviewText != null ? reviewText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReviewDescription{" +
                "review=" + review +
                ", language=" + language +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
