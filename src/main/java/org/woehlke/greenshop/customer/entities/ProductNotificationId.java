package org.woehlke.greenshop.customer.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
@Embeddable
public class ProductNotificationId implements Serializable {

    @NotNull
    @Column(name="products_id",columnDefinition = "int(11)")
    private Long productId;

    @NotNull
    @Column(name="customers_id",columnDefinition = "int(11)")
    private Long customerId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductNotificationId)) return false;

        ProductNotificationId that = (ProductNotificationId) o;

        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductNotificationId{" +
                "productId=" + productId +
                ", customerId=" + customerId +
                '}';
    }
}
