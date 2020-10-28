package com.phong.poloshop.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUCT_COLOR", schema = "dbo")
public class ProductColorEntity implements Serializable{
	private static final long serialVersionUID = -1123030913281087963L;
	@Id
	@GeneratedValue
	@Column(name="ProductColorId", nullable = false)
	private int id;
	@ManyToOne
	@JoinColumn(name="ProductId")
	@JsonIgnore
	private ProductEntity product;
	@ManyToOne
	@JoinColumn(name="ColorId")
	@JsonIgnore
	private ColorEntity color;
	@Column(name="ImageColor")
	private String imageColor;
	@Column(name="Status")
	private boolean status;
	public ProductColorEntity() {
		super();
	}
	public ProductColorEntity(int id, ProductEntity product, ColorEntity color, String imageColor, boolean status) {
		super();
		this.id = id;
		this.product = product;
		this.color = color;
		this.imageColor = imageColor;
		this.status = status;
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
	public ColorEntity getColor() {
		return color;
	}
	public void setColor(ColorEntity color) {
		this.color = color;
	}
	public String getImageColor() {
		return imageColor;
	}
	public void setImageColor(String imageColor) {
		this.imageColor = imageColor;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
