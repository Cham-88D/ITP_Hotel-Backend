package com.itp.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.Beverage;
import com.itp.hotel.repository.BeverageRepository;

@Service
public class BeverageService {

	@Autowired
	private BeverageRepository repo;
	
	public List<Beverage> listAll(){
		List<Beverage> beverages = repo.findAll();
		List<Beverage> formattedBeverages = new ArrayList<Beverage>();
		for(Beverage b :beverages ) {
			Beverage newBevObj = new Beverage();
			newBevObj.setBev_ID(b.getBev_ID());
			newBevObj.setB_Name(b.getB_Name());
			newBevObj.setB_Type(b.getB_Type());
			newBevObj.setDescription(b.getDescription());
			newBevObj.setDiscount(b.getDiscount());
			newBevObj.setUnit_Price(b.getUnit_Price());
			formattedBeverages.add(newBevObj);
		}
		return formattedBeverages;
	}
	
	public void save(Beverage beverage) {
		repo.save(beverage);
	}
	
	public Beverage get(long id) {
		Beverage b = repo.findById(id).get();
		Beverage newBevObj = new Beverage();
		newBevObj.setBev_ID(b.getBev_ID());
		newBevObj.setB_Name(b.getB_Name());
		newBevObj.setB_Type(b.getB_Type());
		newBevObj.setDescription(b.getDescription());
		newBevObj.setDiscount(b.getDiscount());
		newBevObj.setUnit_Price(b.getUnit_Price());
		
		return  newBevObj;
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
