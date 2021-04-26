package com.itp.hotel.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.Beverage;
import com.itp.hotel.model.ResourceNotFoundException;
import com.itp.hotel.repository.Barroom_orderRepository;


@RestController
@RequestMapping("/api/v1/")

public class Barroom_orderController {
	
	@Autowired
	private Barroom_orderRepository barroom_orderRepository;
	
	@GetMapping("/barroom_Order")
	
	public List<Barroom_Order> getAllbarOrder(){
		
		return barroom_orderRepository.findAll();
	}
	
	//insert order items
			@PostMapping("/barroom_order")
			public Barroom_Order insertBarOrders(@RequestBody   Barroom_Order barroom_order){
				return barroom_orderRepository.save(barroom_order);
			}
			
			
			
			@GetMapping("/barroom_order/{bar_ID}")
			public ResponseEntity<Barroom_Order> getBarroom_order_by_id(@PathVariable Long bar_ID) {
					
				Barroom_Order barroom_order = barroom_orderRepository.findById(bar_ID)
						.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+bar_ID));
				return ResponseEntity.ok(barroom_order);
				
				
				
			}
	

}
