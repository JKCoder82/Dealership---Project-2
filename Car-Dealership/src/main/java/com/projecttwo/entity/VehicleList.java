package com.projecttwo.entity;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class VehicleList {

	public List<BuyerInfo> buyers = new ArrayList<BuyerInfo>();
	public ArrayList<Vehicles> inventory = new ArrayList<Vehicles>();

	public void vehicleList() {
		inventory.add(new Vehicles("New", "Dodge", "Charger SRT-Redeye-31", "$42,461", "Brand new!", 2021, "White", 54, "image/image1.jpg", 1, 25, true));
		inventory.add(new Vehicles("New", "Chevrolet", "Colorado", "$28,337", "Brand new!", 2020, "Blue", 325000, "image/image2.jpg", 2, 60, true));
		inventory.add(new Vehicles("Used", "GMC", "V6-AT4-24", "$19,998", "Minimal mileage, great value.", 2019, "White", 125000, "image/image3.jpg", 3, 55, true));
		inventory.add(new Vehicles("Used", "Jeep", "Gladiator", "$23,998", "Minimal mileage, great value.", 2019, "Red", 1000000, "image/image4.jpg", 4, 2, true));
		inventory.add(new Vehicles("New", "Toyota", "Tacoma", "$31,200", "Brand new!", 2021, "Dark Gray", 20, "image/image5.jpg", 5, 150, true));
		inventory.add(new Vehicles("New", "Nissan", "Frontier", "$36,200", "Brand new!", 2021, "Burgundy", 326584, "image/image6.jpg", 6, 96, true));
		inventory.add(new Vehicles("Used", "Ford", "F-150-Lightning", "$24,998", "Minimal mileage, great value.", 2019, "Light Gray", 236, "image/image7.jpg", 7, 121, true));
		inventory.add(new Vehicles("New", "GMC", "Hummer-EV-03", "$24,998", "Brand new!", 2021, "White", 369258154, "image/image8.jpg", 8, 500, true));
		inventory.add(new Vehicles("New", "Rivian", "R1T", "$34,998", "Brand new!", 2021, "Off Yellow", 254, "image/image9.jpg", 9, 20, true));
		inventory.add(new Vehicles("New", "Dodge", "Ram-2500", "$38,998", "Brand new!", 2021, "Sea Blue", 0, "image/image10.jpg", 10, 1, true));

		System.out.println("vehicleList contents");
		
		System.out.println(inventory.get(0).getMake());

	}

	public ArrayList<Vehicles> search(String make) {
		        ArrayList<Vehicles> searchResults = new ArrayList<>();
		        System.out.println("inside search method: " +make);
		        for (Vehicles vehicle : inventory) {
		            if (vehicle.getMake().equalsIgnoreCase(make)) {
		            	if(vehicle.isForSale() == true) {
		            		searchResults.add(vehicle);
		            		System.out.println("Vehicle added");
		            	}
		            }
		        }

		        return searchResults;
		    }
		
	public void saveBuyer(BuyerInfo buyer) {
		for (Vehicles search : inventory) {
			if (buyer.getVehicles().getVehIdNum() == search.getVehIdNum()) {
				
				BuyerInfo soldVehicle = new BuyerInfo();
				soldVehicle.setVehicles(search);
				soldVehicle.setFirstName(buyer.getFirstName());
				soldVehicle.setLastName(buyer.getLastName());
				soldVehicle.setEmail(buyer.getEmail());
				soldVehicle.setAmount(buyer.getAmount());
				
				buyer = soldVehicle;
				
				System.out.println("This vehicle has been sold: " + buyer);
				buyers.add(buyer);
			}
		}
		
		
		// This section of code needs improvement.
		// ********************************************************
		// This code removes the vehicles from the inventory; however,
		// I get an error message after I click "Purchase Now." If I comment this 
		// code out, the error message goes away, but after a purchase, the vehicle
		// can still be purchased from the inventory. 
		
		for(Vehicles search : inventory) {
			if(buyer.getVehicles().getVehIdNum() == search.getVehIdNum()) {
		}
				inventory.remove(search);
			}
	

		// ....until this section, which ends here. If I comment-out
		// the above lines of code, the program works visually better, but 
		// functionally worse. 
		// **********************************************

	}

	public Vehicles vehicleFinder(int vehIdNum) {
		for (Vehicles selected : inventory) {
			if (vehIdNum == selected.getVehIdNum()) {
				System.out.println("vehiclefinder");

				return selected;
			}
		}
		return inventory.get(0);
	}

	public ArrayList<Vehicles> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Vehicles> inventory) {
		this.inventory = inventory;
	}

	public List<BuyerInfo> getBuyers() {
		return buyers;
	}

	public void setBuyers(List<BuyerInfo> buyers) {
		this.buyers = buyers;
	}

}



