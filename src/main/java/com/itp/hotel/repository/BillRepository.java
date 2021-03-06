package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	@Query("SELECT b FROM Bill b WHERE barroom_Order=?1")
	public List<Bill> getBillDetailsByOrderId(Barroom_Order bo);
	
	@Query("SELECT b.barroom_Order,b.discount_per_order,b.discounted_price,b.total_after_discount FROM Bill b")
	public List getAllBills();
}
