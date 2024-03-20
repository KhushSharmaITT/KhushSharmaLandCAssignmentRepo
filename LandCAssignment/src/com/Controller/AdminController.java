package com.Controller;

import java.io.IOException;
import java.sql.SQLException;

import com.Console.ConsoleService;
import com.User.UserInfoBuilder;
import com.User.UserInfoDTO;
import com.User.UserService;

public class AdminController {

	private UserService userService;

	public AdminController() {
		this.userService = new UserService();
	}

	void adminlayout() throws IOException, ClassNotFoundException, SQLException {
		String choice = ConsoleService.getUserInput("Enter the attribute choice \n 1.Add \n 2.View \n 3.Modify");
		switch (choice) {
		case "1":
			addUser();
			break;

		case "2":
			viewUser();
			break;

		case "3":
			modifyUser();
			break;

		}
	}
	
	private void viewUser() throws ClassNotFoundException, SQLException {
		String userEmail = ConsoleService.getUserInput("Enter the emailId:");
		UserInfoDTO userInfoDTO = userService.searchUser(userEmail);
		if (userInfoDTO == null) {
			System.out.println("No user found");
		} else {
			System.out.println("Name :" + userInfoDTO.userName + "\n" + "EmailId :" + userInfoDTO.email + "\n"
					+ "Type :" + userInfoDTO.userType);
		}
	}
	
	private void addUser() throws ClassNotFoundException, IOException, SQLException {
		String name = ConsoleService.getUserInput("Enter the name:");
	    String emailId = ConsoleService.getUserInput("Enter the emailId:");
	    String password = ConsoleService.getUserInput("Enter your email password: ");
	    String userType = ConsoleService.getUserInput("Enter your user type ");
		UserInfoDTO userInfoDTO = new UserInfoBuilder().setUserName(name).setEmail(emailId).setPassword(password).setUserType(userType)
				.build();
		int rowInserted = userService.addUser(userInfoDTO);
		System.out.println("Row Inserted :" + rowInserted + "\n" + "Record Inserted Successfully");
	}
	
	private void modifyUser() throws ClassNotFoundException, SQLException {
		String name = ConsoleService.getUserInput("Enter the name:");
	    String emailId = ConsoleService.getUserInput("Enter the emailId:");
	    String password = ConsoleService.getUserInput("Enter your email password: ");
		UserInfoDTO userInfoDTO = new UserInfoBuilder().setUserName(name).setEmail(emailId).setPassword(password)
				.build();
		int rowUpdate = userService.modify(userInfoDTO);
		System.out.println("Row Inserted :" + rowUpdate + "\n" + "Record Updated Successfully");
	}
}
