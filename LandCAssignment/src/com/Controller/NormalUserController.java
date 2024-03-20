package com.Controller;

import java.sql.SQLException;

import com.Console.ConsoleService;
import com.User.UserInfoBuilder;
import com.User.UserInfoDTO;
import com.User.UserService;

public class NormalUserController {
	
	private UserService userService;
	
	public NormalUserController() {
	   this.userService = new UserService();
	}
	
	void normalUserLayout() throws ClassNotFoundException, SQLException {
		String choice = ConsoleService.getUserInput("Enter the attribute choice \\n 1.View \\n 2.Modify");
		String name = ConsoleService.getUserInput("Enter the name:");
	    String emailId = ConsoleService.getUserInput("Enter the emailId:");
	    String password = ConsoleService.getUserInput("Enter your email password: ");
	    UserInfoDTO userInfoDTO = new UserInfoBuilder()
				.setUserName(name)
		        .setEmail(emailId)
		        .setPassword(password)
		        .build();
	    switch (choice) {
        case "1":
			
        	userInfoDTO = userService.searchUser(userInfoDTO.email);
			if(userInfoDTO == null) {
				System.out.println("No user found");
			}
			else {
			    System.out.println("Name :" +userInfoDTO.userName+ "\n"+
				           	   "EmailId :" + userInfoDTO.email+ "\n");
			}
			break;
		
		case "2":
			
			int rowUpdate = userService.modify(userInfoDTO);
		    System.out.println("Row Inserted :"+ rowUpdate+ "\n"+
				    "Record Updated Successfully");
				    break;
	    }
	}
}
