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
import com.itp.hotel.model.Beverage;
import com.itp.hotel.model.Bill;
import com.itp.hotel.model.ResourceNotFoundException;
import com.itp.hotel.service.Barroom_OrderService;
import com.itp.hotel.service.BeverageService;
import com.itp.hotel.service.BillService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class BillController {

	@Autowired
	private BillService billService;
	@Autowired
	private Barroom_OrderService barroom_OrderService;

	// view all
	@GetMapping("/bills/{orderId}")
	public ResponseEntity<List<Bill>> getBillDetailsByOrder(@PathVariable Long orderId) {
		try {
			Barroom_Order order = barroom_OrderService.get(orderId);
			return ResponseEntity.ok(billService.getBillDetailsByOrderId(order));
		} catch (Exception e) {
			throw e;
		}
	}

	// insert
	@PostMapping("/bills/{orderId}")
	public ResponseEntity insertBill(@RequestBody Bill bill,@PathVariable Long orderId) {
		try {
			Barroom_Order order = barroom_OrderService.get(orderId);
			Bill billObj = new Bill();
			billObj.setBarroom_Order(order);
			billObj.setDiscount_per_order(bill.getDiscount_per_order());
			billObj.setDiscounted_price(bill.getDiscounted_price());
			billObj.setTotal_after_discount(bill.getTotal_after_discount());
			try {
				billService.save(billObj);
				try {

					order.setBarroom_order_ID(orderId);
					order.setOrderDate(order.getOrderDate());
					order.setStatus("completed");
					barroom_OrderService.save(order);
				}catch(Exception e) {
					throw e;
				}
				return ResponseEntity.ok(true);
			}catch(Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	
}
