package com.phong.poloshop.common.filters;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.phong.poloshop.services.impl.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtTokenProvider{
	static final long EXPIRATIONTIME = 604800000L;
	static final String SECRET = "ThisIsASecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
//	@Autowired 
//	AuthenticationManager authenticationManager;
	@Autowired
	static UserService userService;
	//=new UserService();
	public static String addAuthentication(HttpServletResponse response,String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
		return JWT;
	}
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			// parse the token.
			String username = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();
			System.out.println("userName:      "+username);
//			Claims claims =  Jwts.parser()
//                    .setSigningKey(SECRET)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody();
//			String username = claims.getSubject().toString();
			UserDetails user=userService.loadUserByUsername(username);
			return username != null ? new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList()) : null;
			
		}
		return null;
	}
}
