package com.projecttwo.controller;



import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projecttwo.entity.BuyerInfo; 
import com.projecttwo.entity.VehicleList;
import com.projecttwo.entity.Vehicles;  


@Controller
public class VehicleController{ 
	
	private int counter = 0;
	private Vehicles savedVehicle;

	@Autowired
	VehicleList vehicleLists;
	
	
	@GetMapping("/")
	public String welcome(Model model) {
		return "index";
	}
	  @GetMapping("/about")
	    public String about(Model model) {
	        return "about";
	    }
	@GetMapping("/inventory")
	public String home(Model model) {
		System.out.println("inventory");
		if(counter == 0) {
			vehicleLists.vehicleList();
			counter++;
		}
		
		model.addAttribute("arr", vehicleLists.inventory);
		return "inventory";
	}
	
	// Measures # of days a vehicles has been on the lot, either more or less than
	// 120 days. Allows either the option to buy at full price or to bid at
	// a discount.
	@GetMapping("/inventory-data")
	public ModelAndView moreInfo(Model model, Integer info , HttpSession session) {
		Vehicles clickedVehicle = vehicleLists.vehicleFinder(info); 
		Vehicles savedVehicle = clickedVehicle;
		System.out.println("postMappingController");
		System.out.println(clickedVehicle);
		if(clickedVehicle.getDays() >= 120) {
			model.addAttribute("vehicleInfo", clickedVehicle); 
			System.out.println("make bid " + clickedVehicle.getVehIdNum()); // change to VehIdNum
			return new ModelAndView("makeBid", "buyer", new BuyerInfo());
		}
		model.addAttribute("vehicleInfo", clickedVehicle);
		System.out.println("buyfullPrice " + clickedVehicle.getVehIdNum());
		return new ModelAndView("buyFullPrice", "buyer", new BuyerInfo());
		
	}
	
	@PostMapping("/thankYou")
	//The Model Attribute will map to the html model attribute 
	public String handleSave(Model model, @ModelAttribute("buyer")BuyerInfo buyer, HttpSession session) {
		System.out.println("vehIdNum number: " + buyer.getVehicles().getVehIdNum());
	
		vehicleLists.saveBuyer(buyer);
		model.addAttribute("buyer", buyer);
	
		return "thankYou";
		
	}
		
	@PostMapping("/thankYouBid")
	//The Model Attribute will map to the html model attribute 
	public String handleSaveBid(Model model, @ModelAttribute("buyer")BuyerInfo buyer, HttpSession session) {
		System.out.println("Vehicle ID number: " + buyer.getVehicles().getVehIdNum());
	
		vehicleLists.saveBuyer(buyer);
		model.addAttribute("buyer", buyer);
	
		return "thankYouBid";
		
	}
	@GetMapping("/report")
	public String report(Model model) {
		System.out.println("reports page");
		model.addAttribute("arr_sold", vehicleLists.buyers);
		model.addAttribute("arr", vehicleLists.inventory);
		return "report";
	}
	  @GetMapping("/search")
	    public String search(Model model) {
		  System.out.println("search mapping");
		  model.addAttribute("searchVehicle", new Vehicles());
	        return "search";
	    
	  }
		@PostMapping("/search")
		//The Model Attribute will map to the html model attribute 
		public String search(Model model, @ModelAttribute("searchVehicle")Vehicles searchVehicle, HttpSession session) {
			
			ArrayList<Vehicles> searchList = vehicleLists.search(searchVehicle.getMake());
			model.addAttribute("searchList", searchList);
			return "search";		
		}
	  
}








