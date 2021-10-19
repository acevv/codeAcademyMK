package setExamples;

public class Car {
	
	private String model;
	private Integer year;
	private String brand;
	private String color;
	private CarType type;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String model, Integer year, String brand, String color, CarType type) {
		super();
		this.model = model;
		this.year = year;
		this.brand = brand;
		this.color = color;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + ", brand=" + brand + ", color=" + color + ", type=" + type
				+ "]";
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public CarType getType() {
		return type;
	}
	public void setType(CarType type) {
		this.type = type;
	}
	
	
}
