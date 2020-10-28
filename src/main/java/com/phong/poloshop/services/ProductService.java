package com.phong.poloshop.services;

import java.util.List;
import com.phong.poloshop.dao.entities.ProductEntity;

public interface ProductService {
	public List<ProductEntity> getAllProduct();
	public List<ProductEntity> hotProducts();
	public List<ProductEntity> newProducts();
	public List<ProductEntity> getBestSellerProducts();
	public List<ProductEntity> promotionProducts();
	public List<ProductEntity> getProductsByCatalog(int catalogId);
	ProductEntity getProductById(int id);
	List<ProductEntity> search(String queryString);
}
