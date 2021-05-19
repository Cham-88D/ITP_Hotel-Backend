package com.itp.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.repository.Barroom_orderRepository;

@Service
public class Barroom_OrderService {

	@Autowired
	private Barroom_orderRepository repo;
	
	public List<Barroom_Order> listAll(){
		return repo.findAll();
	}
	
	public void save(Barroom_Order barroom_order) {
		repo.save(barroom_order);
	}
	
	public Barroom_Order get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
