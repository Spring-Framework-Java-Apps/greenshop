package org.woehlke.greenshop.oodm.checkout.model;


import java.io.Serializable;

import javax.validation.constraints.Pattern;

//import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class AddressBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Pattern(regexp="m|f") private String gender;

	//@SafeHtml private String firstname;
	
	//@SafeHtml private String lastname;
	
	//@SafeHtml private String company;
	
	//@SafeHtml private String streetAddress;
	
	//@SafeHtml private String suburb;
	
	//@SafeHtml private String postcode;
	
	//@SafeHtml private String city;
	
	//@SafeHtml private String state;
	
	private long countryId;

	private String countryName;
	
	private long choosenAddressId;
	
	/**
	 * check if Form is used at all. If not, is is empty in all fields.
	 * otherwise some of these fields are mandatory.
	 * @return
	 */
	public boolean isFormEmpty(){
		if(!firstname.isEmpty()){ return false; }
		if(!lastname.isEmpty()){ return false; }
		if(!company.isEmpty()){ return false; }
		if(!streetAddress.isEmpty()){ return false; }
		if(!suburb.isEmpty()){ return false; }
		if(!city.isEmpty()){ return false; }
		if(!postcode.isEmpty()){ return false; }
		if(!state.isEmpty()){ return false; }
		if(countryId>0){ return false; }
		return true;
	}
	
	public void validate(BindingResult result,final String object){
		if(firstname.isEmpty()){ result.addError(new FieldError(object,"firstname","must not be empty")); }
		if(lastname.isEmpty()){ result.addError(new FieldError(object,"lastname","must not be empty")); }
		if(streetAddress.isEmpty()){ result.addError(new FieldError(object,"streetAddress","must not be empty")); }
		if(city.isEmpty()){ result.addError(new FieldError(object,"city","must not be empty")); }
		if(postcode.isEmpty()){ result.addError(new FieldError(object,"postcode","must not be empty")); }
		if(state.isEmpty()){ result.addError(new FieldError(object,"state","must not be empty")); }
		if(firstname.length()<2){
			result.addError(new FieldError(object,"firstname","must contain a minimum of 2 characters."));
		}
		if(lastname.length()<2){
			result.addError(new FieldError(object,"lastname","must contain a minimum of 2 characters."));
		}
		if(streetAddress.length()<6){
			result.addError(new FieldError(object,"streetAddress","must contain a minimum of 6 characters."));
		}
		if(city.length()<3){
			result.addError(new FieldError(object,"city","must contain a minimum of 3 characters."));
		}
		if(postcode.length()<4){
			result.addError(new FieldError(object,"postcode","must contain a minimum of 4 characters."));
		}
		if(state.length()<2){
			result.addError(new FieldError(object,"state","must contain a minimum of 2 characters."));
		}
	}

	public String getFormattedAddress(){
		return firstname+" "+lastname+"<br/>"+streetAddress+"<br/>"+postcode+" "+city+"<br/>"+countryName;
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

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public long getChoosenAddressId() {
		return choosenAddressId;
	}

	public void setChoosenAddressId(long choosenAddressId) {
		this.choosenAddressId = choosenAddressId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + (int) (countryId ^ (countryId >>> 32));
		result = prime * result
				+ ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result
				+ ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((suburb == null) ? 0 : suburb.hashCode());
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
		AddressBean other = (AddressBean) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (countryId != other.countryId)
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (suburb == null) {
			if (other.suburb != null)
				return false;
		} else if (!suburb.equals(other.suburb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressBean [gender=" + gender + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", company=" + company
				+ ", streetAddress=" + streetAddress + ", suburb=" + suburb
				+ ", postcode=" + postcode + ", city=" + city + ", state="
				+ state + ", countryId=" + countryId + ", countryName="
				+ countryName + ", choosenAddressId=" + choosenAddressId + "]";
	}

}
