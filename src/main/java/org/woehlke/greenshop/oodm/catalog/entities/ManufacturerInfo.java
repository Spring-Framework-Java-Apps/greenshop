package org.woehlke.greenshop.oodm.catalog.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 mysql> desc manufacturers_info;
 +-------------------+--------------+------+-----+---------+-------+
 | Field             | Type         | Null | Key | Default | Extra |
 +-------------------+--------------+------+-----+---------+-------+
 | manufacturers_id  | int(11)      | NO   | PRI | NULL    |       |
 | languages_id      | int(11)      | NO   | PRI | NULL    |       |
 | manufacturers_url | varchar(255) | NO   |     | NULL    |       |
 | url_clicked       | int(5)       | NO   |     | 0       |       |
 | date_last_click   | datetime     | YES  |     | NULL    |       |
 +-------------------+--------------+------+-----+---------+-------+
 */
@Entity
@Table(name="manufacturers_info")
@IdClass(ManufacturerInfoId.class)
public class ManufacturerInfo {

    @Id
    @ManyToOne
    @JoinColumn(name="manufacturers_id")
    private Manufacturer manufacturer;

    @Id
    @ManyToOne
    @JoinColumn(name="languages_id")
    private Language language;

    @Column(name="manufacturers_url")
    @NotNull
    private String url;

    @Column(name="url_clicked")
    private int urlClicked;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="date_last_click")
    private Date lastclick;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUrlClicked() {
        return urlClicked;
    }

    public void setUrlClicked(int urlClicked) {
        this.urlClicked = urlClicked;
    }

    public Date getLastclick() {
        return lastclick;
    }

    public void setLastclick(Date lastclick) {
        this.lastclick = lastclick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManufacturerInfo)) return false;

        ManufacturerInfo that = (ManufacturerInfo) o;

        if (urlClicked != that.urlClicked) return false;
        if (!language.equals(that.language)) return false;
        if (lastclick != null ? !lastclick.equals(that.lastclick) : that.lastclick != null) return false;
        if (!manufacturer.equals(that.manufacturer)) return false;
        if (!url.equals(that.url)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manufacturer.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + urlClicked;
        result = 31 * result + (lastclick != null ? lastclick.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ManufacturerInfo{" +
                "manufacturer=" + manufacturer +
                ", language=" + language +
                ", url='" + url + '\'' +
                ", urlClicked=" + urlClicked +
                ", lastclick=" + lastclick +
                '}';
    }

    public void addClick() {
        urlClicked++;
        lastclick = new Date();
    }
}
