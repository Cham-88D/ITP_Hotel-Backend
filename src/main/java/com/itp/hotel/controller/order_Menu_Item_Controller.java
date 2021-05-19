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
import com.itp.hotel.model.ResMenuItem;
import com.itp.hotel.model.ResOrder;
import com.itp.hotel.exception.*;

import com.itp.hotel.repository.OrderMenuItemRepository;
import com.itp.hotel.service.OrderMenuItemService;
import com.itp.hotel.service.ResOrderService;



@CrossOrigin(origins ="http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")
public class order_Menu_Item_Controller {
	
	@Autowired
	private OrderMenuItemRepository  order_Menu_Item_repository;
	@Autowired
	private OrderMenuItemService orderMenuItemService;
	@Autowired
	private ResOrderService resOrderService;
	
	//get all menu items
	@GetMapping("/order_menu_item")
	public List<OrderMenuItem> getRes_Menu_items(){
		return order_Menu_Item_repository.findAll();
	}
	
	@PostMapping("/order_menu_item")
	public ResponseEntity insert(@RequestBody OrderMenuItem o) {
		try {
			orderMenuItemService.save(o);
			return ResponseEntity.ok("Saved order line successfully!");
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/order_menu_item/{id}")
	public ResponseEntity getMenuOrdersByOrderId(@PathVariable Long id) {
		try {
			ResOrder ro = resOrderService.get(id);
			List<Object> orderItems = orderMenuItemService.getMenuOrdersByOrderId(ro);
			return ResponseEntity.ok(orderItems);
		} catch (Exception e) {
			throw e;
		}
	}
	

}
