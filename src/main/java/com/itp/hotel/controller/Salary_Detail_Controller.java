package com.itp.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.itp.hotel.model.DailyAttendance;
import com.itp.hotel.model.SalaryDetail;
import com.itp.hotel.repository.SalaryDetailRepository;

@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class Salary_Detail_Controller {
	
	@Autowired
	private SalaryDetailRepository salaryDetailRepository;
	
	
	//get all salary details
	@GetMapping("/salarydetails")
	public List<SalaryDetail> getAllSalary_Detail(){
		return salaryDetailRepository.findAll();
		
	}
	
	@PostMapping("/salarydetails")
	
	public SalaryDetail insertSalaryDetail(@Validated  @RequestBody SalaryDetail sDetail) {
		return salaryDetailRepository.save(sDetail);
	}
	@GetMapping("/salarydetails/{id}")
	public ResponseEntity<SalaryDetail> getSalaryDetailById(@PathVariable Long id) {
		SalaryDetail salaryDetail=salaryDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary not exist with id:"+id));
		return ResponseEntity.ok(salaryDetail);
	}
	
	@PutMapping("/salarydetails/{id}")
	public ResponseEntity<SalaryDetail> updateSalaryDetail(@PathVariable Long id,@RequestBody SalaryDetail salDetails ){
		SalaryDetail salaryDetail=salaryDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary not exist with id:"+id));
		
		salaryDetail.setRole(salDetails.getRole());
		salaryDetail.setBasic(salDetails.getBasic());
		salaryDetail.setOt_rate(salDetails.getOt_rate());
		salaryDetail.setEPF(salDetails.getEPF());
		salaryDetail.setETF(salDetails.getETF());
		salaryDetail.setAllowance(salDetails.getAllowance());
		
		SalaryDetail updateSalDetail=salaryDetailRepository.save(salaryDetail);
		return ResponseEntity.ok(updateSalDetail);
		
	}
	@DeleteMapping("/salarydetails/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteSalaryDetail(@PathVariable Long id){
		SalaryDetail salaryDetail=salaryDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary not exist with id:"+id));
		salaryDetailRepository.delete(salaryDetail);
		Map<String,Boolean>response=new HashMap();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
}
