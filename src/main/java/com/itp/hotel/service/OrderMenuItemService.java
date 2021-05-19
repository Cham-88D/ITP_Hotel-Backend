package com.itp.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.OrderMenuItem;
import com.itp.hotel.model.ResOrder;
import com.itp.hotel.repository.OrderMenuItemRepository;

@Service
public class OrderMenuItemService {

	@Autowired
	private OrderMenuItemRepository repo;
	
	public void save(OrderMenuItem m) {
		repo.save(m);
	}
	
	public List<OrderMenuItem> listAll(){
		return repo.findAll();
	}
	
	public List<Object> getMenuOrdersByOrderId(ResOrder order){
		return repo.getMenuOrdersByOrderId(order);
	}
}
