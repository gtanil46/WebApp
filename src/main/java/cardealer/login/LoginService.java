package cardealer.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cardealer.model.User;
import cardealer.mysql.DBConnection;

public class LoginService {

	public boolean isUserValid(String user, String password, String type) {
		
		User userObj = new User();
		User userLogObj = new User();
		Connection con = DBConnection.getConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("select username, password, type from users where username=?");
			stmt.setString(1, user);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
	            userObj.setName(rs.getString("username"));
	            userObj.setPassword(rs.getString("password"));
	            userObj.setType(rs.getString("type"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userLogObj.setName(user);
		userLogObj.setPassword(password);
		userLogObj.setType(type);
		
		if (userObj.equals(userLogObj))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
