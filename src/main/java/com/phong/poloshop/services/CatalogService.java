package com.phong.poloshop.services;

import java.util.List;

import com.phong.poloshop.dao.entities.CatalogEntity;

public interface CatalogService {
	public List<CatalogEntity> getAll();
	int create(CatalogEntity catalog);
}
