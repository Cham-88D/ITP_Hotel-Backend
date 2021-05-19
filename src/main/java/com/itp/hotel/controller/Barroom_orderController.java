package com.itp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.service.Barroom_OrderService;

@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class Barroom_orderController {

	@Autowired
	private Barroom_OrderService barroom_OrderService;

	@GetMapping("/barroom_Order")
	public List<Barroom_Order> getAllbarOrder() {

		return barroom_OrderService.listAll();
	}

	// insert order items
	@PostMapping("/bar-room-order")
	public ResponseEntity<Barroom_Order> insertBarOrders(@RequestBody Barroom_Order barroom_order) {
		try {
			barroom_OrderService.save(barroom_order);
			return ResponseEntity.ok(barroom_order);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/bar-room-order/{id}")
	public ResponseEntity<Barroom_Order> getBarroom_order_by_id(@PathVariable Long id) {
		try {
			Barroom_Order barroom_order = barroom_OrderService.get(id);
			return ResponseEntity.ok(barroom_order);
		} catch (Exception e) {
			throw e;
		}

	}
	
	@PutMapping("/bar-room-order/{id}")
	public ResponseEntity<Barroom_Order> updateBaroom_order(@PathVariable Long id){
		try {
			Barroom_Order barroom_order = barroom_OrderService.get(id);
			Barroom_Order newObj = new Barroom_Order();
			newObj.setBarroom_order_ID(id);
			newObj.setOrderDate(barroom_order.getOrderDate());
			newObj.setStatus("completed");
			try {
				barroom_OrderService.save(newObj);
				try {
					return ResponseEntity.ok(barroom_OrderService.get(id));
				}catch(Exception e) {
					throw e;
				}
			}catch(Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
