package com.phong.poloshop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phong.poloshop.common.dto.ResponseDataDTO;
import com.phong.poloshop.dao.entities.BannerEntity;
import com.phong.poloshop.services.BannerService;

@RestController
@RequestMapping(value = "/api/banners")
public class BannerController {
	@Autowired
	private BannerService bannerSerevice;
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDataDTO<List<BannerEntity>> getBanners(){
		ResponseDataDTO<List<BannerEntity>> response= new ResponseDataDTO<List<BannerEntity>>();
		List<BannerEntity> listBanner=new ArrayList<BannerEntity>();
		listBanner=bannerSerevice.getBanner();
		response.setData(listBanner);
		response.setLength(listBanner.size());
		return response;
	}
}
