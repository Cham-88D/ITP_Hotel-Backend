package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.Barroom_Order_comp;

@Repository
public interface Barroom_orderRepository extends JpaRepository<Barroom_Order, Long> {
	
	

}