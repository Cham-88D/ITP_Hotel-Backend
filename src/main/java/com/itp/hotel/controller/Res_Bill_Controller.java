package com.itp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itp.hotel.model.ResBill;

import com.itp.hotel.repository.ResBillRepository;



public class Res_Bill_Controller {
	
	
	@Autowired
	private  ResBillRepository  res_Bill_Repository ;
	
	//get all employee
	@GetMapping("/res_bill")
	public List<ResBill> getRes_Bills(){
		return res_Bill_Repository.findAll();
	}
	
	//insert
	@PostMapping("/res_menu_item")
	public ResBill insertRes_Menu_item(@RequestBody   ResBill res_bill){
		return  res_Bill_Repository.save(res_bill);
	}
	
		
}
