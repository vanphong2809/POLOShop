package com.phong.poloshop.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phong.poloshop.dao.entities.CatalogEntity;
import com.phong.poloshop.dao.repositories.CatalogRepository;
import com.phong.poloshop.services.CatalogService;
@Service
public class CatalogServiceImpl implements CatalogService{
	@Autowired
	private CatalogRepository catalogRepository;
	private Logger LOGGER=LoggerFactory.getLogger(CatalogServiceImpl.class);
	@Override
	public List<CatalogEntity> getAll() {
		List<CatalogEntity> listCatalog=null;
		try {
			listCatalog=catalogRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listCatalog;
	}

	@Override
	public int create(CatalogEntity catalog) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
