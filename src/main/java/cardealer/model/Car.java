package cardealer.model;

public class Car {

	private String vin;
	private String make;
	private String model;
	private int year;
	

	public Car() {
	}
	
	public Car(String vin, String make, String model, int year) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return String.format("Car [vin=%s, make=%s, model=%s, year=%s]", vin, make, model, year);
	}

}
