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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CUSTOMER", schema = "dbo")
public class CustomerEntity implements Serializable{
	private static final long serialVersionUID = 4641673700302904548L;
	@Id
	@GeneratedValue
	@Column(name = "CustomerId", nullable = false)
	private int customerId;
	@Column(name="UserName")
	private String userName;
	@Column(name = "Password")
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name = "Address")
	private String address;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "CreatedAt")
	private Date createdAt;
	@Column(name = "Status")
	private int status;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<OrderEntity> orders=new HashSet<OrderEntity>(0);
	
	public CustomerEntity() {
		super();
	}
	public CustomerEntity(int customerId, String userName, String password, String email, String address, String phone,
			Date createdAt, int status) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.createdAt = createdAt;
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Set<OrderEntity> getOrders() {
		return orders;
	}
	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}
	
}
