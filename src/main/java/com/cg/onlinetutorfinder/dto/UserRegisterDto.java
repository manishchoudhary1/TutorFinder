package com.cg.onlinetutorfinder.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRegisterDto extends UserDto {

	
	private String password;
	
	@JsonIgnore
	private Long userId;
	
	@JsonIgnore
	private String userType;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
