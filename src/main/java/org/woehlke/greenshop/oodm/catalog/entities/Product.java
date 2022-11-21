package org.woehlke.greenshop.oodm.catalog.entities;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="products_id",columnDefinition = "INT(11)")
	private Long id;
	
	@Column(name="products_quantity",columnDefinition = "int(4)")
	private short quantity;
	
	@Column(name="products_model")
	private String model;
	
	@Column(name="products_image")
	private String image;
	
	@Column(name="products_price",columnDefinition = "decimal(15,4)",precision=15,scale=4)
	private Double price;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="products_date_added")
	private Date dateAdded;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="products_last_modified")
	private Date lastModified;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="products_date_available")
	private Date dateAvailable;
	
	@Column(name="products_weight",columnDefinition = "decimal(5,2)",precision=5,scale=2)
	private Double weight;
	
	@Column(name="products_status")
	private boolean status;
	
	@Column(name="products_tax_class_id",columnDefinition = "INT(11)")
	private Long taxClassId;
	
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="manufacturers_id")
	private Manufacturer manufacturer;
	
	@Column(name="products_ordered",columnDefinition = "INT(11)")
	private long ordered;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany( cascade = CascadeType.REFRESH)
	@JoinTable(name = "products_to_categories",
		joinColumns = @JoinColumn(name = "products_id"),
		inverseJoinColumns = @JoinColumn(name = "categories_id"))
	private List<Category> categories = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getTaxClassId() {
		return taxClassId;
	}

	public void setTaxClassId(Long taxClassId) {
		this.taxClassId = taxClassId;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public long getOrdered() {
		return ordered;
	}

	public void setOrdered(long ordered) {
		this.ordered = ordered;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateAdded == null) ? 0 : dateAdded.hashCode());
		result = prime * result
				+ ((dateAvailable == null) ? 0 : dateAvailable.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result
				+ ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (ordered ^ (ordered >>> 32));
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result
				+ ((taxClassId == null) ? 0 : taxClassId.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		Product other = (Product) obj;
		if (dateAdded == null) {
			if (other.dateAdded != null)
				return false;
		} else if (!dateAdded.equals(other.dateAdded))
			return false;
		if (dateAvailable == null) {
			if (other.dateAvailable != null)
				return false;
		} else if (!dateAvailable.equals(other.dateAvailable))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (ordered != other.ordered)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (status != other.status)
			return false;
		if (taxClassId == null) {
			if (other.taxClassId != null)
				return false;
		} else if (!taxClassId.equals(other.taxClassId))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", quantity=" + quantity +
				", model='" + model + '\'' +
				", image='" + image + '\'' +
				", price=" + price +
				", dateAdded=" + dateAdded +
				", lastModified=" + lastModified +
				", dateAvailable=" + dateAvailable +
				", weight=" + weight +
				", status=" + status +
				", taxClassId=" + taxClassId +
				", manufacturer=" + manufacturer +
				", ordered=" + ordered +
				", categories=" + categories +
				'}';
	}
}
