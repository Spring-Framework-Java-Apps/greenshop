package org.woehlke.greenshop.admin.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 mysql> desc tax_rates;
 +-----------------+--------------+------+-----+---------+----------------+
 | Field           | Type         | Null | Key | Default | Extra          |
 +-----------------+--------------+------+-----+---------+----------------+
 | tax_rates_id    | int(11)      | NO   | PRI | NULL    | auto_increment |
 | tax_zone_id     | int(11)      | NO   |     | NULL    |                |
 | tax_class_id    | int(11)      | NO   |     | NULL    |                |
 | tax_priority    | int(5)       | YES  |     | 1       |                |
 | tax_rate        | decimal(7,4) | NO   |     | NULL    |                |
 | tax_description | varchar(255) | NO   |     | NULL    |                |
 | last_modified   | datetime     | YES  |     | NULL    |                |
 | date_added      | datetime     | NO   |     | NULL    |                |
 +-----------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="tax_rates")
public class TaxRate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tax_rates_id",columnDefinition = "INT(11)")
    private Long id;

    @ManyToOne
    @JoinColumn(name="tax_zone_id")
    private TaxZone taxZone;

    @ManyToOne
    @JoinColumn(name="tax_class_id")
    private TaxClass taxClass;

    @Column(name="tax_priority",columnDefinition = "int(5)")
    private Integer priority;

    @Column(name="tax_rate",columnDefinition = "decimal(7,4)")
    private Double taxRate;

    @Length(max = 255)
    @Column(name="tax_description",columnDefinition = "varchar(255)")
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

    public TaxZone getTaxZone() {
        return taxZone;
    }

    public void setTaxZone(TaxZone taxZone) {
        this.taxZone = taxZone;
    }

    public TaxClass getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(TaxClass taxClass) {
        this.taxClass = taxClass;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
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
        if (!(o instanceof TaxRate)) return false;

        TaxRate taxRate1 = (TaxRate) o;

        if (dateAdded != null ? !dateAdded.equals(taxRate1.dateAdded) : taxRate1.dateAdded != null) return false;
        if (description != null ? !description.equals(taxRate1.description) : taxRate1.description != null)
            return false;
        if (id != null ? !id.equals(taxRate1.id) : taxRate1.id != null) return false;
        if (lastModified != null ? !lastModified.equals(taxRate1.lastModified) : taxRate1.lastModified != null)
            return false;
        if (priority != null ? !priority.equals(taxRate1.priority) : taxRate1.priority != null) return false;
        if (taxClass != null ? !taxClass.equals(taxRate1.taxClass) : taxRate1.taxClass != null) return false;
        if (taxRate != null ? !taxRate.equals(taxRate1.taxRate) : taxRate1.taxRate != null) return false;
        if (taxZone != null ? !taxZone.equals(taxRate1.taxZone) : taxRate1.taxZone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (taxZone != null ? taxZone.hashCode() : 0);
        result = 31 * result + (taxClass != null ? taxClass.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaxRate{" +
                "id=" + id +
                ", taxZone=" + taxZone +
                ", taxClass=" + taxClass +
                ", priority=" + priority +
                ", taxRate=" + taxRate +
                ", description='" + description + '\'' +
                ", lastModified=" + lastModified +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
