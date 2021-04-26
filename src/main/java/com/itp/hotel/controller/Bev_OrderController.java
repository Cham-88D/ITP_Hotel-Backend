package com.itp.hotel.controller;

import java.util.List;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itp.hotel.model.Bev_Order;
import com.itp.hotel.model.Beverage;
import com.itp.hotel.model.ResourceNotFoundException;
import com.itp.hotel.repository.Bev_OrderRepository;

public class Bev_OrderController {
	
	private Bev_OrderRepository bev_OrderRepository;
	
	@GetMapping("/bev_order")
	public List<Bev_Order> getAllBev_Orders(){
		return bev_OrderRepository.findAll();
	}
	
	
	@PostMapping("/bev_order")
	public Bev_Order insertBevOrders(@RequestBody   Bev_Order bevorders){
		return bev_OrderRepository.save(bevorders);
	}
	
	
	@GetMapping("/bev_order/{bev_order_id}")
	public ResponseEntity<Bev_Order> getBeverage_order_by_id(@PathVariable Long bev_order_id) {
			
		Bev_Order beverage_order = bev_OrderRepository.findById(bev_order_id)
				.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+bev_order_id));
		return ResponseEntity.ok(beverage_order);

}
	
}
