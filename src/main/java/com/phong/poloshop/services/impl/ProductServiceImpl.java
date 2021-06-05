package com.phong.poloshop.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phong.poloshop.dao.entities.ProductEntity;
import com.phong.poloshop.dao.repositories.ProductRepository;
import com.phong.poloshop.services.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	private Logger LOGGER=LoggerFactory.getLogger(ProductServiceImpl.class);
	@Override
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> listProduct=new ArrayList<ProductEntity>();
		try {
			listProduct=productRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		
		return listProduct;
	}

	@Override
	public List<ProductEntity> hotProducts() {
		List<ProductEntity> listHotProducts=new ArrayList<ProductEntity>();
		try {
			listHotProducts=productRepository.getHotProducts();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listHotProducts;
	}

	@Override
	public List<ProductEntity> newProducts() {
		List<ProductEntity> listNewProducts=new ArrayList<ProductEntity>();
		try {
			listNewProducts=productRepository.getNewProducts();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listNewProducts;
	}

	@Override
	public List<ProductEntity> getBestSellerProducts() {
		List<ProductEntity> listBestSeller=new ArrayList<ProductEntity>();
		try {
			listBestSeller=productRepository.getBestSellerProducts();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listBestSeller;
	}

	@Override
	public List<ProductEntity> promotionProducts() {
		List<ProductEntity> listPromotionProducts=new ArrayList<ProductEntity>();
		try {
			listPromotionProducts=productRepository.getPromotionProducts();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listPromotionProducts;
	}

	@Override
	public List<ProductEntity> getProductsByCatalog(Integer catalogId) {
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		try {
			list=productRepository.getProductsByCatalog(catalogId);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return list;
	}

	@Override
	public ProductEntity getProductById(int id) {
		ProductEntity product=new ProductEntity();		
		try {
			product=productRepository.getProductById(id);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return product;
	}

	@Override
	public List<ProductEntity> search(String queryString) {
		List<ProductEntity> listProduct=new ArrayList<ProductEntity>();
		try {
			listProduct=productRepository.search(queryString);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listProduct;
	}

}
