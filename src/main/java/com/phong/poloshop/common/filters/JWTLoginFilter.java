package com.phong.poloshop.common.filters;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phong.poloshop.common.dto.LoginRequestDTO;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	@Autowired 
	LoginRequestDTO loginRequest;
	@Autowired
	PasswordEncoder passwordEncoder;
	JwtTokenProvider jwtTokenProvider;

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		LoginRequestDTO user = new ObjectMapper().readValue((request.getInputStream()), LoginRequestDTO.class); 
		String userName = user.getUserName();
		String password = user.getPassword();
		Authentication auth=getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(userName, password, Collections.emptyList()));
		System.out.println("authorities: "+auth.getAuthorities()+" Credentials  "+auth.getCredentials()+"  Principal  "+auth.getPrincipal()+" Details   "+auth.getDetails());
		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		System.out.println("JWTLoginFilter.successfulAuthentication:");
		System.out.println(authResult.getName());
		System.out.println(response);
		// Write Authorization to Headers of Response.
		String jwt=JwtTokenProvider.addAuthentication(response, authResult.getName());
		System.out.println("jwt    "+jwt);
		String authorizationString = response.getHeader("Authorization");

		System.out.println("Authorization String=" + authorizationString);
	}

}
