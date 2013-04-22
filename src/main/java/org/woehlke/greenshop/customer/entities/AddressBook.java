package org.woehlke.greenshop.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
address_book_id	int(11)	NO	PRI		auto_increment
customers_id	int(11)	NO	MUL		
entry_gender	char(1)	YES			
entry_company	varchar(255)	YES			
entry_firstname	varchar(255)	NO			
entry_lastname	varchar(255)	NO			
entry_street_address	varchar(255)	NO			
entry_suburb	varchar(255)	YES			
entry_postcode	varchar(255)	NO			
entry_city	varchar(255)	NO			
entry_state	varchar(255)	YES			
entry_country_id	int(11)	NO		0	
entry_zone_id	int(11)	NO		0	
 */
@Entity
@Table(name="address_book")
public class AddressBook {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_book_id", columnDefinition = "INT(11)")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="customers_id")
	private Customer customer;
	
	@Column(name="entry_gender", columnDefinition = "char(1)")
	private String gender;
	
	@Column(name="entry_company")
	private String company;
	
	@Column(name="entry_firstname")
	private String firstname;
	
	@Column(name="entry_lastname")
	private String lastname;
	
	@Column(name="entry_street_address")
	private String streetAddress;
	
	@Column(name="entry_suburb")
	private String suburb;
	
	@Column(name="entry_postcode")
	private String postcode;
	
	@Column(name="entry_city")
	private String city;
	
	@Column(name="entry_state")
	private String state;
	
	@ManyToOne
	@JoinColumn(name="entry_country_id")
	private Country country;
	
	@Column(name="entry_zone_id", columnDefinition = "INT(11)")
	private long zoneId=0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", customer=" + customer + ", gender="
				+ gender + ", company=" + company + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", streetAddress=" + streetAddress
				+ ", suburb=" + suburb + ", postcode=" + postcode + ", city="
				+ city + ", state=" + state + ", country=" + country
				+ ", zoneId=" + zoneId + "]";
	}
	
	@Transient
	public String getFormattedAddress(){
		return firstname+" "+lastname+"<br/>"+streetAddress+"<br/>"+postcode+" "+city+"<br/>"+country.getName();
	}
	
	@Transient
	public boolean isPrimaryAddress(){
		return customer.getDefaultAddress().getId()==this.id;
	}
}
