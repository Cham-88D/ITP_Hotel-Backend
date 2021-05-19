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
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.Customer;
import com.itp.hotel.repository.CustomerRepository;
@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")

public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
	
	 @GetMapping("/customers")
	    public List<Customer> getAllCustoCIDmers() {
	        return customerRepository.findAll();
	    }
	    
	    @GetMapping("/customers/{CID}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "CID") Long CID)
	        throws ResourceNotFoundException {
	    	Customer customer = customerRepository.findById(CID)
	    			.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CID));
	        return ResponseEntity.ok().body(customer);
	    }
	    
	    @PostMapping("/customers")
	    public Customer createCustomer(@RequestBody Customer customer) {
	        return customerRepository.save(customer);
	    }
	    
	    @PutMapping("/customers/{CID}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "CID") Long CID,
	         @RequestBody Customer customerDetails) throws ResourceNotFoundException {
	    	Customer customer = customerRepository.findById(CID)
	        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CID));

	    	customer.setCus_ID(customer.getCus_ID());
	    	customer.setNic(customer.getNic());
	    	customer.setfName(customer.getfName());
	    	customer.setlName(customer.getlName());
	    	customer.setPhoneNum(customer.getPhoneNum());
	        
	        final Customer updatedCustomer = customerRepository.save(customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }
	    
	    @DeleteMapping("/customers/{CID}")
	    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "CID") Long CID)
	         throws ResourceNotFoundException {
	    	Customer customer = customerRepository.findById(CID)
	       .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CID));

	    	customerRepository.delete(customer);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    

}

/*import java.util.HashMap;
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
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.Customer;
import com.itp.hotel.repository.CustomerRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
	
	 @GetMapping("/customers")
	    public List<Customer> getAllCustoCIDmers() {
	        return customerRepository.findAll();
	    }
	    
	    @GetMapping("/customers/{CID}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "CID") Long CID)
	        throws ResourceNotFoundException {
	    	Customer customer = customerRepository.findById(CID)
	    			.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CID));
	        return ResponseEntity.ok().body(customer);
	    }
	    
	    @PostMapping("/customers")
	    public Customer createCustomer(@Valid @RequestBody Customer customer) {
	        return customerRepository.save(customer);
	    }
	    
	    @PutMapping("/customers/{CID}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "CID") Long CID,
	         @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
	    	Customer customer = customerRepository.findById(CID)
	        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CID));

	    	customer.setNic(customer.getNic());
	    	customer.setfName(customer.getfName());
	    	customer.setlName(customer.getlName());
	    	customer.setPhoneNum(customer.getPhoneNum());
	        
	        final Customer updatedCustomer = customerRepository.save(customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }
	    
	    @DeleteMapping("/customers/{CID}")
	    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "CID") Long CID)
	         throws ResourceNotFoundException {
	    	Customer customer = customerRepository.findById(CID)
	       .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CID));

	    	customerRepository.delete(customer);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    

}*/