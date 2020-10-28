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

@Entity
@Table(name = "PRODUCT_DISCOUNT", schema = "dbo")
public class PromotionEntity implements Serializable{
	private static final long serialVersionUID = 752790051367015928L;
	@Id
	@GeneratedValue
	@Column(name="Id", nullable = false)
	private int id;
	@ManyToOne
	@JoinColumn(name="ProductId")
	private ProductEntity product;
	@Column(name = "DiscountValue")
	private int discountValue;
	@Column(name="DateCreated")
	private Date dateCreated;
	@Column(name="ValidUntil")
	private Date validUntil;
	@Column(name="CoupeCode")
	private String coupeCode;
	@Column(name="MinOrderValue")
	private int minOrderValue;
	@Column(name = "MaxDiscountAmount")
	private int maxDiscountAmount;
	@Column(name = "IsActive")
	private boolean isActive;
	
	public PromotionEntity() {
		super();
	}

	public PromotionEntity(int id, ProductEntity product, int discountValue, Date dateCreated, Date validUntil,
			String coupeCode, int minOrderValue, int maxDiscountAmount, boolean isActive) {
		super();
		this.id = id;
		this.product = product;
		this.discountValue = discountValue;
		this.dateCreated = dateCreated;
		this.validUntil = validUntil;
		this.coupeCode = coupeCode;
		this.minOrderValue = minOrderValue;
		this.maxDiscountAmount = maxDiscountAmount;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	public String getCoupeCode() {
		return coupeCode;
	}
	public void setCoupeCode(String coupeCode) {
		this.coupeCode = coupeCode;
	}
	public int getMinOrderValue() {
		return minOrderValue;
	}
	public void setMinOrderValue(int minOrderValue) {
		this.minOrderValue = minOrderValue;
	}
	public int getMaxDiscountAmount() {
		return maxDiscountAmount;
	}
	public void setMaxDiscountAmount(int maxDiscountAmount) {
		this.maxDiscountAmount = maxDiscountAmount;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
