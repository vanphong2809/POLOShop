package com.phong.poloshop.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Price",schema = "dbo")
public class PriceEntity implements Serializable{
	private static final long serialVersionUID = -8421016593994794644L;
	@Id
	@GeneratedValue
	@Column(name="PriceId",nullable = false)
	private int priceId;
	@ManyToOne
	@JoinColumn(name="ProductId")
	@JsonIgnore
	private ProductEntity product;
	@Column(name="Price")
	private int price;
	@Column(name="DateCreated")
	private Date dateCreated;
	@Column(name="DateExpity")
	private Date dateExpiry;
	@Column(name="IsActive")
	private boolean isActive;
	
	public PriceEntity() {
		super();
	}

	public PriceEntity(int priceId, ProductEntity product, int price, Date dateCreated, Date dateExpiry,
			boolean isActive) {
		super();
		this.priceId = priceId;
		this.product = product;
		this.price = price;
		this.dateCreated = dateCreated;
		this.dateExpiry = dateExpiry;
		this.isActive = isActive;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateExpiry() {
		return dateExpiry;
	}

	public void setDateExpiry(Date dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
