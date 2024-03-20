package com.Controller;

import java.sql.SQLException;

import com.Console.ConsoleService;
import com.User.UserInfoBuilder;
import com.User.UserInfoDTO;
import com.User.UserService;

public class ViewerController {
	private UserService userService;
	public ViewerController() {
		this.userService = new UserService();
	}
	void viewerLayout() throws ClassNotFoundException, SQLException {
		
		String name = ConsoleService.getUserInput("Enter the name:");
	    String emailId = ConsoleService.getUserInput("Enter the emailId:");
	    String password = ConsoleService.getUserInput("Enter your email password: ");
	    UserInfoDTO userInfoDTO = new UserInfoBuilder()
				.setUserName(name)
		        .setEmail(emailId)
		        .setPassword(password)
		        .build();
	    
	    userInfoDTO = userService.searchUser(userInfoDTO.email);
		if(userInfoDTO == null) {
			System.out.println("No user found");
		}
		else {
		    System.out.println("Name :" +userInfoDTO.userName+ "\n"+
			           	   "EmailId :" + userInfoDTO.email+ "\n");
		}
	    
	}
}
