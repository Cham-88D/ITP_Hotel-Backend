package com.itp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.Beverage;
import com.itp.hotel.service.BeverageService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class BeverageController {
	@Autowired
	private BeverageService beverageService;

	// view all
	@GetMapping("/beverages")
	public ResponseEntity<List<Beverage>> getAllBeverage() {
		try {
			return ResponseEntity.ok(beverageService.listAll());
		}catch(Exception e) {
			throw e;
		}
	}

	// insert beverage items
	@PostMapping("/beverages")
	public ResponseEntity<Beverage> insertBeverages(@RequestBody Beverage beverage) {
		try {
			beverageService.save(beverage);
			return ResponseEntity.ok(beverage);
		}catch(Exception e) {
			throw e;
		}
	}

	// get beverage id
	@GetMapping("/beverages/{id}")
	public ResponseEntity<Beverage> getBeverage_item_by_id(@PathVariable Long id) {

		try {
			Beverage beverage_item = beverageService.get(id);
			return ResponseEntity.ok(beverage_item);
		}catch(ResourceNotFoundException e) {
			throw e;
		}
	}

	// update beverage item details
	@PutMapping("/beverages/{id}")
	public ResponseEntity<Beverage> updateBeverageItems(@PathVariable Long id, @RequestBody Beverage beverage_detail) {

		try {
			Beverage beverage_item = beverageService.get(id);
			
			beverage_item.setB_Type(beverage_detail.getB_Type());
			beverage_item.setB_Name(beverage_detail.getB_Name());
			beverage_item.setUnit_Price(beverage_detail.getUnit_Price());
			beverage_item.setDescription(beverage_detail.getDescription());
			beverage_item.setDiscount(beverage_detail.getDiscount());
			
			beverageService.save(beverage_item);
			return ResponseEntity.ok(beverage_item);
		}catch(ResourceNotFoundException e) {
			throw e;
		}
	}

	// delete menu items details
	@DeleteMapping("/beverages/{id}")
	public ResponseEntity<String> deleteBeverageItems(@PathVariable Long id) {

		try {
			 beverageService.delete(id);
			 return ResponseEntity.ok("Successfully Deleted!");
		}catch(ResourceNotFoundException e) {
			throw e;
		}
	}

}
