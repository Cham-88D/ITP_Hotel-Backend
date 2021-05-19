package com.itp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.DailyAttendance;
import com.itp.hotel.model.Payroll;
import com.itp.hotel.repository.PayrollRepository;
@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class PayrollController {
	
	@Autowired
	private PayrollRepository payrollRepositary;
	
	//get all payrolls
	@GetMapping("/payroll")
	public List<Payroll>  getAllpayroll(){
		return payrollRepositary.findAll();
		
	}
	@GetMapping("/payroll/{id}")
	public ResponseEntity<Payroll> getypayrollById(@PathVariable Long id) {
		Payroll payroll=payrollRepositary.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("payroll not exist with id:"+id));
		return ResponseEntity.ok(payroll);
	}
	@PostMapping("/payroll")
	
	public Payroll insertPayroll(@Validated  @RequestBody Payroll payl) {
		
		return payrollRepositary.save(payl);
	}

}
