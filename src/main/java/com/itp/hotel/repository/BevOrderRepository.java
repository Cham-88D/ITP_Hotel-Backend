package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.BevOrder;
import com.itp.hotel.model.Beverage;

@Repository
public interface BevOrderRepository extends JpaRepository<BevOrder, Long>  {

	@Query(value = "select b.b_name, bo.discount, bo.id, bo.quantity, bo.total, from beverages as b, bev_order as bo,where b.bev_id = bo.bev_id and bo.barroom_order_id = ?",nativeQuery = true)
	public List<BevOrder> getAllBevOrders();
	
//	@Query(value = "select bev_id from bev_order",nativeQuery = true)
//	public List<Long> getBevIds();
	
	@Query("SELECT bo.id,bo.discount,bo.quantity,bo.total, b.b_Name, b.unit_Price FROM BevOrder bo JOIN Beverage b ON bo.beverage = b.bev_ID WHERE bo.barroom_Order=?1")
	public List<Object> getBeverageOrdersByBarroomOrderId(Barroom_Order order);
	
	@Query("SELECT b.barroom_order_ID,b.status,b.orderDate,SUM(bo.total) FROM BevOrder bo JOIN Barroom_Order b ON bo.barroom_Order = b.barroom_order_ID GROUP BY b.barroom_order_ID")
	public List<Object> getAllBevOrdersGroupedByOrderId();
	
	@Query("SELECT b.barroom_order_ID,b.status,b.orderDate,SUM(bo.total) FROM BevOrder bo JOIN Barroom_Order b ON bo.barroom_Order = b.barroom_order_ID WHERE b.status=?1 GROUP BY b.barroom_order_ID")
	public List<Object> getBevOrdersGroupedByOrderIdFilterByStatus(String status);
}


