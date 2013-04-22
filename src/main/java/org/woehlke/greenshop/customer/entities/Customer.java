package org.woehlke.greenshop.customer.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/*
customers_id	int(11)	NO	PRI		auto_increment
customers_gender	char(1)	YES			
customers_firstname	varchar(255)	NO			
customers_lastname	varchar(255)	NO			
customers_dob	datetime	NO		0000-00-00 00:00:00	
customers_email_address	varchar(255)	NO	MUL		
customers_default_address_id	int(11)	YES			
customers_telephone	varchar(255)	NO			
customers_fax	varchar(255)	YES			
customers_password	varchar(60)	NO			
customers_newsletter	char(1)	YES
 */
@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customers_id", columnDefinition = "INT(11)")
	private Long id;
	
	@Column(name="customers_gender", columnDefinition = "char(1)")
	private String gender;
	
	@Column(name="customers_firstname")
	private String firstname;
	
	@Column(name="customers_lastname")
	private String lastname;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="customers_dob",columnDefinition = "datetime")
	private Date dob;
	
	@Column(name="customers_email_address")
	private String emailAddress; 
	
	@OneToOne
	@JoinColumn(name="customers_default_address_id")
	private AddressBook defaultAddress;
	
	@Column(name="customers_telephone")
	private String telephone;
	
	@Column(name="customers_fax")
	private String fax;
	
	@Column(name="customers_password")
	private String password;
	
	@Column(name="customers_newsletter", columnDefinition = "char(1)")
	private String newsletter;

	@Transient
	boolean isMale(){
		return gender.equals("m");
	}
	
	@Transient
	boolean isFemale() {
		return gender.equals("f");
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public AddressBook getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(AddressBook defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(String newsletter) {
		this.newsletter = newsletter;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", gender=" + gender + ", firstname="
				+ firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", emailAddress=" + emailAddress + ", telephone=" + telephone + ", fax=" + fax
				+ ", password=" + password + ", newsletter=" + newsletter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Customer other = (Customer) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
