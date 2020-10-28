package com.phong.poloshop.common.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.phong.poloshop.common.filters.JWTLoginFilter;
import com.phong.poloshop.common.filters.JwtAuthenticationFilter;
import com.phong.poloshop.services.UserServiceInterface;
import com.phong.poloshop.services.impl.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	UserServiceInterface userService;
	@Autowired 
	DataSource dataSource;
//	@Bean
//	public JwtAuthenticationFilter jwtAuthenticationFilter() {
//		return new JwtAuthenticationFilter();
//	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// khong can xac thuc
				.antMatchers("/").permitAll().antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.GET, "/login").permitAll()
				// can xac thuc

				.antMatchers("/api/user/**").hasRole("Quản lý mua hàng")
				.antMatchers("/api/products/*").hasRole("Quản lý mua hàng")
//				.antMatchers("/api/user/*").hasRole("Quản lý người dùng")
				.anyRequest().authenticated()
				.and()
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {      
	       auth.jdbcAuthentication().dataSource(dataSource)
	               .usersByUsernameQuery("select userName,password, status from [USER] where userName=?")
	               .authoritiesByUsernameQuery("select u.userName, p.PermissionName from [USER] u join USER_ROLE ur on u.UserId=ur.UserId " + 
	               		"join [ROLE] r on ur.RoleId=r.RoleId join ROLE_PERMISSION rp on r.RoleId=rp.RoleId"
	               		+ " join PERMISSION p on rp.PermissionId=p.PermissionId " + 
	               		"where u.UserName=?");
	   }
}
