package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.DatabaseConnection;
import web.UserModel;

public class LoginForm  {
	public UserModel checkLogin(String email, String password) throws SQLException{
	Connection connection=DatabaseConnection.getConnection();
	String sql= "SELECT * FROM users Where email = ? and password = ?";
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.setString(1, email);
	statement.setString(2, password);
	ResultSet result = statement.executeQuery();
	UserModel user = null;
	if (result.next()) {
		user = new UserModel();
		//user.setName(result.getString("name"));
		user.setEmail(email);
		user.setRole(result.getString("role"));
	}
	//connection.close();
	return user;
	
	}
}
