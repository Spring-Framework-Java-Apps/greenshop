package org.woehlke.greenshop.oodm.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/*
address_format_id	int(11)	NO	PRI		auto_increment
address_format	varchar(128)	NO			
address_summary	varchar(48)	NO			
 */
@Entity
@Table(name="address_format")
public class AddressFormat {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_format_id",columnDefinition = "INT(11)")
	private Long id;
	
	@Max(128)
	@Column(name="address_format")
	@NotNull
	private String format;
	
	@Max(48)
	@Column(name="address_summary")
	@NotNull
	private String summary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		AddressFormat other = (AddressFormat) obj;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressFormat [id=" + id + ", format=" + format + ", summary="
				+ summary + "]";
	}	
	
}
