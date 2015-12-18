package org.woehlke.greenshop.oodm.admin.entities;

import javax.persistence.*;
import java.util.Date;

/**
 mysql> desc tax_class;
 +-----------------------+--------------+------+-----+---------+----------------+
 | Field                 | Type         | Null | Key | Default | Extra          |
 +-----------------------+--------------+------+-----+---------+----------------+
 | tax_class_id          | int(11)      | NO   | PRI | NULL    | auto_increment |
 | tax_class_title       | varchar(32)  | NO   |     | NULL    |                |
 | tax_class_description | varchar(255) | NO   |     | NULL    |                |
 | last_modified         | datetime     | YES  |     | NULL    |                |
 | date_added            | datetime     | NO   |     | NULL    |                |
 +-----------------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="tax_class")
public class TaxClass {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tax_class_id",columnDefinition = "INT(11)")
    private Long id;

    @Column(name="tax_class_title",columnDefinition = "varchar(32)")
    private String title;

    @Column(name="tax_class_description",columnDefinition = "varchar(255)")
    private String description;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="last_modified")
    private Date lastModified;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="date_added")
    private Date dateAdded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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
        if (!(o instanceof TaxClass)) return false;

        TaxClass taxClass = (TaxClass) o;

        if (dateAdded != null ? !dateAdded.equals(taxClass.dateAdded) : taxClass.dateAdded != null) return false;
        if (description != null ? !description.equals(taxClass.description) : taxClass.description != null)
            return false;
        if (id != null ? !id.equals(taxClass.id) : taxClass.id != null) return false;
        if (lastModified != null ? !lastModified.equals(taxClass.lastModified) : taxClass.lastModified != null)
            return false;
        if (title != null ? !title.equals(taxClass.title) : taxClass.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaxClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lastModified=" + lastModified +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
