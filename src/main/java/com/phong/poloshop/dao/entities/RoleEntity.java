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
@Table(name = "ROLE", schema = "dbo", catalog = "POLO")
public class RoleEntity implements Serializable{
	private static final long serialVersionUID = -481086047535255874L;
	@Id
	@GeneratedValue
	@Column(name ="RoleId", nullable = false)
	private int roleId;
	@Column(name = "RoleName")
	private String roleName;
	@Column(name = "Status")
	private boolean status;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<RolePermissionEntity> rolePermissions=new HashSet<RolePermissionEntity>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<UserRoleEntity> userRoles=new HashSet<UserRoleEntity>();
	public RoleEntity() {
		super();
	}
	public RoleEntity(int roleId, String roleName, boolean status, Set<RolePermissionEntity> rolePermissions,
			Set<UserRoleEntity> userRoles) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.status = status;
		this.rolePermissions = rolePermissions;
		this.userRoles = userRoles;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	public Set<UserRoleEntity> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
