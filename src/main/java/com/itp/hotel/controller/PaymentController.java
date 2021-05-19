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
import com.itp.hotel.exception.*;
import com.itp.hotel.model.Payment;
import com.itp.hotel.repository.PaymentRepository;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class PaymentController {

	
	
	  @Autowired
	    private PaymentRepository paymentRepository;

	  
	  
	    @GetMapping("/payments")
	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }

	    @GetMapping("/payments/{PId}")
	    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer PId){
	       
	    	Payment payment = paymentRepository.findById(PId)
	         .orElseThrow(() -> new ResourceNotFoundException("Paymentnot found for this id :: " + PId));
	        return ResponseEntity.ok(payment);
	    }
	 
	    @PostMapping("/payments")
	    public Payment createPayment (@RequestBody Payment payment) {
	        return paymentRepository.save(payment);
	    }

	    @PutMapping("/payments/{PId}")
	    public ResponseEntity<Payment> updatePayment(@PathVariable Integer  PId,
	          @RequestBody Payment paymentDetails) throws ResourceNotFoundException {
	    	Payment payment = paymentRepository.findById(PId)
	        .orElseThrow(() -> new ResourceNotFoundException("Paymentnot found for this id :: " + PId));

//	    	payment.setPId( payment.getPId());
	    	payment.setP_Date( payment.getP_Date());
	    	payment.setPay_For( payment.getPay_For());
	    	payment.setAmount( payment.getAmount());
	    	payment.setMethod( payment.getMethod());
	      
	        
	        
	        
	       Payment updatedPayment = paymentRepository.save(payment);
	       return ResponseEntity.ok(updatedPayment);
	    }
	
	    @DeleteMapping("/payments/{PId}")
	    public Map<String, Boolean> deletePayment(@PathVariable Integer PId)
	         throws ResourceNotFoundException {
	    	Payment payment = paymentRepository.findById(PId)
	        .orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + PId));

	    	paymentRepository.delete(payment);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}


