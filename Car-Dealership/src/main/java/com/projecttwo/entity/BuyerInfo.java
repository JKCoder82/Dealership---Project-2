package com.projecttwo.entity;

public class BuyerInfo {

	private String firstName;
	private String lastName;
	private String email;
	private boolean bid;
	private Vehicles vehicles;
	private String amount;
	
	
	
	
	public BuyerInfo(String firstName, String lastName, String email, boolean bid, Vehicles vehicles, String amount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bid = bid;
		this.vehicles = vehicles;
		this.amount = amount;
		
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public BuyerInfo() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isBid() {
		return bid;
	}
	public void setBid(boolean bid) {
		this.bid = bid;
	}
	public Vehicles getVehicles() {
		return vehicles;
	}
	public void setVehicles(Vehicles vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "BuyerInfo [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", bid=" + bid
				+ ", vehicles=" + vehicles +  "]";
	}

	
}
