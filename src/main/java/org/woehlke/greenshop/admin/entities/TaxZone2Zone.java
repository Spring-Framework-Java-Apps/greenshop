package org.woehlke.greenshop.admin.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Zone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 mysql> desc zones_to_geo_zones;
 +-----------------+----------+------+-----+---------+----------------+
 | Field           | Type     | Null | Key | Default | Extra          |
 +-----------------+----------+------+-----+---------+----------------+
 | association_id  | int(11)  | NO   | PRI | NULL    | auto_increment |
 | zone_country_id | int(11)  | NO   | MUL | NULL    |                |
 | zone_id         | int(11)  | YES  |     | NULL    |                |
 | geo_zone_id     | int(11)  | YES  |     | NULL    |                |
 | last_modified   | datetime | YES  |     | NULL    |                |
 | date_added      | datetime | NO   |     | NULL    |                |
 +-----------------+----------+------+-----+---------+----------------+
 */
@Entity
@Table(name="zones_to_geo_zones")
public class TaxZone2Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "association_id", columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "zone_country_id", columnDefinition = "INT(11)")
    private Country zoneCountry;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "zone_id", columnDefinition = "INT(11)")
    @NotFound(action = NotFoundAction.IGNORE)
    private Zone zone;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "geo_zone_id", columnDefinition = "INT(11)")
    private TaxZone taxZone;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    private Date lastModified;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    private Date dateAdded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getZoneCountry() {
        return zoneCountry;
    }

    public void setZoneCountry(Country zoneCountry) {
        this.zoneCountry = zoneCountry;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public TaxZone getTaxZone() {
        return taxZone;
    }

    public void setTaxZone(TaxZone taxZone) {
        this.taxZone = taxZone;
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
        if (!(o instanceof TaxZone2Zone)) return false;

        TaxZone2Zone that = (TaxZone2Zone) o;

        if (!dateAdded.equals(that.dateAdded)) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lastModified != null ? !lastModified.equals(that.lastModified) : that.lastModified != null) return false;
        if (taxZone != null ? !taxZone.equals(that.taxZone) : that.taxZone != null) return false;
        if (zone != null ? !zone.equals(that.zone) : that.zone != null) return false;
        if (!zoneCountry.equals(that.zoneCountry)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + zoneCountry.hashCode();
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        result = 31 * result + (taxZone != null ? taxZone.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + dateAdded.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TaxZone2Zone{" +
                "id=" + id +
                ", zoneCountry=" + zoneCountry +
                ", zone=" + zone +
                ", taxZone=" + taxZone +
                ", lastModified=" + lastModified +
                ", dateAdded=" + dateAdded +
                '}';
    }
}