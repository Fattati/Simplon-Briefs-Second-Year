package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.User;

public class UserDaoImp implements UserDao {

	@Override
	public String saveUser(User user) {
		String name = user.getName();
		String email = user.getEmail();
		String password = user.getPassword();
		String role = user.getRole();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.getConnection();
			String query = "INSERT INTO users(name, email, password,role) values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, role);
			
			int i=preparedStatement.executeUpdate();
			if (i!=0) 
				return "Succes";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error";
	}

//		Connection connection=DatabaseConnection.getConnection();
//		try {
//			PreparedStatement ps=connection.prepareStatement("INSERT INTO USERS (name, email, password) VALUES (?,?,?)");
//			ps.setString(1, user.getName());
//			ps.setString(2, user.getEmail());
//			ps.setString(3, user.getPassword());
//			ps.executeUpdate(); //execute query
//			ps.close(); //close object statement
//			//connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


	@Override
	public List<User> search(String n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
