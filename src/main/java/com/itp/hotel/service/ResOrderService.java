package com.itp.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.ResOrder;
import com.itp.hotel.repository.ResOredrReposiyory;

@Service
public class ResOrderService {

	@Autowired
	private ResOredrReposiyory repo;
	
	public ResOrder get(long id) {
		return repo.findById(id).get();
	}
}
