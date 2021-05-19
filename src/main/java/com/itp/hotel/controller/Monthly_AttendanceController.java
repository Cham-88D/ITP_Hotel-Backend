package com.itp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.DailyAttendance;
import com.itp.hotel.model.MonthlyAttendance;
import com.itp.hotel.repository.MonthlyAttendanceRepository;


@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class Monthly_AttendanceController {
	
	@Autowired
	private MonthlyAttendanceRepository monthlyAttendanceRepository;
	
	//get all monthlyAttendance
	@GetMapping("/monthlyAttendance")
	
	public List<MonthlyAttendance> getAllMonthly_Attendance(){
		return monthlyAttendanceRepository.findAll();
	}
	
	@GetMapping("/monthlyAttendance/{id}")
	public ResponseEntity<MonthlyAttendance> getMonthlyAttendanceById(@PathVariable Long id) {
		MonthlyAttendance monthlyattendance=monthlyAttendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance not exist with id:"+id));
		return ResponseEntity.ok(monthlyattendance);
	}
	@PostMapping("/monthlyAttendance")
		
		public MonthlyAttendance insertMonthlyAttendance(@Validated  @RequestBody MonthlyAttendance AtteDetails ) {
			return monthlyAttendanceRepository.save(AtteDetails);
	}
	
	@PutMapping("/monthlyAttendance/{id}")
	public ResponseEntity<MonthlyAttendance> updateMonthlyAttendance(@PathVariable Long id,@RequestBody MonthlyAttendance AtteDetails ){
		MonthlyAttendance monthlyattendance=monthlyAttendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance not exist with id:"+id));
		
		monthlyattendance.setTotalAbsent(AtteDetails.getTotalAbsent());
		monthlyattendance.setTotalAttendance(AtteDetails.getTotalAttendance());
		monthlyattendance.setTotalHalfDay(AtteDetails.getTotalHalfDay());
		monthlyattendance.setTotalLeave(AtteDetails.getTotalLeave());
		monthlyattendance.setTotalOt(AtteDetails.getTotalOt());
		
		MonthlyAttendance updateAttendance=monthlyAttendanceRepository.save(monthlyattendance);
		return ResponseEntity.ok(updateAttendance);
		
	}
	

}
