package com.cg.onlinetutorfinder.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TutorDto extends UserDto {

	@JsonIgnore
	String userType;
	String active;
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	
}
