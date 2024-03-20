package com.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Console.ConsoleService;
import com.Dbms.UserRepository;

public class UserService {

	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepository();
	}

	public UserInfoDTO searchUser(String userEmail) throws ClassNotFoundException, SQLException {
		UserInfoDTO userInfoDTO = null;
		ResultSet result = userRepository.searchUser(userEmail);
		if(result != null && result.next()) {
			userInfoDTO = new UserInfoBuilder()
					.setUserName(result.getString("Name"))
			        .setEmail(result.getString("EmailId"))
			        .setPassword(result.getString("Password"))
			        .setUserType(result.getString("Type"))
			        .build();
		}
		return userInfoDTO;
	}
	
	public int addUser(UserInfoDTO userInfoDTO) throws IOException, ClassNotFoundException, SQLException {
		File info = new File("UserInfo.txt");
		info.createNewFile();
		PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("UserInfo.txt", true)));
		printWriter.println("Name" + userInfoDTO.userName);
		printWriter.println("EmailId" + userInfoDTO.email);
		printWriter.println("Password" + userInfoDTO.password);
		printWriter.println("Type" + userInfoDTO.userType);
		printWriter.println("\n");
		
        int rowInserted = userRepository.insertUserRow(userInfoDTO);
		return rowInserted;
	}

	public int modify(UserInfoDTO userInfoDTO) throws ClassNotFoundException, SQLException {
		System.out.println("Enter the value of the fields you want update and "
				+ "if you do not want update provide existing values");
		String updatedName = ConsoleService.getUserInput("Enter the name:");
		String updatedEmailId = ConsoleService.getUserInput("Enter the emailId:");
		String updatedPassword = ConsoleService.getUserInput("Enter your email password: ");
		UserInfoDTO updatedUserInfoDTO = new UserInfoBuilder().setUserName(updatedName).setEmail(updatedEmailId)
				.setPassword(updatedPassword).build();
		int rowUpdate = userRepository.updateUserInfo(userInfoDTO, updatedUserInfoDTO);

		return rowUpdate;
	}
}
