package com.phong.poloshop.dao.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "USER", schema = "dbo", catalog = "POLO")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = -8553282538328529737L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "UserId",nullable = false)
	private Integer userId;
	@Column(name = "UserName")
	private String userName;
	@Column(name="Password")
	private String password;
	@Column(name = "Email")
	private String email;
	@Column(name="Address")
	private String address;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "CreatedAt")
	private Date createdAt;
	@Column(name = "IsSuperAdmin")
	private Boolean isSuperAdmin;
	@Column(name = "Status")
	private Integer status;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<UserRoleEntity> userRoles=new HashSet<UserRoleEntity>();
	public UserEntity() {
		super();
	}
	public UserEntity(Integer userId, String userName, String password, String email, String address, String phone,
			Date createdAt, Boolean isSuperAdmin, Integer status, Set<UserRoleEntity> userRoles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.createdAt = createdAt;
		this.isSuperAdmin = isSuperAdmin;
		this.status = status;
		this.userRoles = userRoles;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Boolean isSuperAdmin() {
		return isSuperAdmin;
	}
	public void setSuperAdmin(Boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<UserRoleEntity> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", createdAt=" + createdAt + ", isSuperAdmin="
				+ isSuperAdmin + ", status=" + status + ", userRoles=" + userRoles + "]";
	}
	
	
}
