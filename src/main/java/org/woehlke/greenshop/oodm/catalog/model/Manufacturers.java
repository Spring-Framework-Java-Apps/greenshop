package org.woehlke.greenshop.oodm.catalog.model;

import java.util.List;

import org.woehlke.greenshop.oodm.catalog.entities.Manufacturer;

public class Manufacturers {
	
	private List<Manufacturer> manufacturers;
	private long manufacturerId = 0;
	
	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}
	public long getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	
	@Override
	public String toString() {
		return "Manufacturers [manufacturers=" + manufacturers
				+ ", manufacturerId=" + manufacturerId + "]";
	}
	
}
