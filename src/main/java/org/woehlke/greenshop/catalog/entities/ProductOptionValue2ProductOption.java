package org.woehlke.greenshop.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="products_options_values_to_products_options")
public class ProductOptionValue2ProductOption {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="products_options_values_to_products_options_id",columnDefinition = "INT(11)")
	private Long id;
	
	@NotNull
	@Column(name="products_options_id",columnDefinition = "INT(11)")
	private long optionId;

	@NotNull
	@Column(name="products_options_values_id",columnDefinition = "INT(11)")
	private long valueId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getValueId() {
		return valueId;
	}

	public void setValueId(long valueId) {
		this.valueId = valueId;
	}

	@Override
	public String toString() {
		return "ProductOptionValue2ProductOption [id=" + id + ", optionId="
				+ optionId + ", valueId=" + valueId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (optionId ^ (optionId >>> 32));
		result = prime * result + (int) (valueId ^ (valueId >>> 32));
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
		ProductOptionValue2ProductOption other = (ProductOptionValue2ProductOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optionId != other.optionId)
			return false;
		if (valueId != other.valueId)
			return false;
		return true;
	}
	
	
}
