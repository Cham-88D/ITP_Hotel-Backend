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

import com.itp.hotel.model.ResOrder;

import com.itp.hotel.exception.*;
import com.itp.hotel.repository.ResOredrReposiyory;

@CrossOrigin(origins ="http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")

public class Res_Order_Controller {
	@Autowired
	private  ResOredrReposiyory  res_Oredr_Reposiyory;
	
	//get all orders
	@GetMapping("/res_order")
	public List<ResOrder> getRes_Orders(){
		return res_Oredr_Reposiyory.findAll();
	}
	
	//insert menu items
		@PostMapping("/res_order")
		public ResOrder insertRes_Order(@RequestBody  ResOrder res_Order){
			return res_Oredr_Reposiyory.save(res_Order);
		}

		
		//get order id
		@GetMapping("/res_order/{menu_order_id}")
		public ResponseEntity<ResOrder> getRes_Order_by_id(@PathVariable Long menu_order_id) {
				
			ResOrder rest_order = res_Oredr_Reposiyory.findById(menu_order_id)
					.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+menu_order_id));
			return ResponseEntity.ok(rest_order);
			
			
			
		}
		
		
}
