package cardealer.mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public static Connection getConnection() {
		
		Connection con = null;
		Properties p = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\gtani\\eclipse-workspace\\car-dealer\\src\\main\\resources\\properties.db");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Properties not found");
			e1.printStackTrace();
		}
		
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://"+p.getProperty("host")+":"+p.getProperty("port")+"/"+p.getProperty("database");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, p.getProperty("username"), p.getProperty("password"));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
