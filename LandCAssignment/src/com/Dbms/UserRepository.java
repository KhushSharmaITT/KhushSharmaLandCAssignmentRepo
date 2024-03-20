package com.Dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JDBC.DatabaseManager;
import com.User.UserInfoDTO;

public class UserRepository {

	private Connection connection;

	public UserRepository() {
		this.connection = DatabaseManager.getConnection(); 
	}

	public int insertUserRow(UserInfoDTO userInfoDTO) throws ClassNotFoundException, SQLException {
		String query = "INSERT into userInfo(Name,EmailId,Password,Type)value(?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, userInfoDTO.userName);
		stmt.setString(2, userInfoDTO.email);
		stmt.setString(3, userInfoDTO.password);
		stmt.setString(4, userInfoDTO.userType);
		int row = stmt.executeUpdate();
		return row;
	}

	public ResultSet searchUser(String userEmail) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM userInfo WHERE EmailId=?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, userEmail);
		ResultSet result = stmt.executeQuery();
		return result;
	}

	public int updateUserInfo(UserInfoDTO userInfoDTO, UserInfoDTO updatedUserInfoDTO)
			throws ClassNotFoundException, SQLException {
		String query = "UPDATE userInfo SET Password =?, Name = ?,EmailId = ? WHERE EmailId = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, updatedUserInfoDTO.password);
		stmt.setString(2, updatedUserInfoDTO.userName);
		stmt.setString(3, updatedUserInfoDTO.email);
		stmt.setString(4, userInfoDTO.email);
		int row = stmt.executeUpdate();
		return row;

	}
}