package com.phong.poloshop.common.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.phong.poloshop.common.filters.JWTLoginFilter;
import com.phong.poloshop.common.filters.JwtAuthenticationFilter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtInMemoryUserDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				// khong can xac thuc
				.antMatchers("/").permitAll()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.GET, "/login").permitAll()
				// can xac thuc
				.antMatchers("/api/user*").hasAnyAuthority("Quản lý khách hàng","Quản lý người dùng")
				.antMatchers("/api/products/*").hasAnyAuthority("Quản lý hàng hóa","Quản lý bán hàng",
						"Quản lý đơn đặt hàng","Quản lý trả hàng","Thiết lập chương trình khuyến mãi",
						"Quản lý kho","Quản lý mua hàng","Hệ thống báo cáo")
				.antMatchers("/api/banners/*").hasAuthority("Quản lý hàng hóa")
				.antMatchers("/api/catalogs/*").hasAnyAuthority("Quản lý hàng hóa","Quản lý bán hàng",
						"Quản lý đơn đặt hàng","Quản lý trả hàng","Thiết lập chương trình khuyến mãi",
						"Quản lý kho","Quản lý mua hàng","Hệ thống báo cáo")
				.anyRequest().authenticated().and()
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select userName,password, status from [USER] where userName=?")
				.authoritiesByUsernameQuery(
						"select u.userName, p.PermissionName from [USER] u join USER_ROLE ur on u.UserId=ur.UserId "
								+ "join [ROLE] r on ur.RoleId=r.RoleId join ROLE_PERMISSION rp on r.RoleId=rp.RoleId"
								+ " join PERMISSION p on rp.PermissionId=p.PermissionId " + "where u.UserName=?");
	}
	
}
