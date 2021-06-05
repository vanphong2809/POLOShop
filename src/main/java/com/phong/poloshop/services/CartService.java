package com.phong.poloshop.services;

import java.util.List;

import com.phong.poloshop.dao.entities.ProductEntity;
import com.phong.poloshop.dao.model.CartItem;

public interface CartService {
	public CartItem findItemById(int productId);
	public List<CartItem> addProduct(int productId,int quantity);
	public void updateProduct(int productId, int quantity);
	public void removeProduct(ProductEntity product);
	public boolean isEmpty();
	public int getQuantityTotal();
	public double getAmountTotal() ;
}
