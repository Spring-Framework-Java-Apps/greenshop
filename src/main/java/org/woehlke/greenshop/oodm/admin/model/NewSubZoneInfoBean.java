package org.woehlke.greenshop.oodm.admin.model;


/**
 * Created by tw on 28.01.15.
 */
public class NewSubZoneInfoBean {

    private Long zone_country_id;
    private Long zone_id;

    public Long getZone_country_id() {
        return zone_country_id;
    }

    public void setZone_country_id(Long zone_country_id) {
        this.zone_country_id = zone_country_id;
    }

    public Long getZone_id() {
        return zone_id;
    }

    public void setZone_id(Long zone_id) {
        this.zone_id = zone_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewSubZoneInfoBean)) return false;

        NewSubZoneInfoBean that = (NewSubZoneInfoBean) o;

        if (zone_country_id != null ? !zone_country_id.equals(that.zone_country_id) : that.zone_country_id != null)
            return false;
        if (zone_id != null ? !zone_id.equals(that.zone_id) : that.zone_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zone_country_id != null ? zone_country_id.hashCode() : 0;
        result = 31 * result + (zone_id != null ? zone_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewSubZoneInfoBean{" +
                "zone_country_id=" + zone_country_id +
                ", zone_id=" + zone_id +
                '}';
    }
}
