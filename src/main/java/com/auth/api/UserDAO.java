package com.auth.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public static boolean registerUser(String username, String password) {
		String query = "INSERT INTO users (username, password) VALUES (?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1,  username);
			stmt.setString(2,  password);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean authUser(String username, String password) {
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet resultSet = stmt.executeQuery();
			return resultSet.next();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
