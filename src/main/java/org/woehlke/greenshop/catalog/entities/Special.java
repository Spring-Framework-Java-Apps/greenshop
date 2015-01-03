package org.woehlke.greenshop.catalog.entities;

import javax.persistence.*;
import java.util.Date;

/**
 mysql> desc specials;
 +-----------------------------+---------------+------+-----+---------+----------------+
 | Field                       | Type          | Null | Key | Default | Extra          |
 +-----------------------------+---------------+------+-----+---------+----------------+
 | specials_id                 | int(11)       | NO   | PRI | NULL    | auto_increment |
 | products_id                 | int(11)       | NO   | MUL | NULL    |                |
 | specials_new_products_price | decimal(15,4) | NO   |     | NULL    |                |
 | specials_date_added         | datetime      | YES  |     | NULL    |                |
 | specials_last_modified      | datetime      | YES  |     | NULL    |                |
 | expires_date                | datetime      | YES  |     | NULL    |                |
 | date_status_change          | datetime      | YES  |     | NULL    |                |
 | status                      | int(1)        | NO   |     | 1       |                |
 +-----------------------------+---------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="specials")
public class Special {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="specials_id",columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne
    @JoinColumn(name="products_id")
    private Product product;

    @Column(name="specials_new_products_price",
            columnDefinition = "decimal(15,4)",precision=15,scale=4)
    private Double newPrice;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="specials_date_added")
    private Date added;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="specials_last_modified")
    private Date lastModified;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="expires_date")
    private Date expires;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="date_status_change")
    private Date statusChanged;

    @Column(name="status")
    private int status;

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

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public Date getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(Date statusChanged) {
        this.statusChanged = statusChanged;
    }

    public boolean getStatus() {
        return status==1;
    }

    public void setStatus(boolean status) {
        this.status=status?1:0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Special)) return false;

        Special special = (Special) o;

        if (status != special.status) return false;
        if (added != null ? !added.equals(special.added) : special.added != null) return false;
        if (expires != null ? !expires.equals(special.expires) : special.expires != null) return false;
        if (id != null ? !id.equals(special.id) : special.id != null) return false;
        if (lastModified != null ? !lastModified.equals(special.lastModified) : special.lastModified != null)
            return false;
        if (newPrice != null ? !newPrice.equals(special.newPrice) : special.newPrice != null) return false;
        if (product != null ? !product.equals(special.product) : special.product != null) return false;
        if (statusChanged != null ? !statusChanged.equals(special.statusChanged) : special.statusChanged != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (newPrice != null ? newPrice.hashCode() : 0);
        result = 31 * result + (added != null ? added.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (expires != null ? expires.hashCode() : 0);
        result = 31 * result + (statusChanged != null ? statusChanged.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "Special{" +
                "id=" + id +
                ", product=" + product +
                ", newPrice=" + newPrice +
                ", added=" + added +
                ", lastModified=" + lastModified +
                ", expires=" + expires +
                ", statusChanged=" + statusChanged +
                ", status=" + status +
                '}';
    }
}
