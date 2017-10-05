package cz.etn.etnshop.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Entity class of Product.
 */
@Indexed
@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -2739622030641073946L;

	/**
	 * ID.
	 */
	private int id;

	/**
	 * Product name.
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String name;

	/**
	 * Product serial number.
	 */
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String serialNumber;

	/**
	 * Gets ID.
	 * @return id of product.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * Sets ID.
	 * @param id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets name.
	 * @return name of product
	 */
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 * @param name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets serial number.
	 * @return serial number of product
	 */
	@Column(name = "serial_number", nullable = false)
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Sets serial number.
	 * @param serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
