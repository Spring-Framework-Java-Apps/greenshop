package org.woehlke.greenshop.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 mysql> desc zones;
 +-----------------+--------------+------+-----+---------+----------------+
 | Field           | Type         | Null | Key | Default | Extra          |
 +-----------------+--------------+------+-----+---------+----------------+
 | zone_id         | int(11)      | NO   | PRI | NULL    | auto_increment |
 | zone_country_id | int(11)      | NO   | MUL | NULL    |                |
 | zone_code       | varchar(32)  | NO   |     | NULL    |                |
 | zone_name       | varchar(255) | NO   |     | NULL    |                |
 +-----------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="zones")
public class Zone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="zone_id",columnDefinition = "INT(11)")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="zone_country_id")
	private Country country;
	
	@Column(name="zone_name")
	private String name;
	
	@Column(name="zone_code")
	private String code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Zone [id=" + id + ", country=" + country + ", name=" + name
				+ ", code=" + code + "]";
	}
	
	
}
