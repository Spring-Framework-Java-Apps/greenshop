package org.woehlke.greenshop.oodm.catalog.entities;

import javax.persistence.*;

/**
 mysql> desc products_images;
 +-------------+-------------+------+-----+---------+----------------+
 | Field       | Type        | Null | Key | Default | Extra          |
 +-------------+-------------+------+-----+---------+----------------+
 | id          | int(11)     | NO   | PRI | NULL    | auto_increment |
 | products_id | int(11)     | NO   | MUL | NULL    |                |
 | image       | varchar(64) | YES  |     | NULL    |                |
 | htmlcontent | text        | YES  |     | NULL    |                |
 | sort_order  | int(11)     | NO   |     | NULL    |                |
 +-------------+-------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="products_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne
    @JoinColumn(name="products_id")
    private Product product;

    @Column(name="image", length=64,columnDefinition = "varchar(64)")
    private String image;

    @Column(name="htmlcontent",columnDefinition = "text")
    private String htmlContent;

    @Column(name="sort_order",columnDefinition = "INT(11)")
    private long sequence;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sortOrder) {
        this.sequence = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductImage)) return false;

        ProductImage that = (ProductImage) o;

        if (sequence != that.sequence) return false;
        if (htmlContent != null ? !htmlContent.equals(that.htmlContent) : that.htmlContent != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (htmlContent != null ? htmlContent.hashCode() : 0);
        result = 31 * result + (int) (sequence ^ (sequence >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", product=" + product +
                ", image='" + image + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", sortOrder=" + sequence +
                '}';
    }
}
