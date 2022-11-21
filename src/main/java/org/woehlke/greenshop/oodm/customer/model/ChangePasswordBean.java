package org.woehlke.greenshop.oodm.customer.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class ChangePasswordBean {

	@Length(min=5)
	@SafeHtml
	@NotBlank
	private String passwordCurrent;
	
	@Length(min=5)
	@SafeHtml
	@NotBlank
	private String passwordNew;
	
	@Length(min=5)
	@SafeHtml
	@NotBlank
	private String passwordConfirmation;

	public String getPasswordCurrent() {
		return passwordCurrent;
	}
	
	public String getPasswordCurrentEncoded() {
		PasswordEncoder encoder = new Md4PasswordEncoder();
		return encoder.encode(passwordCurrent);
	}

	public void setPasswordCurrent(String passwordCurrent) {
		this.passwordCurrent = passwordCurrent;
	}

	public String getPasswordNew() {
		return passwordNew;
	}
	
	public String getPasswordNewEncoded() {
		PasswordEncoder encoder = new Md4PasswordEncoder();
		return encoder.encode(passwordNew);
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public boolean isConfirmed() {
		return passwordNew.equals(passwordConfirmation);
	}
	
		
}
