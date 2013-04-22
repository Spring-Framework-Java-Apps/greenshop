package org.woehlke.greenshop.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
countries_id	int(11)	NO	PRI		auto_increment
countries_name	varchar(255)	NO	MUL		
countries_iso_code_2	char(2)	NO			
countries_iso_code_3	char(3)	NO			
address_format_id	int(11)	NO
 */
@Entity
@Table(name="countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="countries_id",columnDefinition = "INT(11)")
	private Long id;
	
	@Max(128)
	@Column(name="countries_name")
	@NotNull
	private String name;
	
	@Max(2)
	@Min(2)
	@Column(name="countries_iso_code_2",length=2,columnDefinition = "char(2)")
	@NotNull
	private String isoCode2;
	
	@Max(3)
	@Min(3)
	@Column(name="countries_iso_code_3",length=3,columnDefinition = "char(3)")
	@NotNull
	private String isoCode3;
	
	@ManyToOne
	@JoinColumn(name="address_format_id")
	private AddressFormat addressFormat;

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

	public String getIsoCode2() {
		return isoCode2;
	}

	public void setIsoCode2(String isoCode2) {
		this.isoCode2 = isoCode2;
	}

	public String getIsoCode3() {
		return isoCode3;
	}

	public void setIsoCode3(String isoCode3) {
		this.isoCode3 = isoCode3;
	}

	public AddressFormat getAddressFormat() {
		return addressFormat;
	}

	public void setAddressFormat(AddressFormat addressFormat) {
		this.addressFormat = addressFormat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressFormat == null) ? 0 : addressFormat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isoCode2 == null) ? 0 : isoCode2.hashCode());
		result = prime * result
				+ ((isoCode3 == null) ? 0 : isoCode3.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (addressFormat == null) {
			if (other.addressFormat != null)
				return false;
		} else if (!addressFormat.equals(other.addressFormat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isoCode2 == null) {
			if (other.isoCode2 != null)
				return false;
		} else if (!isoCode2.equals(other.isoCode2))
			return false;
		if (isoCode3 == null) {
			if (other.isoCode3 != null)
				return false;
		} else if (!isoCode3.equals(other.isoCode3))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", isoCode2="
				+ isoCode2 + ", isoCode3=" + isoCode3 + ", addressFormat="
				+ addressFormat + "]";
	}
	
}
