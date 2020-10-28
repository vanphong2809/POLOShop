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
@Table(name = "Color", schema = "dbo")
public class ColorEntity implements Serializable{

	private static final long serialVersionUID = 5414241176392548557L;
	@Id
	@GeneratedValue
	@Column(name = "ColorId", nullable = false)
	private int colorId;
	@Column(name = "ColorName", nullable = false)
	private String colorName;
	@Column(name = "Natation", nullable = false)
	private String natation;
	@Column(name = "Status")
	private boolean status;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "color", orphanRemoval = true)
	@JsonIgnore
	private Set<ProductColorEntity> productColors=new HashSet<ProductColorEntity>(0);
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getNatation() {
		return natation;
	}
	public void setNatation(String natation) {
		this.natation = natation;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Set<ProductColorEntity> getProductColors() {
		return productColors;
	}
	public void setProductColors(Set<ProductColorEntity> productColors) {
		this.productColors = productColors;
	}
	
}
