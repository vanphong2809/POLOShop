package com.phong.poloshop.dao.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CATALOG", schema = "dbo")
public class CatalogEntity implements Serializable {
	private static final long serialVersionUID = 721038453740868236L;
	@Id
	@GeneratedValue
	@Column(name = "CatalogId", nullable = false)
	private int catalogId;
	@Column(name="CatalogName", nullable = false)
	private String catalogName;
	@Column(name="Description")
	private String description;
	@Column(name="ParentId")
	private int parentId;
	@Column(name="Image")
	private String image;
	@Column(name = "Status")
	private boolean status;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<ProductEntity> products=new HashSet<ProductEntity>(0);
	public CatalogEntity() {
		super();
	}

	public CatalogEntity(int catalogId, String catalogName, String description, int parentId, String image,
			boolean status) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.description = description;
		this.parentId = parentId;
		this.image = image;
		this.status = status;
	}
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Set<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
}
