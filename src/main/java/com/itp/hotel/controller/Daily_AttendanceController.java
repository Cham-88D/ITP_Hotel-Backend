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

import com.itp.hotel.repository.DailyAttendanceRepository;
@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class Daily_AttendanceController {

	@Autowired
	private DailyAttendanceRepository dailyAttendanceRepository;
	
	//get all dailyAttendance
	@GetMapping("/dailyAttendance")
	
	public List<DailyAttendance> getAllDaily_Attendance(){
		return dailyAttendanceRepository.findAll();
		
	}
	
	@PostMapping("/dailyAttendance")
	
	public DailyAttendance insertAttendance(@Validated  @RequestBody DailyAttendance atte ) {
		return dailyAttendanceRepository.save(atte);
	}
	
	@GetMapping("/dailyAttendance/{id}")
	public ResponseEntity<DailyAttendance> getDailyAttendanceById(@PathVariable Long id) {
		DailyAttendance dailyattendance=dailyAttendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance not exist with id:"+id));
		return ResponseEntity.ok(dailyattendance);
	}
	

	

	@PutMapping("/dailyAttendance/{id}")
	public ResponseEntity<DailyAttendance> updateDailyAttendance(@PathVariable Long id,@RequestBody DailyAttendance AtteDetails ){
		DailyAttendance dailyattendance=dailyAttendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance not exist with id:"+id));
		
		dailyattendance.setIn_Time(AtteDetails.getIn_Time());
		dailyattendance.setOut_Time(AtteDetails.getOut_Time());
		dailyattendance.setOtHours(AtteDetails.getOtHours());
		dailyattendance.setAtte_type(AtteDetails.getAtte_type());
		
		DailyAttendance updateAttendance=dailyAttendanceRepository.save(dailyattendance);
		return ResponseEntity.ok(updateAttendance);
		
	}
	@DeleteMapping("/dailyAttendance/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteAttendance(@PathVariable Long id){
		DailyAttendance dailyattendance=dailyAttendanceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance not exist with id:"+id));
		dailyAttendanceRepository.delete(dailyattendance);
		Map<String,Boolean>response=new HashMap();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
}
