package com.phong.poloshop.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phong.poloshop.common.dto.ResponseDataDTO;
import com.phong.poloshop.dao.entities.ProductEntity;
import com.phong.poloshop.dao.model.CartInfo;
import com.phong.poloshop.dao.model.CartItem;
import com.phong.poloshop.services.CartService;

@RestController
@RequestMapping(value = "/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseDataDTO<List<CartItem>> addCart(@RequestBody HashMap<String, String> addCartRequest){
		String keys[]= {"productId", "quantity"};
		int productId=Integer.parseInt(addCartRequest.get("productId"));
		int quantity =Integer.parseInt(addCartRequest.get("quantity"));
		ResponseDataDTO<List<CartItem>> response = new ResponseDataDTO<List<CartItem>>();
		List<CartItem> cartItems=cartService.addProduct(productId, quantity);
		response.setData(cartItems);
		response.setLength(cartItems.size());
		return response;
	}
}
