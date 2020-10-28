package com.phong.poloshop.dao.repositories;

import org.springframework.stereotype.Repository;

import com.phong.poloshop.dao.entities.CatalogEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity,Integer>{

}
