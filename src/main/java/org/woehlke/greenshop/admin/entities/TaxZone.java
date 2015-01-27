package org.woehlke.greenshop.admin.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 mysql> desc geo_zones;
 +----------------------+--------------+------+-----+---------+----------------+
 | Field                | Type         | Null | Key | Default | Extra          |
 +----------------------+--------------+------+-----+---------+----------------+
 | geo_zone_id          | int(11)      | NO   | PRI | NULL    | auto_increment |
 | geo_zone_name        | varchar(32)  | NO   |     | NULL    |                |
 | geo_zone_description | varchar(255) | NO   |     | NULL    |                |
 | last_modified        | datetime     | YES  |     | NULL    |                |
 | date_added           | datetime     | NO   |     | NULL    |                |
 +----------------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="geo_zones")
public class TaxZone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="geo_zone_id",columnDefinition = "INT(11)")
    private Long id;

    @SafeHtml
    @NotBlank
    @Length(max=32)
    @Column(name="geo_zone_name",columnDefinition = "varchar(32)")
    private String name;

    @SafeHtml
    @NotBlank
    @Length(max=255)
    @Column(name="geo_zone_description",columnDefinition = "varchar(255)")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof TaxZone)) return false;

        TaxZone taxZone = (TaxZone) o;

        if (dateAdded != null ? !dateAdded.equals(taxZone.dateAdded) : taxZone.dateAdded != null) return false;
        if (description != null ? !description.equals(taxZone.description) : taxZone.description != null) return false;
        if (id != null ? !id.equals(taxZone.id) : taxZone.id != null) return false;
        if (lastModified != null ? !lastModified.equals(taxZone.lastModified) : taxZone.lastModified != null)
            return false;
        if (name != null ? !name.equals(taxZone.name) : taxZone.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaxZone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lastModified=" + lastModified +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
