package com.itp.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.itp.hotel.model.Beverage;
import com.itp.hotel.model.ResourceNotFoundException;
import com.itp.hotel.repository.BeverageRepository;
@CrossOrigin(origins ="http://localhost:3000" )
@RestController
@RequestMapping("/api/v1/")

public class BeverageController {
	@Autowired
	private BeverageRepository beverageRepository;
	
	@GetMapping("/beverages")
	public List<Beverage> getAllBeverage(){
		return beverageRepository.findAll();
	}
	
	//insert beverage items
		@PostMapping("/beverages")
		public Beverage insertBeverages(@RequestBody   Beverage beverage){
			return beverageRepository.save(beverage);
		}
		/*@GetMapping("/supplier/{sid}")
	    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "sid") Long SId)
	        throws ResourceNotFoundException {
	        Supplier supplier = supplierRepository.findById(SId)
	          .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + SId));
	        return ResponseEntity.ok().body(supplier);
	    }*/


		//get beverage id
		@GetMapping("/beverages/{id}")
		public ResponseEntity<Beverage> getBeverage_item_by_id(@PathVariable Long id) {
				
			Beverage beverage_item = beverageRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
			return ResponseEntity.ok(beverage_item);
			
			
			
		}
		
		//update beverage item details
		@PutMapping("/beverages/{id}")
		public ResponseEntity<Beverage> updateBeverageItems(@PathVariable Long id,@RequestBody Beverage beverage_detail){
			
			Beverage beverage_item = beverageRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
			
		    beverage_item.setB_Type(beverage_detail.getB_Type());
		    beverage_item.setB_Name(beverage_detail.getB_Name());
		    beverage_item.setUnit_Price(beverage_detail.getUnit_Price());
			beverage_item.setDescription(beverage_detail.getDescription());
			beverage_item.setDiscount(beverage_detail.getDiscount());
			
			
			
		Beverage updateBeverage_item=	beverageRepository.save(beverage_item);
		return ResponseEntity.ok(updateBeverage_item);
			
		}
		
		
		//delete menu items details
		@DeleteMapping("/beverages/{id}")
		public ResponseEntity< Map<String, Boolean>> deleteBeverageItems(@PathVariable Long id){
			
			Beverage beverage_item = beverageRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
			
			beverageRepository.delete(beverage_item);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return ResponseEntity.ok(response);
			
			
		}








}
