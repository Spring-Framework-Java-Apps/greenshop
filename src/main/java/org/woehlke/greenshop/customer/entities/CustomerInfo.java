package org.woehlke.greenshop.customer.entities;

import javax.persistence.*;
import java.util.Date;

/**
 mysql> desc customers_info;
 +-------------------------------------------+----------+------+-----+---------+-------+
 | Field                                     | Type     | Null | Key | Default | Extra |
 +-------------------------------------------+----------+------+-----+---------+-------+
 | customers_info_id                         | int(11)  | NO   | PRI | NULL    |       |
 | customers_info_date_of_last_logon         | datetime | YES  |     | NULL    |       |
 | customers_info_number_of_logons           | int(5)   | YES  |     | NULL    |       |
 | customers_info_date_account_created       | datetime | YES  |     | NULL    |       |
 | customers_info_date_account_last_modified | datetime | YES  |     | NULL    |       |
 | global_product_notifications              | int(1)   | YES  |     | 0       |       |
 | password_reset_key                        | char(40) | YES  |     | NULL    |       |
 | password_reset_date                       | datetime | YES  |     | NULL    |       |
 +-------------------------------------------+----------+------+-----+---------+-------+
 */
@Entity
@Table(name="customers_info")
public class CustomerInfo {

    @Id
    @Column(name="customers_info_id",columnDefinition = "int(11)")
    private Long id;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="customers_info_date_of_last_logon",columnDefinition = "datetime")
    private Date lastLogin;

    @Column(name="customers_info_number_of_logons",columnDefinition = "int(5)")
    private Integer numberOfLogons;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="customers_info_date_account_created",columnDefinition = "datetime")
    private Date accountCreated;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="customers_info_date_account_last_modified",columnDefinition = "datetime")
    private Date accountLastModified;

    @Column(name="global_product_notifications",columnDefinition = "int(1)")
    private Integer globalProductNotifications;

    @Column(name="password_reset_key",columnDefinition = "char(40)")
    private String passwordResetKey;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="password_reset_date",columnDefinition = "datetime")
    private Date passwordResetDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getNumberOfLogons() {
        return numberOfLogons;
    }

    public void setNumberOfLogons(Integer numberOfLogons) {
        this.numberOfLogons = numberOfLogons;
    }

    public Date getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(Date accountCreated) {
        this.accountCreated = accountCreated;
    }

    public Date getAccountLastModified() {
        return accountLastModified;
    }

    public void setAccountLastModified(Date accountLastModified) {
        this.accountLastModified = accountLastModified;
    }

    public boolean getGlobalProductNotifications() {
        if(globalProductNotifications==null) return false;
        return globalProductNotifications!=0;
    }

    public void setGlobalProductNotifications(boolean globalProductNotifications) {
        this.globalProductNotifications = globalProductNotifications?1:0;
    }

    public String getPasswordResetKey() {
        return passwordResetKey;
    }

    public void setPasswordResetKey(String passwordResetKey) {
        this.passwordResetKey = passwordResetKey;
    }

    public Date getPasswordResetDate() {
        return passwordResetDate;
    }

    public void setPasswordResetDate(Date passwordResetDate) {
        this.passwordResetDate = passwordResetDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerInfo)) return false;

        CustomerInfo that = (CustomerInfo) o;

        if (accountCreated != null ? !accountCreated.equals(that.accountCreated) : that.accountCreated != null)
            return false;
        if (accountLastModified != null ? !accountLastModified.equals(that.accountLastModified) : that.accountLastModified != null)
            return false;
        if (globalProductNotifications != null ? !globalProductNotifications.equals(that.globalProductNotifications) : that.globalProductNotifications != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lastLogin != null ? !lastLogin.equals(that.lastLogin) : that.lastLogin != null) return false;
        if (numberOfLogons != null ? !numberOfLogons.equals(that.numberOfLogons) : that.numberOfLogons != null)
            return false;
        if (passwordResetDate != null ? !passwordResetDate.equals(that.passwordResetDate) : that.passwordResetDate != null)
            return false;
        if (passwordResetKey != null ? !passwordResetKey.equals(that.passwordResetKey) : that.passwordResetKey != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (numberOfLogons != null ? numberOfLogons.hashCode() : 0);
        result = 31 * result + (accountCreated != null ? accountCreated.hashCode() : 0);
        result = 31 * result + (accountLastModified != null ? accountLastModified.hashCode() : 0);
        result = 31 * result + (globalProductNotifications != null ? globalProductNotifications.hashCode() : 0);
        result = 31 * result + (passwordResetKey != null ? passwordResetKey.hashCode() : 0);
        result = 31 * result + (passwordResetDate != null ? passwordResetDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "id=" + id +
                ", lastLogin=" + lastLogin +
                ", numberOfLogons=" + numberOfLogons +
                ", accountCreated=" + accountCreated +
                ", accountLastModified=" + accountLastModified +
                ", globalProductNotifications=" + globalProductNotifications +
                ", passwordResetKey='" + passwordResetKey + '\'' +
                ", passwordResetDate=" + passwordResetDate +
                '}';
    }
}
