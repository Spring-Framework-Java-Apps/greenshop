package org.woehlke.greenshop.oodm.customer.entities;

import org.hibernate.validator.constraints.Length;

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

    @Length(max = 32)
	@Column(name="zone_name")
	private String name;

    @Length(max = 255)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zone)) return false;

        Zone zone = (Zone) o;

        if (code != null ? !code.equals(zone.code) : zone.code != null) return false;
        if (country != null ? !country.equals(zone.country) : zone.country != null) return false;
        if (id != null ? !id.equals(zone.id) : zone.id != null) return false;
        if (name != null ? !name.equals(zone.name) : zone.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
