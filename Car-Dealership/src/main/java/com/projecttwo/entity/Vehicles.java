package com.projecttwo.entity;

import java.util.ArrayList;

public class Vehicles {

	String condition; 
	String make;
	String model;
	String price;
	String description;
	int year;
	String color;
	int mileage; 
	String image; 
	int vehIdNum;
	int days;
	boolean forSale;
	

	public Vehicles() {

	}

	public Vehicles(String condition, String make, String model, String price, String description, int year, String color, int mileage, String image, int vehIdNum, int days, boolean forSale) { 
		super();
		this.condition = condition; // I added this.... new or used.
		this.make = make; //
		this.model = model; //
		this.price = price; //
		this.description = description; //
		this.year = year; //
		this.color = color;
		this.mileage = mileage; //
		this.image = image; //
		this.vehIdNum = vehIdNum; //
		this.days = days; // I might remove "days"
		this.forSale = forSale;
		
	}
	

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getVehIdNum() {
		return vehIdNum;
	}

	public void setVehIdNum(int vehIdNum) {
		this.vehIdNum = vehIdNum;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}

	// String toString() Method used here........
	@Override
	public String toString() {
		return "Vehicles [condition=" + condition + ", make=" + make + ", model=" + model + ", price=" + price + ", description=" + description
				+ ", year=" + year + ", color=" + color + ", mileage=" + mileage + ", image=" + image + ", vehIdNum=" + vehIdNum
				+ ", days=" + days + ", forSale=" + forSale + "]";
	}
}
	

	
