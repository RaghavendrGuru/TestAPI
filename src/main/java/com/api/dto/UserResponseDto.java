package com.api.dto;

import java.util.List;

public class UserResponseDto {
	private String message;
	private Integer statusCode;
	private List<UserDto> userDtoList;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public List<UserDto> getUserDtoList() {
		return userDtoList;
	}
	public void setUserDtoList(List<UserDto> userDtoList) {
		this.userDtoList = userDtoList;
	}
	
	
}
