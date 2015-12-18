package org.woehlke.greenshop.oodm.admin.entities;

import javax.persistence.*;

/**
 mysql> desc administrators;
 +---------------+--------------+------+-----+---------+----------------+
 | Field         | Type         | Null | Key | Default | Extra          |
 +---------------+--------------+------+-----+---------+----------------+
 | id            | int(11)      | NO   | PRI | NULL    | auto_increment |
 | user_name     | varchar(255) | NO   |     | NULL    |                |
 | user_password | varchar(60)  | NO   |     | NULL    |                |
 +---------------+--------------+------+-----+---------+----------------+
 */
@Entity
@Table(name="administrators")
public class Administrator {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",columnDefinition = "INT(11)")
    private Long id;

    @Column(name="user_name",columnDefinition = "varchar(255)", length = 255, nullable = false)
    private String userName;

    @Column(name="user_password",columnDefinition = "varchar(60)", length = 60, nullable = false)
    private String userPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrator)) return false;

        Administrator that = (Administrator) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
