package com.phong.poloshop.common.filters;

import java.io.IOException;

import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phong.poloshop.common.dto.LoginRequestDTO;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	public JWTLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
		setAuthenticationManager(authManager);
	}
//xac minh username va pass
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		LoginRequestDTO user = new ObjectMapper().readValue((request.getInputStream()), LoginRequestDTO.class);
		String userName = user.getUserName();
		String password = user.getPassword();
		Authentication auth = getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(userName, password, Collections.emptyList()));
		System.out.println(new UsernamePasswordAuthenticationToken(userName, password, Collections.emptyList()));
		System.out.println("authorities: " + auth.getAuthorities() + " Credentials  " + auth.getCredentials()
				+ "  Principal  " + auth.getPrincipal() + " Details   " + auth.getDetails());
		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(userName, password, Collections.emptyList()));
	}
//gan token vao trong Header response
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		System.out.println("JWTLoginFilter.successfulAuthentication:");
		System.out.println(authResult.getName());
		System.out.println(response);
		// Write Authorization to Headers of Response.
		String jwt = JwtTokenProvider.addAuthentication(response, authResult.getName());
		System.out.println("jwt    " + jwt);
		String authorizationString = response.getHeader("Authorization");

		System.out.println("Authorization String=" + authorizationString);
	}

}
