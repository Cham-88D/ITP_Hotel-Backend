package com.itp.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "food_details")
public class FoodDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_Id")
	private int Food_Id;
	
	@Column(name = "Food_Name",length=50)
	private String Food_Name;
	
	@Column(name = "Food_Type",length=30)
	private String Food_Type;
	
	@Column(name = "Availability")
	private int Availability;
	
	@Column(name = "Unit_Price")
	private String Unit_Price;
	
	
	
	public FoodDetails() {
		
	}



	public FoodDetails(int food_Id, String food_Name, String food_Type, int availability, String unit_Price) {
		super();
		Food_Id = food_Id;
		Food_Name = food_Name;
		Food_Type = food_Type;
		Availability = availability;
		Unit_Price = unit_Price;
	}



	public void setFood_Id(int food_Id) {
		Food_Id = food_Id;
	}



	public void setFood_Name(String food_Name) {
		Food_Name = food_Name;
	}



	public void setFood_Type(String food_Type) {
		Food_Type = food_Type;
	}



	public void setAvailability(int availability) {
		Availability = availability;
	}



	public void setUnit_Price(String unit_Price) {
		Unit_Price = unit_Price;
	}



	public int getFood_Id() {
		return Food_Id;
	}



	public String getFood_Name() {
		return Food_Name;
	}



	public String getFood_Type() {
		return Food_Type;
	}



	public int getAvailability() {
		return Availability;
	}



	public String getUnit_Price() {
		return Unit_Price;
	}



	
	

}
