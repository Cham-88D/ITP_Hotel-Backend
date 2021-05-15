package com.itp.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.DiscountPolicy;
import com.itp.hotel.repository.DiscountPolicyRepository;

@Service
public class DiscountPolicyService {
	@Autowired
	private DiscountPolicyRepository repo;
	
	public List<DiscountPolicy> listAll(){
		return repo.findAll();
	}
	
	public void save(DiscountPolicy dp) {
		repo.save(dp);
	}
	
	public DiscountPolicy get(long id) {
		DiscountPolicy dp = repo.findById(id).get();
		return  dp;
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
