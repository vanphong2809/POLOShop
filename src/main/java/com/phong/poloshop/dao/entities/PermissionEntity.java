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
@Table(name = "PERMISSION", schema = "dbo", catalog = "POLO")
public class PermissionEntity implements Serializable{
	private static final long serialVersionUID = 2322163342535015564L;
	@Id
	@GeneratedValue
	@Column(name = "PermissionId", nullable = false)
	private int permissionId;
	@Column(name="PermissionName")
	private String permissionName;
	@Column(name = "Status")
	private boolean status;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "permissions", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<RolePermissionEntity> rolePermissions=new HashSet<RolePermissionEntity>();
	public PermissionEntity() {
		super();
	}
	public PermissionEntity(int permissionId, String permissionName, boolean status,
			Set<RolePermissionEntity> rolePermissions) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.status = status;
		this.rolePermissions = rolePermissions;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Set<RolePermissionEntity> getRolePermissions() {
		return rolePermissions;
	}
	public void setRolePermissions(Set<RolePermissionEntity> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
