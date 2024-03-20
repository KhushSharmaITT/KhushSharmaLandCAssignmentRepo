package com.Controller;


import com.Console.ConsoleService;
import com.User.UserInfoBuilder;
import com.User.UserInfoDTO;
import com.User.UserService;

public class Controller {
	
	private static UserService userService;

	public static void main(String... args) {
		
		String name = ConsoleService.getUserInput("Enter the name:");
		String emailId = ConsoleService.getUserInput("Enter the emailId:");
		String password = ConsoleService.getUserInput("Enter your email password: ");
		try {
			UserInfoDTO userInfoDTO = new UserInfoBuilder()
					.setUserName(name)
			        .setEmail(emailId)
			        .setPassword(password)
			        .build();
			
			userService = new UserService();
			userInfoDTO = userService.searchUser(userInfoDTO.email);
			if(userInfoDTO == null) {
				System.out.println("User not found");
			} else if(userInfoDTO.userType.equals("ADMIN")) {
				AdminController adminController = new AdminController();
				adminController.adminlayout();
			}
			else if(userInfoDTO.userType.equals("USER")) {
				NormalUserController normalUserController = new NormalUserController();
				normalUserController.normalUserLayout();
			}
			else {
				ViewerController viewerController = new ViewerController();
				viewerController.viewerLayout();
			}
		}
		catch(Exception e) {
			
		}
	}
}
