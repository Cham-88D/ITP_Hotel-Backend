package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itp.hotel.model.OrderMenuItem;
import com.itp.hotel.model.ResOrder;

public interface OrderMenuItemRepository extends JpaRepository<OrderMenuItem, Long> {

	@Query("SELECT bo.order_item_id, bo.discount, bo.qty, bo.total, b.menuItemName, b.unitPrice FROM OrderMenuItem bo JOIN ResMenuItem b ON bo.res = b.menu_item_id WHERE bo.rest=?1")
	public List<Object> getMenuOrdersByOrderId(ResOrder order);
}
