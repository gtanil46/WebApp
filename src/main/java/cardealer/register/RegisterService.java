package cardealer.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cardealer.model.User;
import cardealer.mysql.DBConnection;

public class RegisterService {
	public int registerUser(String user, String password, String type) {

		User newUser = new User();
		newUser.setName(user);
		newUser.setPassword(password);
		newUser.setType(type);
		
		System.out.println(newUser);

		Connection con = DBConnection.getConnection();

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("insert into users values (?, ?, ?)");
			stmt.setString(1, newUser.getName());
			stmt.setString(2, newUser.getPassword());
			stmt.setString(3, newUser.getType());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
