package org.woehlke.greenshop.checkout.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.woehlke.greenshop.customer.entities.AddressFormat;
import org.woehlke.greenshop.customer.entities.Customer;

/**
 * 
mysql> desc orders;
+-----------------------------+---------------+------+-----+---------+----------------+
| Field                       | Type          | Null | Key | Default | Extra          |
+-----------------------------+---------------+------+-----+---------+----------------+
| orders_id                   | int(11)       | NO   | PRI | NULL    | auto_increment |
| customers_id                | int(11)       | NO   | MUL | NULL    |                |
| customers_name              | varchar(255)  | NO   |     | NULL    |                |
| customers_company           | varchar(255)  | YES  |     | NULL    |                |
| customers_street_address    | varchar(255)  | NO   |     | NULL    |                |
| customers_suburb            | varchar(255)  | YES  |     | NULL    |                |
| customers_city              | varchar(255)  | NO   |     | NULL    |                |
| customers_postcode          | varchar(255)  | NO   |     | NULL    |                |
| customers_state             | varchar(255)  | YES  |     | NULL    |                |
| customers_country           | varchar(255)  | NO   |     | NULL    |                |
| customers_telephone         | varchar(255)  | NO   |     | NULL    |                |
| customers_email_address     | varchar(255)  | NO   |     | NULL    |                |
| customers_address_format_id | int(5)        | NO   |     | NULL    |                |
| delivery_name               | varchar(255)  | NO   |     | NULL    |                |
| delivery_company            | varchar(255)  | YES  |     | NULL    |                |
| delivery_street_address     | varchar(255)  | NO   |     | NULL    |                |
| delivery_suburb             | varchar(255)  | YES  |     | NULL    |                |
| delivery_city               | varchar(255)  | NO   |     | NULL    |                |
| delivery_postcode           | varchar(255)  | NO   |     | NULL    |                |
| delivery_state              | varchar(255)  | YES  |     | NULL    |                |
| delivery_country            | varchar(255)  | NO   |     | NULL    |                |
| delivery_address_format_id  | int(5)        | NO   |     | NULL    |                |
| billing_name                | varchar(255)  | NO   |     | NULL    |                |
| billing_company             | varchar(255)  | YES  |     | NULL    |                |
| billing_street_address      | varchar(255)  | NO   |     | NULL    |                |
| billing_suburb              | varchar(255)  | YES  |     | NULL    |                |
| billing_city                | varchar(255)  | NO   |     | NULL    |                |
| billing_postcode            | varchar(255)  | NO   |     | NULL    |                |
| billing_state               | varchar(255)  | YES  |     | NULL    |                |
| billing_country             | varchar(255)  | NO   |     | NULL    |                |
| billing_address_format_id   | int(5)        | NO   |     | NULL    |                |
| payment_method              | varchar(255)  | NO   |     | NULL    |                |
| cc_type                     | varchar(20)   | YES  |     | NULL    |                |
| cc_owner                    | varchar(255)  | YES  |     | NULL    |                |
| cc_number                   | varchar(32)   | YES  |     | NULL    |                |
| cc_expires                  | varchar(4)    | YES  |     | NULL    |                |
| last_modified               | datetime      | YES  |     | NULL    |                |
| date_purchased              | datetime      | YES  |     | NULL    |                |
| orders_status               | int(5)        | NO   |     | NULL    |                |
| orders_date_finished        | datetime      | YES  |     | NULL    |                |
| currency                    | char(3)       | YES  |     | NULL    |                |
| currency_value              | decimal(14,6) | YES  |     | NULL    |                |
+-----------------------------+---------------+------+-----+---------+----------------+
42 rows in set (0.00 sec)
 * 
 * @author tw
 *
 */
