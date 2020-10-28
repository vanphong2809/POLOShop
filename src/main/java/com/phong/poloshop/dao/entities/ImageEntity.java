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
@Table(name="Image", schema = "dbo")
public class ImageEntity implements Serializable{

	private static final long serialVersionUID = 5140892869526815445L;
	@Id
	@GeneratedValue
	@Column(name="ImageId", nullable = false)
	private int imageId;
	@ManyToOne
	@JoinColumn(name="ProductId")
	@JsonIgnore
	private ProductEntity product;
	@Column(name="ImageLink")
	private String imageLink;
	@Column(name="Status")
	private boolean status;
	public ImageEntity() {
		super();
	}
	public ImageEntity(int imageId, ProductEntity product, String imageLink, boolean status) {
		super();
		this.imageId = imageId;
		this.product = product;
		this.imageLink = imageLink;
		this.status = status;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
