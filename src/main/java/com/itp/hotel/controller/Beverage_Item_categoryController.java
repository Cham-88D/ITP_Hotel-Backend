package com.itp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.Beverage_Item_Category;
import com.itp.hotel.repository.Beverage_Item_CategoryRepository;
@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class Beverage_Item_categoryController {
	
	@Autowired
    public Beverage_Item_CategoryRepository beverage_Item_CategoryRepository;	
	
	
	@GetMapping("/beverage_item_category")
	public List<Beverage_Item_Category> getAllBevCategory(){
		
		return beverage_Item_CategoryRepository.findAll();
	}
	
	//insert
	@PostMapping("/beverage_item_category")
	public Beverage_Item_Category insertBevCategory(@RequestBody  Beverage_Item_Category category ){
		return beverage_Item_CategoryRepository.save(category);
	}
	
	
	//get category 
			@GetMapping("/beverage_item_category/{bev_id}")
			public ResponseEntity<Beverage_Item_Category> getCategory_id(@PathVariable Long bev_id) {
					
				Beverage_Item_Category beverage_Item_Category = beverage_Item_CategoryRepository.findById(bev_id)
						.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+bev_id));
				return ResponseEntity.ok(beverage_Item_Category);
				
				
				    
			}
	
	
}
