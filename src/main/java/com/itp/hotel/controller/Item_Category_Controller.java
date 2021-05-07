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

import com.itp.hotel.model.MenuItemCategory;
import com.itp.hotel.exception.*;
import com.itp.hotel.repository.ItemCategoryRepository;

@CrossOrigin(origins ="http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")

public class Item_Category_Controller {
	
	
	@Autowired
	private ItemCategoryRepository item_Category_repository;
	
	//get all menu items category
	@GetMapping("/menu_item_category")
	public List<MenuItemCategory> get_Menu_item_category(){
		return item_Category_repository.findAll();
	}
	
	//insert menu items category
	@PostMapping("/menu_item_category")
	public MenuItemCategory insert_Menu_item_category(@RequestBody   MenuItemCategory item_category){
		return item_Category_repository.save(item_category);
	}
	//get item type by id
	@GetMapping("/menu_item_category/{id}")
	public ResponseEntity<MenuItemCategory> getMenu_item_by_id(@PathVariable Long id) {
			
		 MenuItemCategory item_category = item_Category_repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+id));
		return ResponseEntity.ok(item_category);
		
		
		
	}

	
	

}
