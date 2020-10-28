package com.phong.poloshop.common.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.phong.poloshop.dao.entities.UserEntity;
import com.phong.poloshop.dao.repositories.UserRepository;
import com.phong.poloshop.services.UserServiceInterface;
import com.phong.poloshop.services.impl.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtTokenProvider{
	static final long EXPIRATIONTIME = 604800000L;
	static final String SECRET = "ThisIsASecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
	
	public JwtTokenProvider() {
		super();
	}
	@Autowired 
	AuthenticationManager authenticationManager;
	@Autowired
	UserServiceInterface userService;
	//=new UserService();
	public static String addAuthentication(HttpServletResponse response,String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
		return JWT;
	}
	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		
		if (token != null) {
			// parse the token.
			String username = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();
//			Claims claims =  Jwts.parser()
//                    .setSigningKey(SECRET)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody();
//			String username = claims.getSubject().toString();
			UserDetails user=userService.loadUserByUsername(username);
			return username != null ? new UsernamePasswordAuthenticationToken(username, null,user.getAuthorities()) : null;
		}
		return null;
	}
}
