package org.woehlke.greenshop.catalog.entities;

import javax.persistence.*;
import java.util.Date;

/**
 mysql> desc reviews;
 +----------------+--------------+------+-----+---------+----------------+
 | Field          | Type         | Null | Key | Default | Extra          |
 +----------------+--------------+------+-----+---------+----------------+
 | reviews_id     | int(11)      | NO   | PRI | NULL    | auto_increment |
 | products_id    | int(11)      | NO   | MUL | NULL    |                |
 | customers_id   | int(11)      | YES  | MUL | NULL    |                |
 | customers_name | varchar(255) | NO   |     | NULL    |                |
 | reviews_rating | int(1)       | YES  |     | NULL    |                |
 | date_added     | datetime     | YES  |     | NULL    |                |
 | last_modified  | datetime     | YES  |     | NULL    |                |
 | reviews_status | tinyint(1)   | NO   |     | 0       |                |
 | reviews_read   | int(5)       | NO   |     | 0       |                |
 +----------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="reviews_id",columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne
    @JoinColumn(name="products_id")
    private Product product;

    @Column(name="customers_id",columnDefinition = "INT(11)")
    private Long customersId;

    @Column(name="customers_name")
    private String customersName;

    @Column(name="reviews_rating",columnDefinition = "INT(1)")
    private Integer rating;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="date_added")
    private Date dateAdded;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="last_modified")
    private Date lastModified;

    @Column(name="reviews_status",columnDefinition = "bit")
    private int status;

    @Column(name="reviews_read",columnDefinition = "int(5)")
    private int reviewsRead;

    public void increaseReviewsRead() {
        reviewsRead++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCustomersId() {
        return customersId;
    }

    public void setCustomersId(Long customersId) {
        this.customersId = customersId;
    }

    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getReviewsRead() {
        return reviewsRead;
    }

    public void setReviewsRead(int reviewsRead) {
        this.reviewsRead = reviewsRead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;

        Review review = (Review) o;

        if (reviewsRead != review.reviewsRead) return false;
        if (status != review.status) return false;
        if (customersId != null ? !customersId.equals(review.customersId) : review.customersId != null) return false;
        if (customersName != null ? !customersName.equals(review.customersName) : review.customersName != null)
            return false;
        if (dateAdded != null ? !dateAdded.equals(review.dateAdded) : review.dateAdded != null) return false;
        if (id != null ? !id.equals(review.id) : review.id != null) return false;
        if (lastModified != null ? !lastModified.equals(review.lastModified) : review.lastModified != null)
            return false;
        if (product != null ? !product.equals(review.product) : review.product != null) return false;
        if (rating != null ? !rating.equals(review.rating) : review.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (customersId != null ? customersId.hashCode() : 0);
        result = 31 * result + (customersName != null ? customersName.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + reviewsRead;
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", product=" + product +
                ", customersId=" + customersId +
                ", customersName='" + customersName + '\'' +
                ", rating=" + rating +
                ", dateAdded=" + dateAdded +
                ", lastModified=" + lastModified +
                ", status=" + status +
                ", reviewsRead=" + reviewsRead +
                '}';
    }
}
