package org.woehlke.greenshop.oodm.customer.model;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
//import org.hibernate.validator.constraints.SafeHtml;

public class CreateNewCustomerFormBean {
	
	@Pattern(regexp="m|f")
	@NotEmpty
	private String gender;
	
	@Length(min=2)
	//@SafeHtml
	@NotBlank
	private String firstname;
	
	@Length(min=2)
	//@SafeHtml
	@NotBlank
	private String lastname;
	
	//@SafeHtml
	@NotNull
	private String dob;
	
	@Length(min=6)
	//@SafeHtml
	@Email
	@NotBlank
	private String emailAddress;
	
	//@SafeHtml
	private String company;
	
	@Length(min=5)
	//@SafeHtml
	@NotBlank
	private String streetAddress;
	
	//@SafeHtml
	private String suburb;
	
	@Length(min=4)
	//@SafeHtml
	@NotBlank
	private String postcode;
	
	@Length(min=3)
	//@SafeHtml
	@NotBlank
	private String city;
	
	@Length(min=2)
	//@SafeHtml
	@NotBlank
	private String state;
	
	@Range(min = 1)
	private long country;
	
	@Length(min=3)
	//@SafeHtml
	@NotBlank
	private String telephone;
	
	//@SafeHtml
	private String fax;
	
	private boolean newsletter=false;
	
	@Length(min=5)
	//@SafeHtml
	@NotBlank
	private String password;
	
	@Length(min=5)
	//@SafeHtml
	@NotBlank 
	private String confirmation;
	
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public long getCountry() {
		return country;
	}
	public void setCountry(long country) {
		this.country = country;
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
	public boolean getNewsletter() {
		return newsletter;
	}
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
	@Transient
	public boolean passwordsMatch() {
		return this.password.equals(this.confirmation);
	}
	
}
