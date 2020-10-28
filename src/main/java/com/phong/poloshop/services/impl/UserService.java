package com.phong.poloshop.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phong.poloshop.dao.entities.CustomUserDetails;
import com.phong.poloshop.dao.entities.UserEntity;
import com.phong.poloshop.dao.repositories.UserRepository;
import com.phong.poloshop.services.UserServiceInterface;


@Service
@Transactional
public class UserService implements UserServiceInterface {
	private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	//@Autowired
	private PasswordEncoder passwordEncoder;
	//@Autowired
	private UserRepository userRepository;
	
	public UserService() {
		//super(tham so 1, tham so 2);
	}

	@Autowired
	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	//@Transactional
	public void register(UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.register(user.getUserName(), user.getPassword(), user.getEmail(), user.getAddress(),
				user.getPhone());
	}

	//@Transactional
	public UserDetails findUserByEmail(String email) {
		UserEntity user = new UserEntity();
		try {
			user = userRepository.findUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return new CustomUserDetails(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserName: "+username);
		//UserEntity user=new UserEntity();
		UserEntity user=userRepository.findById(20).get();
		System.out.println("UserName---: "+user);
		//UserEntity user1=userRepository.findUserByUserName(username);
		System.out.println("UserName---: "+user);
//		if(userRepository.findUserByUserName(username)!=null) {
//			user = userRepository.findUserByUserName(username);
//		}
		
		if (user == null) {
			System.out.println("Khong tim thay tai khoan " + username);
			throw new UsernameNotFoundException("Nguoi dung " + username + " khong tim thay trong database");
		}
		List<String> permissionName = (List<String>) userRepository.getPermissionName(user.getUserId());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (permissionName != null) {
			for (String role : permissionName) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new User(user.getUserName(), //
				user.getPassword(), grantList);
		return userDetails;
	}
//
//	@Transactional
//	public UserDetails loadUserById(Integer id) {
//		UserEntity user = userRepository.findById(id)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
//
//		return new CustomUserDetails(user);
//	}
}