@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orders_id",columnDefinition = "INT(11)")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="customers_id")
	private Customer customer;
	
	@NotNull
	@Column(name="customers_name",columnDefinition = "varchar(255)")
	private String customersName; 
	
	@Column(name="customers_company",columnDefinition = "varchar(255)")
	private String customersCompany; 	
	
	@NotNull
	@Column(name="customers_street_address",columnDefinition = "varchar(255)")
	private String customersStreetAddress; 	
	
	@Column(name="customers_suburb",columnDefinition = "varchar(255)")
	private String customersSuburb;	
	
	@NotNull
	@Column(name="customers_city",columnDefinition = "varchar(255)")
	private String customersCity;		
	
	@NotNull
	@Column(name="customers_postcode",columnDefinition = "varchar(255)")
	private String customersPostcode;	
	
	@Column(name="customers_state",columnDefinition = "varchar(255)")
	private String customersState;	
	
	@NotNull
	@Column(name="customers_country",columnDefinition = "varchar(255)")
	private String customersCountry;
	
	@NotNull
	@Column(name="customers_telephone",columnDefinition = "varchar(255)")
	private String customersTelephone;
	
	@NotNull
	@Column(name="customers_email_address",columnDefinition = "varchar(255)")
	private String customersEmailAddress;	
	
	@ManyToOne
	@JoinColumn(name="customers_address_format_id")
	private AddressFormat customersAddressFormat;
	
	@NotNull
	@Column(name="delivery_name",columnDefinition = "varchar(255)")
	private String deliveryName; 
	
	
	@Column(name="delivery_company",columnDefinition = "varchar(255)")
	private String deliveryCompany; 	
	
	@NotNull
	@Column(name="delivery_street_address",columnDefinition = "varchar(255)")
	private String deliveryStreetAddress; 	
	
	
	@Column(name="delivery_suburb",columnDefinition = "varchar(255)")
	private String deliverySuburb;	
	
	@NotNull
	@Column(name="delivery_city",columnDefinition = "varchar(255)")
	private String deliveryCity;		
	
	@NotNull
	@Column(name="delivery_postcode",columnDefinition = "varchar(255)")
	private String deliveryPostcode;	
	
	
	@Column(name="delivery_state",columnDefinition = "varchar(255)")
	private String deliveryState;	
	
	@NotNull
	@Column(name="delivery_country",columnDefinition = "varchar(255)")
	private String deliveryCountry;
	
	@ManyToOne
	@JoinColumn(name="delivery_address_format_id")
	private AddressFormat deliveryAddressFormat;
	
	@NotNull
	@Column(name="billing_name",columnDefinition = "varchar(255)")
	private String billingName; 
	
	
	@Column(name="billing_company",columnDefinition = "varchar(255)")
	private String billingCompany; 	
	
	@NotNull
	@Column(name="billing_street_address",columnDefinition = "varchar(255)")
	private String billingStreetAddress; 	
	
	
	@Column(name="billing_suburb",columnDefinition = "varchar(255)")
	private String billingSuburb;	
	
	@NotNull
	@Column(name="billing_city",columnDefinition = "varchar(255)")
	private String billingCity;		
	
	@NotNull
	@Column(name="billing_postcode",columnDefinition = "varchar(255)")
	private String billingPostcode;	
	
	@Column(name="billing_state",columnDefinition = "varchar(255)")
	private String billingState;	
	
	@NotNull
	@Column(name="billing_country",columnDefinition = "varchar(255)")
	private String billingCountry;
	
	@ManyToOne
	@JoinColumn(name="billing_address_format_id")
	private AddressFormat billingAddressFormat;
	
	@NotNull
	@Column(name="payment_method",columnDefinition = "varchar(255)")
	private String paymentMethod;
	
	
	@Column(name="cc_type",columnDefinition = "varchar(20)")
	private String ccType;	
	
	
	@Column(name="cc_owner",columnDefinition = "varchar(255)")
	private String ccOwner;	
	
	
	@Column(name="cc_number",columnDefinition = "varchar(32)")
	private String ccNumber;
	
	
	@Column(name="cc_expires",columnDefinition = "varchar(4)")
	private String ccExpires;	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified",columnDefinition = "datetime")
	private Date lastModified;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_purchased",columnDefinition = "datetime")
	private Date datePurchased;
	
	@NotNull
	@Column(name="orders_status",columnDefinition = "int(5)")
	private long ordersStatus;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="orders_date_finished",columnDefinition = "datetime")
	private Date ordersDateFinished;
	
	
	@Column(name="currency",columnDefinition = "char(3)")
	private String currency;
	
	
	@Column(name="currency_value",columnDefinition = "decimal(14,6)")
	private Double currencyValue;

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

	public String getCustomersName() {
		return customersName;
	}

	public void setCustomersName(String customersName) {
		this.customersName = customersName;
	}

	public String getCustomersCompany() {
		return customersCompany;
	}

	public void setCustomersCompany(String customersCompany) {
		this.customersCompany = customersCompany;
	}

	public String getCustomersStreetAddress() {
		return customersStreetAddress;
	}

	public void setCustomersStreetAddress(String customersStreetAddress) {
		this.customersStreetAddress = customersStreetAddress;
	}

	public String getCustomersSuburb() {
		return customersSuburb;
	}

	public void setCustomersSuburb(String customersSuburb) {
		this.customersSuburb = customersSuburb;
	}

	public String getCustomersCity() {
		return customersCity;
	}

	public void setCustomersCity(String customersCity) {
		this.customersCity = customersCity;
	}

	public String getCustomersPostcode() {
		return customersPostcode;
	}

	public void setCustomersPostcode(String customersPostcode) {
		this.customersPostcode = customersPostcode;
	}

	public String getCustomersState() {
		return customersState;
	}

	public void setCustomersState(String customersState) {
		this.customersState = customersState;
	}

	public String getCustomersCountry() {
		return customersCountry;
	}

	public void setCustomersCountry(String customersCountry) {
		this.customersCountry = customersCountry;
	}

	public String getCustomersTelephone() {
		return customersTelephone;
	}

	public void setCustomersTelephone(String customersTelephone) {
		this.customersTelephone = customersTelephone;
	}

	public String getCustomersEmailAddress() {
		return customersEmailAddress;
	}

	public void setCustomersEmailAddress(String customersEmailAddress) {
		this.customersEmailAddress = customersEmailAddress;
	}

	public AddressFormat getCustomersAddressFormat() {
		return customersAddressFormat;
	}

	public void setCustomersAddressFormat(AddressFormat customersAddressFormat) {
		this.customersAddressFormat = customersAddressFormat;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryCompany() {
		return deliveryCompany;
	}

	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}

	public String getDeliveryStreetAddress() {
		return deliveryStreetAddress;
	}

	public void setDeliveryStreetAddress(String deliveryStreetAddress) {
		this.deliveryStreetAddress = deliveryStreetAddress;
	}

	public String getDeliverySuburb() {
		return deliverySuburb;
	}

	public void setDeliverySuburb(String deliverySuburb) {
		this.deliverySuburb = deliverySuburb;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryPostcode() {
		return deliveryPostcode;
	}

	public void setDeliveryPostcode(String deliveryPostcode) {
		this.deliveryPostcode = deliveryPostcode;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	public AddressFormat getDeliveryAddressFormat() {
		return deliveryAddressFormat;
	}

	public void setDeliveryAddressFormat(AddressFormat deliveryAddressFormat) {
		this.deliveryAddressFormat = deliveryAddressFormat;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getBillingCompany() {
		return billingCompany;
	}

	public void setBillingCompany(String billingCompany) {
		this.billingCompany = billingCompany;
	}

	public String getBillingStreetAddress() {
		return billingStreetAddress;
	}

	public void setBillingStreetAddress(String billingStreetAddress) {
		this.billingStreetAddress = billingStreetAddress;
	}

	public String getBillingSuburb() {
		return billingSuburb;
	}

	public void setBillingSuburb(String billingSuburb) {
		this.billingSuburb = billingSuburb;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingPostcode() {
		return billingPostcode;
	}

	public void setBillingPostcode(String billingPostcode) {
		this.billingPostcode = billingPostcode;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public AddressFormat getBillingAddressFormat() {
		return billingAddressFormat;
	}

	public void setBillingAddressFormat(AddressFormat billingAddressFormat) {
		this.billingAddressFormat = billingAddressFormat;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getCcOwner() {
		return ccOwner;
	}

	public void setCcOwner(String ccOwner) {
		this.ccOwner = ccOwner;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpires() {
		return ccExpires;
	}

	public void setCcExpires(String ccExpires) {
		this.ccExpires = ccExpires;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	public long getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(long ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public Date getOrdersDateFinished() {
		return ordersDateFinished;
	}

	public void setOrdersDateFinished(Date ordersDateFinished) {
		this.ordersDateFinished = ordersDateFinished;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(Double currencyValue) {
		this.currencyValue = currencyValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((billingAddressFormat == null) ? 0 : billingAddressFormat
						.hashCode());
		result = prime * result
				+ ((billingCity == null) ? 0 : billingCity.hashCode());
		result = prime * result
				+ ((billingCompany == null) ? 0 : billingCompany.hashCode());
		result = prime * result
				+ ((billingCountry == null) ? 0 : billingCountry.hashCode());
		result = prime * result
				+ ((billingName == null) ? 0 : billingName.hashCode());
		result = prime * result
				+ ((billingPostcode == null) ? 0 : billingPostcode.hashCode());
		result = prime * result
				+ ((billingState == null) ? 0 : billingState.hashCode());
		result = prime
				* result
				+ ((billingStreetAddress == null) ? 0 : billingStreetAddress
						.hashCode());
		result = prime * result
				+ ((billingSuburb == null) ? 0 : billingSuburb.hashCode());
		result = prime * result
				+ ((ccExpires == null) ? 0 : ccExpires.hashCode());
		result = prime * result
				+ ((ccNumber == null) ? 0 : ccNumber.hashCode());
		result = prime * result + ((ccOwner == null) ? 0 : ccOwner.hashCode());
		result = prime * result + ((ccType == null) ? 0 : ccType.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((currencyValue == null) ? 0 : currencyValue.hashCode());
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime
				* result
				+ ((customersAddressFormat == null) ? 0
						: customersAddressFormat.hashCode());
		result = prime * result
				+ ((customersCity == null) ? 0 : customersCity.hashCode());
		result = prime
				* result
				+ ((customersCompany == null) ? 0 : customersCompany.hashCode());
		result = prime
				* result
				+ ((customersCountry == null) ? 0 : customersCountry.hashCode());
		result = prime
				* result
				+ ((customersEmailAddress == null) ? 0 : customersEmailAddress
						.hashCode());
		result = prime * result
				+ ((customersName == null) ? 0 : customersName.hashCode());
		result = prime
				* result
				+ ((customersPostcode == null) ? 0 : customersPostcode
						.hashCode());
		result = prime * result
				+ ((customersState == null) ? 0 : customersState.hashCode());
		result = prime
				* result
				+ ((customersStreetAddress == null) ? 0
						: customersStreetAddress.hashCode());
		result = prime * result
				+ ((customersSuburb == null) ? 0 : customersSuburb.hashCode());
		result = prime
				* result
				+ ((customersTelephone == null) ? 0 : customersTelephone
						.hashCode());
		result = prime * result
				+ ((datePurchased == null) ? 0 : datePurchased.hashCode());
		result = prime
				* result
				+ ((deliveryAddressFormat == null) ? 0 : deliveryAddressFormat
						.hashCode());
		result = prime * result
				+ ((deliveryCity == null) ? 0 : deliveryCity.hashCode());
		result = prime * result
				+ ((deliveryCompany == null) ? 0 : deliveryCompany.hashCode());
		result = prime * result
				+ ((deliveryCountry == null) ? 0 : deliveryCountry.hashCode());
		result = prime * result
				+ ((deliveryName == null) ? 0 : deliveryName.hashCode());
		result = prime
				* result
				+ ((deliveryPostcode == null) ? 0 : deliveryPostcode.hashCode());
		result = prime * result
				+ ((deliveryState == null) ? 0 : deliveryState.hashCode());
		result = prime
				* result
				+ ((deliveryStreetAddress == null) ? 0 : deliveryStreetAddress
						.hashCode());
		result = prime * result
				+ ((deliverySuburb == null) ? 0 : deliverySuburb.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime
				* result
				+ ((ordersDateFinished == null) ? 0 : ordersDateFinished
						.hashCode());
		result = prime * result + (int) (ordersStatus ^ (ordersStatus >>> 32));
		result = prime * result
				+ ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
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
		Order other = (Order) obj;
		if (billingAddressFormat == null) {
			if (other.billingAddressFormat != null)
				return false;
		} else if (!billingAddressFormat.equals(other.billingAddressFormat))
			return false;
		if (billingCity == null) {
			if (other.billingCity != null)
				return false;
		} else if (!billingCity.equals(other.billingCity))
			return false;
		if (billingCompany == null) {
			if (other.billingCompany != null)
				return false;
		} else if (!billingCompany.equals(other.billingCompany))
			return false;
		if (billingCountry == null) {
			if (other.billingCountry != null)
				return false;
		} else if (!billingCountry.equals(other.billingCountry))
			return false;
		if (billingName == null) {
			if (other.billingName != null)
				return false;
		} else if (!billingName.equals(other.billingName))
			return false;
		if (billingPostcode == null) {
			if (other.billingPostcode != null)
				return false;
		} else if (!billingPostcode.equals(other.billingPostcode))
			return false;
		if (billingState == null) {
			if (other.billingState != null)
				return false;
		} else if (!billingState.equals(other.billingState))
			return false;
		if (billingStreetAddress == null) {
			if (other.billingStreetAddress != null)
				return false;
		} else if (!billingStreetAddress.equals(other.billingStreetAddress))
			return false;
		if (billingSuburb == null) {
			if (other.billingSuburb != null)
				return false;
		} else if (!billingSuburb.equals(other.billingSuburb))
			return false;
		if (ccExpires == null) {
			if (other.ccExpires != null)
				return false;
		} else if (!ccExpires.equals(other.ccExpires))
			return false;
		if (ccNumber == null) {
			if (other.ccNumber != null)
				return false;
		} else if (!ccNumber.equals(other.ccNumber))
			return false;
		if (ccOwner == null) {
			if (other.ccOwner != null)
				return false;
		} else if (!ccOwner.equals(other.ccOwner))
			return false;
		if (ccType == null) {
			if (other.ccType != null)
				return false;
		} else if (!ccType.equals(other.ccType))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (currencyValue == null) {
			if (other.currencyValue != null)
				return false;
		} else if (!currencyValue.equals(other.currencyValue))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customersAddressFormat == null) {
			if (other.customersAddressFormat != null)
				return false;
		} else if (!customersAddressFormat.equals(other.customersAddressFormat))
			return false;
		if (customersCity == null) {
			if (other.customersCity != null)
				return false;
		} else if (!customersCity.equals(other.customersCity))
			return false;
		if (customersCompany == null) {
			if (other.customersCompany != null)
				return false;
		} else if (!customersCompany.equals(other.customersCompany))
			return false;
		if (customersCountry == null) {
			if (other.customersCountry != null)
				return false;
		} else if (!customersCountry.equals(other.customersCountry))
			return false;
		if (customersEmailAddress == null) {
			if (other.customersEmailAddress != null)
				return false;
		} else if (!customersEmailAddress.equals(other.customersEmailAddress))
			return false;
		if (customersName == null) {
			if (other.customersName != null)
				return false;
		} else if (!customersName.equals(other.customersName))
			return false;
		if (customersPostcode == null) {
			if (other.customersPostcode != null)
				return false;
		} else if (!customersPostcode.equals(other.customersPostcode))
			return false;
		if (customersState == null) {
			if (other.customersState != null)
				return false;
		} else if (!customersState.equals(other.customersState))
			return false;
		if (customersStreetAddress == null) {
			if (other.customersStreetAddress != null)
				return false;
		} else if (!customersStreetAddress.equals(other.customersStreetAddress))
			return false;
		if (customersSuburb == null) {
			if (other.customersSuburb != null)
				return false;
		} else if (!customersSuburb.equals(other.customersSuburb))
			return false;
		if (customersTelephone == null) {
			if (other.customersTelephone != null)
				return false;
		} else if (!customersTelephone.equals(other.customersTelephone))
			return false;
		if (datePurchased == null) {
			if (other.datePurchased != null)
				return false;
		} else if (!datePurchased.equals(other.datePurchased))
			return false;
		if (deliveryAddressFormat == null) {
			if (other.deliveryAddressFormat != null)
				return false;
		} else if (!deliveryAddressFormat.equals(other.deliveryAddressFormat))
			return false;
		if (deliveryCity == null) {
			if (other.deliveryCity != null)
				return false;
		} else if (!deliveryCity.equals(other.deliveryCity))
			return false;
		if (deliveryCompany == null) {
			if (other.deliveryCompany != null)
				return false;
		} else if (!deliveryCompany.equals(other.deliveryCompany))
			return false;
		if (deliveryCountry == null) {
			if (other.deliveryCountry != null)
				return false;
		} else if (!deliveryCountry.equals(other.deliveryCountry))
			return false;
		if (deliveryName == null) {
			if (other.deliveryName != null)
				return false;
		} else if (!deliveryName.equals(other.deliveryName))
			return false;
		if (deliveryPostcode == null) {
			if (other.deliveryPostcode != null)
				return false;
		} else if (!deliveryPostcode.equals(other.deliveryPostcode))
			return false;
		if (deliveryState == null) {
			if (other.deliveryState != null)
				return false;
		} else if (!deliveryState.equals(other.deliveryState))
			return false;
		if (deliveryStreetAddress == null) {
			if (other.deliveryStreetAddress != null)
				return false;
		} else if (!deliveryStreetAddress.equals(other.deliveryStreetAddress))
			return false;
		if (deliverySuburb == null) {
			if (other.deliverySuburb != null)
				return false;
		} else if (!deliverySuburb.equals(other.deliverySuburb))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (ordersDateFinished == null) {
			if (other.ordersDateFinished != null)
				return false;
		} else if (!ordersDateFinished.equals(other.ordersDateFinished))
			return false;
		if (ordersStatus != other.ordersStatus)
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer
				+ ", customersName=" + customersName + ", customersCompany="
				+ customersCompany + ", customersStreetAddress="
				+ customersStreetAddress + ", customersSuburb="
				+ customersSuburb + ", customersCity=" + customersCity
				+ ", customersPostcode=" + customersPostcode
				+ ", customersState=" + customersState + ", customersCountry="
				+ customersCountry + ", customersTelephone="
				+ customersTelephone + ", customersEmailAddress="
				+ customersEmailAddress + ", customersAddressFormat="
				+ customersAddressFormat + ", deliveryName=" + deliveryName
				+ ", deliveryCompany=" + deliveryCompany
				+ ", deliveryStreetAddress=" + deliveryStreetAddress
				+ ", deliverySuburb=" + deliverySuburb + ", deliveryCity="
				+ deliveryCity + ", deliveryPostcode=" + deliveryPostcode
				+ ", deliveryState=" + deliveryState + ", deliveryCountry="
				+ deliveryCountry + ", deliveryAddressFormat="
				+ deliveryAddressFormat + ", billingName=" + billingName
				+ ", billingCompany=" + billingCompany
				+ ", billingStreetAddress=" + billingStreetAddress
				+ ", billingSuburb=" + billingSuburb + ", billingCity="
				+ billingCity + ", billingPostcode=" + billingPostcode
				+ ", billingState=" + billingState + ", billingCountry="
				+ billingCountry + ", billingAddressFormat="
				+ billingAddressFormat + ", paymentMethod=" + paymentMethod
				+ ", ccType=" + ccType + ", ccOwner=" + ccOwner + ", ccNumber="
				+ ccNumber + ", ccExpires=" + ccExpires + ", lastModified="
				+ lastModified + ", datePurchased=" + datePurchased
				+ ", ordersStatus=" + ordersStatus + ", ordersDateFinished="
				+ ordersDateFinished + ", currency=" + currency
				+ ", currencyValue=" + currencyValue + "]";
	}

	

}
