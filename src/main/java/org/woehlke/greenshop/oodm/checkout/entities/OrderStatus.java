package org.woehlke.greenshop.oodm.checkout.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.woehlke.greenshop.oodm.catalog.entities.Language;

/**
 *  
mysql> desc orders_status;
+--------------------+-------------+------+-----+---------+-------+
| Field              | Type        | Null | Key | Default | Extra |
+--------------------+-------------+------+-----+---------+-------+
| orders_status_id   | int(11)     | NO   | PRI | 0       |       |
| language_id        | int(11)     | NO   | PRI | 1       |       |
| orders_status_name | varchar(32) | NO   | MUL | NULL    |       |
| public_flag        | int(11)     | YES  |     | 1       |       |
| downloads_flag     | int(11)     | YES  |     | 0       |       |
+--------------------+-------------+------+-----+---------+-------+
5 rows in set (0.03 sec)
 *
 * @author tw
 *
 */
@Entity
@Table(name="orders_status")
@IdClass(OrderStatusId.class)
public class OrderStatus {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orders_status_id",columnDefinition = "INT(11)")
	private Long id;
	
	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;
	
	@NotNull
	@Column(name="orders_status_name",columnDefinition = "varchar(255)")
	private String ordersStatusName;
	
	@Null
	@Column(name="public_flag",columnDefinition = "int(11)")
	private Long public_flag=1L;
	
	@Null
	@Column(name="downloads_flag",columnDefinition = "int(11)")
	private Long downloads_flag=0L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getOrdersStatusName() {
		return ordersStatusName;
	}

	public void setOrdersStatusName(String ordersStatusName) {
		this.ordersStatusName = ordersStatusName;
	}

	public Long getPublic_flag() {
		return public_flag;
	}

	public void setPublic_flag(Long public_flag) {
		this.public_flag = public_flag;
	}

	public Long getDownloads_flag() {
		return downloads_flag;
	}

	public void setDownloads_flag(Long downloads_flag) {
		this.downloads_flag = downloads_flag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((downloads_flag == null) ? 0 : downloads_flag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime
				* result
				+ ((ordersStatusName == null) ? 0 : ordersStatusName.hashCode());
		result = prime * result
				+ ((public_flag == null) ? 0 : public_flag.hashCode());
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
		OrderStatus other = (OrderStatus) obj;
		if (downloads_flag == null) {
			if (other.downloads_flag != null)
				return false;
		} else if (!downloads_flag.equals(other.downloads_flag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (ordersStatusName == null) {
			if (other.ordersStatusName != null)
				return false;
		} else if (!ordersStatusName.equals(other.ordersStatusName))
			return false;
		if (public_flag == null) {
			if (other.public_flag != null)
				return false;
		} else if (!public_flag.equals(other.public_flag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderStatus [id=" + id + ", language=" + language
				+ ", ordersStatusName=" + ordersStatusName + ", public_flag="
				+ public_flag + ", downloads_flag=" + downloads_flag + "]";
	}
	
	
}
