package com.phong.poloshop.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUCT_SIZE", schema = "dbo", catalog = "POLO")
public class ProductSizeEntity implements Serializable{
	private static final long serialVersionUID = 4097199011118823183L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProductSizeId",nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ProductId")
	@JsonIgnore
	private ProductEntity products;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SizeId")
	private SizeEntity sizes;
	
	@Column(name="Status")
	private boolean status;
	
	@Column(name="Quantity")
	private int quantity;
	
	public ProductSizeEntity() {
		super();
	}
	public ProductSizeEntity(int id, ProductEntity products, SizeEntity sizes, boolean status, int quantity) {
		super();
		this.id = id;
		this.products = products;
		this.sizes = sizes;
		this.status = status;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public ProductEntity getProducts() {
//		return products;
//	}
//	public void setProducts(ProductEntity products) {
//		this.products = products;
//	}
	public SizeEntity getSizes() {
		return sizes;
	}
	public void setSizes(SizeEntity sizes) {
		this.sizes = sizes;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}