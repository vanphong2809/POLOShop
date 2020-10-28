package com.phong.poloshop.dao.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ROLE_PERMISSION", schema = "dbo", catalog = "POLO")
public class RolePermissionEntity implements Serializable{
	private static final long serialVersionUID = -3633423879966181051L;
	@Id
	@GeneratedValue
	@Column(name = "RolePermissionId", nullable = false)
	private int rolePermissionId;
	@Column(name = "IsActive")
	private boolean isActive;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PermissionId")
	private PermissionEntity permissions;
	@ManyToOne
	@JoinColumn(name = "RoleId")
	private RoleEntity roles;
	public RolePermissionEntity() {
		super();
	}
	public RolePermissionEntity(int rolePermissionId, boolean isActive, PermissionEntity permissions,
			RoleEntity roles) {
		super();
		this.rolePermissionId = rolePermissionId;
		this.isActive = isActive;
		this.permissions = permissions;
		this.roles = roles;
	}
	public int getRolePermissionId() {
		return rolePermissionId;
	}
	public void setRolePermissionId(int rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public PermissionEntity getPermissions() {
		return permissions;
	}
	public void setPermissions(PermissionEntity permissions) {
		this.permissions = permissions;
	}
	public RoleEntity getRoles() {
		return roles;
	}
	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
