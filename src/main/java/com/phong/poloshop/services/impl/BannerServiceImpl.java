package com.phong.poloshop.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phong.poloshop.dao.entities.BannerEntity;
import com.phong.poloshop.dao.repositories.BannerRepository;
import com.phong.poloshop.services.BannerService;

@Service
public class BannerServiceImpl implements BannerService{
	@Autowired
	private BannerRepository bannerRepository;
	private Logger LOGGER=LoggerFactory.getLogger(BannerServiceImpl.class);
	@Override
	public List<BannerEntity> getBanner() {
		List<BannerEntity> listBanner=new ArrayList<BannerEntity>();
		try {
			listBanner=bannerRepository.getBanner();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return listBanner;
	}

}
