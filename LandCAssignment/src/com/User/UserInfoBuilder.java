package com.User;



public class UserInfoBuilder {
	UserInfoDTO userInfoDTo;
	
	public UserInfoBuilder() {
		this.userInfoDTo = new UserInfoDTO();
	}
	
	public UserInfoBuilder setUserName(String name) {
		this.userInfoDTo.userName = name;
		return this;
	}
	
	public UserInfoBuilder setEmail(String email) {
		this.userInfoDTo.email = email;
		return this;
	}
	
	public UserInfoBuilder setPassword(String userPassword) {
		this.userInfoDTo.password = userPassword;
		return this;
	}
	
	public UserInfoBuilder setUserType(String userType) {
		this.userInfoDTo.userType = userType;
		return this;
	}
	
	public UserInfoDTO build() {
		return userInfoDTo;
	}
	
}
