package org.woehlke.greenshop.checkout.model;

public class CheckoutBean {

	private AddressBean customersAddress;
	private AddressBean shippingAddress;
	private AddressBean paymentAddress;
	public AddressBean getCustomersAddress() {
		return customersAddress;
	}
	public void setCustomersAddress(AddressBean customersAddress) {
		this.customersAddress = customersAddress;
	}
	public AddressBean getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(AddressBean shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public AddressBean getPaymentAddress() {
		return paymentAddress;
	}
	public void setPaymentAddress(AddressBean paymentAddress) {
		this.paymentAddress = paymentAddress;
	}
	
	
}
