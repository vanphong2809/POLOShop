package com.phong.poloshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phong.poloshop.dao.entities.ProductEntity;
import com.phong.poloshop.dao.model.CartInfo;
import com.phong.poloshop.dao.model.CartItem;
import com.phong.poloshop.dao.repositories.ProductRepository;
import com.phong.poloshop.services.CartService;
@Service
public class CartServiceImpl implements CartService {
	private CartInfo cartInfo;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public CartItem findItemById(int productId) {
		try {
			for(CartItem item: cartInfo.getCartItem()) {
				if(item.getProduct().getProductId()==productId) {
					return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<CartItem> addProduct(int productId, int quantity) {
		CartItem item=this.findItemById(productId);
		if(item==null) {
			item =new CartItem();
			item.setQuantity(0);
			item.setProduct(productRepository.getProductById(productId));
			cartInfo.getCartItem().add(item);
		}
		int newQuantity=item.getQuantity()+quantity;
		if(newQuantity<=0) {
			cartInfo.getCartItem().remove(item);
		}else {
			item.setQuantity(newQuantity);
		}
		return cartInfo.getCartItem();
	}

	@Override
	public void updateProduct(int productId, int quantity) {
		CartItem item=this.findItemById(productId);
		if(item!=null) {
			if(quantity<=0) {
				cartInfo.getCartItem().remove(item);
			}else {
				item.setQuantity(quantity);
			}
		}
		
	}

	@Override
	public void removeProduct(ProductEntity product) {
		CartItem item=this.findItemById(product.getProductId());
		if(item!=null) {
			cartInfo.getCartItem().remove(item);
		}
	}

	@Override
	public boolean isEmpty() {
		return cartInfo.getCartItem().isEmpty();
	}

	@Override
	public int getQuantityTotal() {
		int quantity = 0;
		for(CartItem item: cartInfo.getCartItem()) {
			quantity+=item.getQuantity();
		}
		return quantity;
	}

	@Override
	public double getAmountTotal() {
        double total = 0;
        for (CartItem item : cartInfo.getCartItem()) {
            total += item.getAmount();
        }
        return total;
	}

}
