package com.phong.poloshop.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phong.poloshop.common.dto.ResponseDataDTO;
import com.phong.poloshop.dao.entities.ProductEntity;
import com.phong.poloshop.services.ProductService;

@RestController
@RequestMapping(value = "/api/products")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<List<ProductEntity>> getAllProduct() {
		ResponseDataDTO<List<ProductEntity>> response = new ResponseDataDTO<List<ProductEntity>>();
		List<ProductEntity> listProduct = null;
		listProduct = productService.getAllProduct();
		response.setData(listProduct);
		response.setLength(listProduct.size());
		return response;
	}

	@RequestMapping(value = "/hot", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<List<ProductEntity>> getHotProducts() {
		ResponseDataDTO<List<ProductEntity>> response = new ResponseDataDTO<List<ProductEntity>>();
		List<ProductEntity> hotProducts = productService.hotProducts();
		response.setData(hotProducts);
		response.setLength(hotProducts.size());
		return response;

	}

	@RequestMapping(value = "/new", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<List<ProductEntity>> getNewProducts() {
		ResponseDataDTO<List<ProductEntity>> response = new ResponseDataDTO<List<ProductEntity>>();
		List<ProductEntity> newProducts = productService.newProducts();
		response.setData(newProducts);
		response.setLength(newProducts.size());
		return response;
	}

	@RequestMapping(value = "/promotion", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<List<ProductEntity>> getPromotionProducts() {
		ResponseDataDTO<List<ProductEntity>> response = new ResponseDataDTO<List<ProductEntity>>();
		List<ProductEntity> promotionProducts = productService.promotionProducts();
		response.setData(promotionProducts);
		response.setLength(promotionProducts.size());
		return response;
	}

	@RequestMapping(value = "/best-seller", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<List<ProductEntity>> getBestSellerProducts() {
		ResponseDataDTO<List<ProductEntity>> response = new ResponseDataDTO<List<ProductEntity>>();
		List<ProductEntity> bestSellerProducts = productService.getBestSellerProducts();
		response.setData(bestSellerProducts);
		response.setLength(bestSellerProducts.size());
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<ProductEntity> getProductById(@PathVariable int id) {
		ResponseDataDTO<ProductEntity> response = new ResponseDataDTO<ProductEntity>();
		ProductEntity product = productService.getProductById(id);
		response.setData(product);
		return response;
	}
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseDataDTO<List<ProductEntity>> search(@RequestParam("search") String queryString){
		ResponseDataDTO<List<ProductEntity>> response=new ResponseDataDTO<List<ProductEntity>>();
		List<ProductEntity> listProduct=productService.search(queryString);
		response.setData(listProduct);
		response.setLength(listProduct.size());
		return response;
	}
}
