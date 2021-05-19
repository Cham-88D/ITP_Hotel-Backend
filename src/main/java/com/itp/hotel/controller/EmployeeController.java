package com.itp.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.itp.hotel.model.Employee;
import com.itp.hotel.model.Role;
import com.itp.hotel.model.User;
import com.itp.hotel.payload.response.MessageResponse;
import com.itp.hotel.repository.EmployeeRepository;
import com.itp.hotel.repository.RoleRepository;
import com.itp.hotel.repository.UserRepository;
import com.itp.hotel.exception.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	

	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	

	@PostMapping("/employee/{id}")
	public ResponseEntity<?> createEmployee(@PathVariable String id,@RequestBody Employee employee) {
		Role role = roleRepository.findByName(id).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		if(role.getName().equals("HRmanager")) {
			
		if(employeeRepository.existsByRole(role.getId()).isPresent()) {
			
		int num = employeeRepository.existsByRole(role.getId()).get();
		
		if (num==role.getId()) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Employee is already registered"));
		}}}
		Employee e = new Employee();
		if(userRepository.userExistsByRole(role.getId()).isPresent()) {
			User u = userRepository.userExistsByRole(role.getId()).get();
			e.setUser(u);
			e.setRoles(u.getRoles());
		}
		else
		{
			e.setRoles(role);
		}
	
		e.setfName(employee.getfName());
		e.setlName(employee.getlName());
		e.setAddress(employee.getAddress());
		e.setDateOfBirth(employee.getDateOfBirth());
		e.setNic(employee.getNic());
		e.setPhone(employee.getPhone());
		e.setStartDate(employee.getStartDate());
		
		employeeRepository.save(e);
		return ResponseEntity.ok(new MessageResponse("Done"));
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setfName(employeeDetails.getfName());
		employee.setlName(employeeDetails.getlName());
		employee.setAddress(employeeDetails.getAddress());
	//employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setNic(employeeDetails.getNic());
		employee.setPhone(employeeDetails.getPhone());
		//employee.setStartDate(employeeDetails.getStartDate());
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}