package com.phong.poloshop.dao.model;

import java.util.ArrayList;
import java.util.List;

import com.phong.poloshop.dao.entities.ProductEntity;

public class CartInfo {
	private final List<CartItem> cartItem=new ArrayList<CartItem>();
	public CartInfo() {
		 
    }
	public List<CartItem> getCartItem() {
		return cartItem;
	}
//	public CartItem findItemById(int productId) {
//		for(CartItem item: cartItem) {
//			if(item.getProduct().getProductId()==productId) {
//				return item;
//			}
//		}
//		return null;
//	}
//	public void addProduct(ProductEntity product,int quantity) {
//		CartItem item=this.findItemById(product.getProductId());
//		if(item==null) {
//			item =new CartItem();
//			item.setQuantity(0);
//			item.setProduct(product);
//			this.cartItem.add(item);
//		}
//		int newQuantity=item.getQuantity()+quantity;
//		if(newQuantity<=0) {
//			this.cartItem.remove(item);
//		}else {
//			item.setQuantity(newQuantity);
//		}
//	}
//	
//	public void updateProduct(int productId, int quantity) {
//		CartItem item=this.findItemById(productId);
//		if(item!=null) {
//			if(quantity<=0) {
//				this.cartItem.remove(item);
//			}else {
//				item.setQuantity(quantity);
//			}
//		}
//	}
//	public void removeProduct(ProductEntity product) {
//		CartItem item=this.findItemById(product.getProductId());
//		if(item!=null) {
//			this.cartItem.remove(item);
//		}
//	}
//	
//	public boolean isEmpty() {
//		return this.cartItem.isEmpty();
//	}
//	
//	public int getQuantityTotal() {
//		int quantity = 0;
//		for(CartItem item: this.cartItem) {
//			quantity+=item.getQuantity();
//		}
//		return quantity;
//	}
//	
//	 public double getAmountTotal() {
//	        double total = 0;
//	        for (CartItem item : this.cartItem) {
//	            total += item.getAmount();
//	        }
//	        return total;
//	    }
//	 
//	    public void updateQuantity(CartInfo cartForm) {
//	        if (cartForm != null) {
//	            List<CartItem> items = cartForm.getCartItem();
//	            for (CartItem line : items) {
//	                this.updateProduct(line.getProduct().getProductId(), line.getQuantity());
//	            }
//	        }
//	 
//	    }
}
