//package com.itp.hotel.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.itp.hotel.model.Barroom_Bill;
//import com.itp.hotel.model.Barroom_Order;
//import com.itp.hotel.model.ResourceNotFoundException;
//import com.itp.hotel.repository.Barroom_billRepository;
//
//@RestController
//@RequestMapping("/api/v1/")
//
//public class Barroom_billController {
//	@Autowired
//	
//	private Barroom_billRepository barroom_billRepository;
//	
//	@GetMapping("/barroom_Bill")
//	
//	public List<Barroom_Bill> getAllbarroom_bill() {
//		return barroom_billRepository.findAll();
//		
//	}
//	
//	//insert bill  items
//	@PostMapping("/barroom_Bill")
//	public Barroom_Bill insertBarBill(@RequestBody  Barroom_Bill  barroom_Bill){
//		return barroom_billRepository.save(barroom_Bill);
//	}
//	
//	@GetMapping("/barroom_Bill/{bill_Id}")
//	public ResponseEntity<Barroom_Bill> getBarroom_order_by_id(@PathVariable Long bill_Id) {
//			
//		Barroom_Bill barroom_bill = barroom_billRepository.findById(bill_Id)
//				.orElseThrow(()-> new ResourceNotFoundException("menu item not exit with this key: "+bill_Id));
//		return ResponseEntity.ok(barroom_bill);
//		
//		
//		
//	}
//	
//	
//	
//
//}