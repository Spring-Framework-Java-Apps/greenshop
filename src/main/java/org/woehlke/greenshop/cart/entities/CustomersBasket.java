package org.woehlke.greenshop.cart.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.woehlke.greenshop.customer.entities.Customer;


/**
 * mysql> desc customers_basket;
+-----------------------------+---------------+------+-----+---------+----------------+
| Field                       | Type          | Null | Key | Default | Extra          |
+-----------------------------+---------------+------+-----+---------+----------------+
| customers_basket_id         | int(11)       | NO   | PRI | NULL    | auto_increment |
| customers_id                | int(11)       | NO   | MUL | NULL    |                |
| products_id                 | tinytext      | NO   |     | NULL    |                |
| customers_basket_quantity   | int(2)        | NO   |     | NULL    |                |
| final_price                 | decimal(15,4) | YES  |     | NULL    |                |
| customers_basket_date_added | char(8)       | YES  |     | NULL    |                |
+-----------------------------+---------------+------+-----+---------+----------------+
 * @author tw
 *
mysql> select * from customers_basket;
+---------------------+--------------+-------------+---------------------------+-------------+-----------------------------+
| customers_basket_id | customers_id | products_id | customers_basket_quantity | final_price | customers_basket_date_added |
+---------------------+--------------+-------------+---------------------------+-------------+-----------------------------+
|                  10 |            9 | 19          |                         1 |        NULL | 20130326                    |
|                  11 |            9 | 26{3}9      |                         1 |        NULL | 20130326                    |
+---------------------+--------------+-------------+---------------------------+-------------+-----------------------------+
 *
 * 26{3}9 := http://localhost/oscommerce2/product_info.php?cPath=1_9&products_id=26 
 *           http://localhost/oscommerce2/product_info.php?products_id=26{3}9
 *           ProductId{Product Option}Option Value
 */
@Entity
@Table(name="customers_basket")
public class CustomersBasket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customers_basket_id",columnDefinition = "INT(11)")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="customers_id")
	private Customer customer;
	
	@Column(name="products_id",columnDefinition = "tinytext")
	private String productId;
	
	@Column(name="customers_basket_quantity",columnDefinition = "int(2)")
	private int quantity;
	
	@Column(name="final_price",columnDefinition = "decimal(15,4)")
	private Double finalPrice;
	
	@Column(name="customers_basket_date_added",columnDefinition = "char(8)")
	private String dateAdded;

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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Transient
	public void setDateAdded(Date now) {
		StringBuffer dateAdded = new StringBuffer();
		String year = new Integer(now.getYear()+1900).toString();
		int mymonth = now.getMonth()+1;
		String month = mymonth<10? "0"+mymonth:""+mymonth;
		int myday = now.getDay();
		String day = myday<10? "0"+myday:""+myday;
		dateAdded.append(year);
		dateAdded.append(month);
		dateAdded.append(day);
		this.dateAdded = dateAdded.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantity;
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
		CustomersBasket other = (CustomersBasket) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomersBasket [id=" + id + ", customer=" + customer
				+ ", productId=" + productId + ", quantity=" + quantity
				+ ", finalPrice=" + finalPrice + ", dateAdded=" + dateAdded
				+ "]";
	}

	@Transient
	public long getProductIdAsLong() {
		return Long.parseLong(this.productId.split("\\{")[0]);
	}

	@Transient
	public Map<Long, Long> getOptionsAndValues() {
		Map<Long, Long> optionsAndValues = new HashMap<Long,Long>();
		String left[] = this.productId.split("\\{");
		for(int i=1;i<left.length;i++){
			String right[] = left[i].split("\\}");
			Long key = Long.parseLong(right[0]);
			Long value = Long.parseLong(right[1]);
			optionsAndValues.put(key, value);
		}
		return optionsAndValues;
	}
	
}
