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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ORDER", schema = "dbo")
public class OrderEntity implements Serializable{
	private static final long serialVersionUID = 6213378996308788793L;
	@Id
	@GeneratedValue
	@Column(name = "OrderId", nullable = false)
	private int orderId;
	@Column(name = "Address")
	private String address;
	@Column(name = "OrderDate")
	private Date orderDate;
	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private CustomerEntity customer;
	@Column(name="Status")
	private int status;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<OrderDetailEntity> orderDetails=new HashSet<OrderDetailEntity>(0);
	public OrderEntity() {
		super();
	}
	public OrderEntity(int orderId, String address, Date orderDate, CustomerEntity customer, int status) {
		super();
		this.orderId = orderId;
		this.address = address;
		this.orderDate = orderDate;
		this.customer = customer;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Set<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
