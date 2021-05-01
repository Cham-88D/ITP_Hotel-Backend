package com.itp.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.BevOrder;
import com.itp.hotel.model.Beverage;
import com.itp.hotel.repository.BevOrderRepository;
import com.itp.hotel.repository.BeverageRepository;

@Service
public class BevOrderService {

	@Autowired
	private BevOrderRepository repo;
	
	public List<BevOrder> listAll(){
		List<BevOrder> bevOrders = repo.findAll();
		List<BevOrder> formattedBevOrders = new ArrayList<BevOrder>();
		List<Beverage> bev = new ArrayList<Beverage>();
		for(BevOrder b :bevOrders ) {
			BevOrder newBevOrderObj = new BevOrder();
			Beverage newBevObj = new Beverage();
			
			newBevOrderObj.setId(b.getId());
			newBevOrderObj.setDiscount(b.getDiscount());
			newBevOrderObj.setQuantity(b.getQuantity());
			newBevOrderObj.setTotal(b.getTotal());
			System.out.print("-----------------------------------------");
			System.out.print(newBevOrderObj.getBeverage());
			//newBevObj.setBeverage(b.getBeverage());
			formattedBevOrders.add(newBevOrderObj);
		}
		return formattedBevOrders;
	}
	
	public void save(BevOrder bevOrder) {
		repo.save(bevOrder);
	}
	
	public BevOrder get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public List<BevOrder> getAllBeverageOrdersWithBevName(){
		return repo.getAllBevOrders();
	}
	
	public List<Long> getBevIds(){
		return repo.getBevIds();
	}
	
	public List<Object> getBeverageOrdersByBarroomOrderId(Barroom_Order order){
		return repo.getBeverageOrdersByBarroomOrderId(order);
	}
}
