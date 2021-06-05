package com.phong.poloshop.dao.model;

import org.springframework.stereotype.Component;

import com.phong.poloshop.dao.entities.ProductEntity;

public class CartItem {
	private ProductEntity product;
	private int quantity;
	
	public CartItem() {
	}
	public CartItem(ProductEntity product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
        return this.product.getPrice() * this.quantity;
    }
}
