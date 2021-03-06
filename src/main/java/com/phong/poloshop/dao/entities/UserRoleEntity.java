package com.phong.poloshop.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USER_ROLE",schema = "dbo", catalog = "POLO")
public class UserRoleEntity implements Serializable{
	private static final long serialVersionUID = -3184217782551497965L;
	@Id
	@GeneratedValue
	@Column(name = "UserRoleId", nullable = false)
	private Integer userRoleId;
	@Column(name="IsActive")
	private Boolean isActive;
	@ManyToOne
	@JoinColumn(name="RoleId")
	private RoleEntity roles;
	@ManyToOne
	@JoinColumn(name="UserId")
	private UserEntity users;
	public UserRoleEntity() {
		super();
	}
	public UserRoleEntity(Integer userRoleId, Boolean isActive, RoleEntity roles,
			UserEntity users) {
		super();
		this.userRoleId = userRoleId;
		this.isActive = isActive;
		this.roles = roles;
		this.users = users;
	}
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public RoleEntity getRoles() {
		return roles;
	}
	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}
	public UserEntity getUsers() {
		return users;
	}
	public void setUsers(UserEntity users) {
		this.users = users;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
