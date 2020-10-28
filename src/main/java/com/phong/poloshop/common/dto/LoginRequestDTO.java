package com.phong.poloshop.common.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
	private String userName;
	
	private String password;

	
	public LoginRequestDTO() {
		super();
	}


	public LoginRequestDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}
