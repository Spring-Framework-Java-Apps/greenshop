package org.woehlke.greenshop.customer.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 mysql> desc products_notifications;
 +--------------+----------+------+-----+---------+-------+
 | Field        | Type     | Null | Key | Default | Extra |
 +--------------+----------+------+-----+---------+-------+
 | products_id  | int(11)  | NO   | PRI | NULL    |       |
 | customers_id | int(11)  | NO   | PRI | NULL    |       |
 | date_added   | datetime | NO   |     | NULL    |       |
 +--------------+----------+------+-----+---------+-------+
 */
@Entity
@Table(name="products_notifications")
public class ProductNotification {

    @NotNull
    @EmbeddedId ProductNotificationId id;

    @NotNull
    @Column(name="date_added",columnDefinition = "datetime")
    private Date dateAdded;

    public ProductNotificationId getId() {
        return id;
    }

    public void setId(ProductNotificationId id) {
        this.id = id;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductNotification)) return false;

        ProductNotification that = (ProductNotification) o;

        if (dateAdded != null ? !dateAdded.equals(that.dateAdded) : that.dateAdded != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductNotification{" +
                "id=" + id +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
