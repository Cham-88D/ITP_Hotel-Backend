package com.itp.hotel.controller;

import java.util.ArrayList;
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

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.BevOrder;
//import com.itp.hotel.model.Bev_Order;
import com.itp.hotel.service.Barroom_OrderService;
import com.itp.hotel.service.BevOrderService;
//import com.itp.hotel.repository.Bev_OrderRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class Bev_OrderController {

	@Autowired
	private BevOrderService bevOrderService;
	@Autowired
	private Barroom_OrderService barroom_OrderService;

	@GetMapping("/bev-order")
	public List<BevOrder> getAllBev_Orders() {
		return bevOrderService.listAll();
	}

	@PostMapping("/bev-order")
	public ResponseEntity insertBevOrders(@RequestBody BevOrder bevOrder) {
		try {
			bevOrderService.save(bevOrder);
			return ResponseEntity.ok("Saved order line successfully!");
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/bev_order_by_order_id/{id}")
	public ResponseEntity getBeverageOrdersByBarroomOrderId(@PathVariable Long id) {
		try {
			Barroom_Order order = barroom_OrderService.get(id);
			List<Object> bevOrders = bevOrderService.getBeverageOrdersByBarroomOrderId(order);
			return ResponseEntity.ok(bevOrders);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/bev-order/view")
	public ResponseEntity getAllBevOrdersGroupedByOrderId (@RequestBody Barroom_Order order ){
		try {
			List<Object> result = new ArrayList<Object>();
			result = bevOrderService.getBevOrdersGroupedByOrderIdFilterByStatus(order.getStatus(),order.getOrderDate());
			return ResponseEntity.ok(result);
			
		}catch(Exception e) {
			throw e;
		}
	}

}
