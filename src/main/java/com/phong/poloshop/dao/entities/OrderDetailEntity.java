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
@Table(name = "Order_Detail", schema = "dbo")
public class OrderDetailEntity implements Serializable{

	private static final long serialVersionUID = 7735996465964767553L;
	@Id
	@GeneratedValue
	@Column(name = "Id", nullable = false)
	private int id;
	
	private OrderEntity order;
	
	private ProductEntity product;
	@Column(name="Amount")
	private int amount;
	@Column(name = "Price")
	private int price;
	@Column(name="Quantity")
	private int quantity;
	@Column(name="note")
	private String note;
	public OrderDetailEntity() {
		super();
	}
	public OrderDetailEntity(OrderEntity order, ProductEntity product, int amount, int price, int quantity,
			String note) {
		super();
		this.order = order;
		this.product = product;
		this.amount = amount;
		this.price = price;
		this.quantity = quantity;
		this.note = note;
	}
	@ManyToOne
	@JoinColumn(name="OrderId")
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	@ManyToOne
	@JoinColumn(name="ProductId")
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
