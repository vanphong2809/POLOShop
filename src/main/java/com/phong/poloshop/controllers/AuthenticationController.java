package com.phong.poloshop.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phong.poloshop.common.dto.LoginRequestDTO;
import com.phong.poloshop.common.dto.LoginResponseDTO;
import com.phong.poloshop.common.dto.ResponseDataDTO;
import com.phong.poloshop.common.filters.JwtTokenProvider;
import com.phong.poloshop.services.UserServiceInterface;
import com.phong.poloshop.services.impl.UserService;

@RestController
public class AuthenticationController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired 
	UserServiceInterface userService;
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseDataDTO<LoginResponseDTO> login(@RequestBody LoginRequestDTO user, HttpServletRequest request,
			HttpServletResponse response) {
		// Authentication from user name and password
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("userName", user.getUserName());
		parametersMap.add("password", user.getPassword());
		System.out.println(user.getUserName() + "   " + user.getPassword());
		UserDetails userDetail=userService.loadUserByUsername(user.getUserName());
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), null, userDetail.getAuthorities()));
//
		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		JwtTokenProvider.addAuthentication(response, user.getUserName());
		
		String authorizationString = response.getHeader("Authorization");

		ResponseDataDTO<LoginResponseDTO> res = new ResponseDataDTO<LoginResponseDTO>();
		res.setData(new LoginResponseDTO(authorizationString));
//		response.setCode(Constants.SUCCESS_CODE);
		res.setMessage("Dang nhap thanh cong");

		return res;
	}
}
