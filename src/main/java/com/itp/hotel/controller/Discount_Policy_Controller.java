package com.itp.hotel.controller;

import java.util.List;

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

import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.DiscountPolicy;
import com.itp.hotel.repository.ResMenuItemRepository;
import com.itp.hotel.service.DiscountPolicyService;

@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class Discount_Policy_Controller {

	@Autowired
	private DiscountPolicyService discountPolicyService;
	
	// view all
		@GetMapping("/policies")
		public ResponseEntity<List<DiscountPolicy>> getAllPolicies() {
			try {
				return ResponseEntity.ok(discountPolicyService.listAll());
			}catch(Exception e) {
				throw e;
			}
		}
		
		@GetMapping("/policies-applicable/{total}")
		public ResponseEntity<List<DiscountPolicy>> getApplicablePolices(@PathVariable float total) {
			try {
				return ResponseEntity.ok(discountPolicyService.getApplicablePolicies(total));
			}catch(Exception e) {
				throw e;
			}
		}
		
		
		// insert beverage items
		@PostMapping("/policies")
		public ResponseEntity<DiscountPolicy> insertPolicy(@RequestBody DiscountPolicy dp) {
			try {
				discountPolicyService.save(dp);
				return ResponseEntity.ok(dp);
			}catch(Exception e) {
				throw e;
			}
		}
		
		// update beverage item details
		@PutMapping("/beverages/{id}")
		public ResponseEntity<DiscountPolicy> updateBeverageItems(@PathVariable Long id, @RequestBody DiscountPolicy dp) {

			try {
				DiscountPolicy single_dp = discountPolicyService.get(id);
				
				single_dp.setName(dp.getName());
				single_dp.setDescription(dp.getDescription());
				single_dp.setDiscount(dp.getDiscount());
				single_dp.setMin_bill_amount(dp.getMin_bill_amount());
				
				discountPolicyService.save(single_dp);
				return ResponseEntity.ok(single_dp);
			}catch(ResourceNotFoundException e) {
				throw e;
			}
		}
		
		@DeleteMapping("/policies/{id}")
		public ResponseEntity deletePolicyById(@PathVariable Long id) {
			try {
				discountPolicyService.delete(id);
				return ResponseEntity.ok(true);
			}catch(Exception e) {
				throw e;
			}
		}
}
