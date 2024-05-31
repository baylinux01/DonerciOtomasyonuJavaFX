package kodcu.DonerciOtomasyonuJavaFXMaven;

import java.time.LocalDate;

public class Product {
	private String name;
	private String property="";
	private int number;
	private double price;
	private double total;
	private String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", property=" + property + ", number=" + number + ", price=" + price
				+ ", total=" + total + ", date=" + date + "]";
	}
	
	
	
	
	

}
