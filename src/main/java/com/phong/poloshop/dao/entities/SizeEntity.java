package com.phong.poloshop.dao.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="SIZE", schema = "dbo", catalog = "POLO")
public class SizeEntity implements Serializable{
	private static final long serialVersionUID = 1516594491446260743L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SizeId",nullable = false)
	private int sizeId;
	@Column(name="SizeName")
	private String sizeName;
	@Column(name="Description")
	private String description;
	@Column(name="Status")
	private boolean status;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sizes", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<ProductSizeEntity> productSizes=new HashSet<ProductSizeEntity>();

	public SizeEntity() {
		super();
	}
	public SizeEntity(int sizeId, String sizeName, String description, boolean status) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.description = description;
		this.status = status;
	}
//	public Set<ProductEntity> getProduct() {
//		return product;
//	}
//	public void setProduct(Set<ProductEntity> product) {
//		this.product = product;
//	}	
	public Set<ProductSizeEntity> getProductSizes() {
		return productSizes;
	}
	public void setProductSizes(Set<ProductSizeEntity> productSizes) {
		this.productSizes = productSizes;
	}
	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}	
}
