package com.phong.poloshop.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BANNER", schema = "dbo", catalog = "POLO")
public class BannerEntity implements Serializable{

	private static final long serialVersionUID = 2529947384069628153L;
	@Id
	@GeneratedValue
	@Column(name="BannerId", nullable = false)
	private int bannerId;
	@Column(name="BannerImg")
	private String bannerImg;
	@Column(name="DisplayNumber")
	private int displayNumber;
	@Column(name = "Status")
	private boolean status;
	public BannerEntity() {
		super();
	}
	public BannerEntity(int bannerId, String bannerImg, int displayNumber, boolean status) {
		super();
		this.bannerId = bannerId;
		this.bannerImg = bannerImg;
		this.displayNumber = displayNumber;
		this.status = status;
	}
	public int getBannerId() {
		return bannerId;
	}
	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}
	public String getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	public int getDisplayNumber() {
		return displayNumber;
	}
	public void setDisplayNumber(int displayNumber) {
		this.displayNumber = displayNumber;
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
