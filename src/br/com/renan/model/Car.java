package br.com.renan.model;


public class Car {
	
	private int id;
	private String brand;
	private String model;
	private String website;
	
	public Car(){
		
	}
	
	public Car(String brand, String model, String website) {
		this.brand = brand;
		this.model = model;
		this.website = website;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
