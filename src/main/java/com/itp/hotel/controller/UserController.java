package com.itp.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.hotel.model.User;
import com.itp.hotel.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class UserController {

	@Autowired
	private UserService userService;

	// insert
	@PostMapping("/signUp")
	public ResponseEntity<User> signUp(@RequestBody User user) {
		try {
			userService.save(user);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/isUserExist/{username}")
	public ResponseEntity checkUserExists(@PathVariable String username) {
		try {
			User user = userService.getUserByUsername(username);
			return ResponseEntity.ok(user);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/signIn")
	public ResponseEntity signIn(@RequestBody User user) {
		String username = user.getUsername();
		try {
			User u = userService.getUserByUsername(username);
			if(u == null) {
				return ResponseEntity.ok("Username doesn't exists!");
			}else {
				if(u.getPassword().equals( user.getPassword())) {
					return ResponseEntity.ok(u);
				}else {
					return ResponseEntity.ok("Password doesn't match!");
				}
			}
			
		}catch(Exception e) {
			throw e;
		}
	}
	
}
