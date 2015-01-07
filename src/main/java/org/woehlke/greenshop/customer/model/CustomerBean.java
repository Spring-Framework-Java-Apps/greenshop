package org.woehlke.greenshop.customer.model;

import org.woehlke.greenshop.customer.entities.Customer;
import org.woehlke.greenshop.customer.entities.CustomerInfo;

/**
 * Created by tw on 07.01.15.
 */
public class CustomerBean {

    private Customer customer;
    private CustomerInfo customerInfo;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerBean)) return false;

        CustomerBean that = (CustomerBean) o;

        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (customerInfo != null ? !customerInfo.equals(that.customerInfo) : that.customerInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customer != null ? customer.hashCode() : 0;
        result = 31 * result + (customerInfo != null ? customerInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerBean{" +
                "customer=" + customer +
                ", customerInfo=" + customerInfo +
                '}';
    }
}
