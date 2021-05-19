package com.itp.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.Bill;
import com.itp.hotel.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository repo;

	public List<Bill> listAll(){
		return repo.findAll();
	}
	
	public void save(Bill bill) {
		repo.save(bill);
	}
	
	public List<Bill> getBillDetailsByOrderId(Barroom_Order bo){
		return repo.getBillDetailsByOrderId(bo);
	}
	
	public List getAllBills(){
		return repo.getAllBills();
	}
}
