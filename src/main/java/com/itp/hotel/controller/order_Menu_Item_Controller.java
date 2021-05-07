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

import com.itp.hotel.model.OrderMenuItem;

import com.itp.hotel.exception.*;

import com.itp.hotel.repository.OrderMenuItemRepository;



@CrossOrigin(origins ="http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")
public class order_Menu_Item_Controller {
	
	@Autowired
	private OrderMenuItemRepository  order_Menu_Item_repository;
	 
	//get all menu items
	@GetMapping("/order_menu_item")
	public List<OrderMenuItem> getRes_Menu_items(){
		return order_Menu_Item_repository.findAll();
	}
	
	//insert
	@PostMapping("/order_menu_item")
	public OrderMenuItem insertorder_Menu_item(@RequestBody   OrderMenuItem order_Menu_item){
		return order_Menu_Item_repository.save(order_Menu_item);
	}
	
	
	@GetMapping("/order_menu_item/{id}")
	public ResponseEntity<OrderMenuItem> getMenu_item_by_id(@PathVariable Long id) {
			
		OrderMenuItem order_menu_item = order_Menu_Item_repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("order menu item not exit with this key: "+id));
		return ResponseEntity.ok(order_menu_item);
		
		
		
	}
	

}
