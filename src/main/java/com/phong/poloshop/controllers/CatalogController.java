package com.phong.poloshop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phong.poloshop.common.dto.ResponseDataDTO;
import com.phong.poloshop.dao.entities.CatalogEntity;
import com.phong.poloshop.dao.entities.ProductEntity;
import com.phong.poloshop.services.CatalogService;
import com.phong.poloshop.services.ProductService;

@RestController
@RequestMapping(value = "/api/catalogs")
public class CatalogController {
	@Autowired
	private CatalogService catalogService;
	@Autowired 
	private ProductService productService;
	@RequestMapping(value = "/all", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseDataDTO<List<CatalogEntity>> getAllCatalog(){
		ResponseDataDTO<List<CatalogEntity>> response=new ResponseDataDTO<List<CatalogEntity>>();
		List<CatalogEntity> listCatalog=new ArrayList<CatalogEntity>();
		listCatalog=catalogService.getAll();
		response.setData(listCatalog);
		response.setLength(listCatalog.size());
		return response;
	}
	@RequestMapping(value="/{catalogId}",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseDataDTO<List<ProductEntity>> getProductsByCatalog (@PathVariable("catalogId") int catalogId){
		ResponseDataDTO<List<ProductEntity>> response=new ResponseDataDTO<List<ProductEntity>>();
		List<ProductEntity> list=productService.getProductsByCatalog(catalogId);
		response.setData(list);
		response.setLength(list.size());
		return response;
	}
}
