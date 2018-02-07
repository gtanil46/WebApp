package cardealer.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cardealer.model.Car;
import cardealer.mysql.DBConnection;

public class ListCarService {

	static ArrayList<Car> cars = new ArrayList<Car>();
	
//	static {
//		cars.add(new Car("1", "Toyota", "Prius", 2008));
//		cars.add(new Car("2", "Toyota", "Prius", 2009));
//		cars.add(new Car("3", "Toyota", "Prius", 2010));
//		}

	public List<Car> getCars()
	{
		Connection con = DBConnection.getConnection();
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		try {
			stmt = con.prepareStatement("select * from cars");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Car car = new Car();
				car.setVin(rs.getString(1));
				car.setMake(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setYear(rs.getInt(4));
				cars.add(car);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(cars);
		return cars;
	}
	
	public List<Car> retrieveCars() {
		return cars;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void deleteCar(Car car) {
		cars.remove(car);
	}
}
