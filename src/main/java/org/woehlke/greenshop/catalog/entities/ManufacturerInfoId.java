package org.woehlke.greenshop.catalog.entities;

import java.io.Serializable;

/**
 * Created by tw on 24.12.14.
 */
public class ManufacturerInfoId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Manufacturer manufacturer;

    private Language language;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManufacturerInfoId)) return false;

        ManufacturerInfoId that = (ManufacturerInfoId) o;

        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manufacturer != null ? manufacturer.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ManufacturerInfoId{" +
                "manufacturer=" + manufacturer +
                ", language=" + language +
                '}';
    }
}
