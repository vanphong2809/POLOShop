package com.phong.poloshop.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phong.poloshop.dao.entities.BannerEntity;
@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Integer>{
	@Query(value = "select * from BANNER b order by b.DisplayNumber ASC", nativeQuery = true)
	List<BannerEntity> getBanner();
}
