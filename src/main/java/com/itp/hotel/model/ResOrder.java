package com.itp.hotel.model;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="res_order")
public class ResOrder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_Order_Id")
	private long menu_order_id;
	
	
	@Column(name = "date")
	private LocalDateTime date = LocalDateTime.now();
	
	@OneToMany(mappedBy = "rest", cascade = CascadeType.ALL)
	private Set<OrderMenuItem> order_Menu_Item = new HashSet();
	
	@OneToOne(mappedBy = "res")
	private ResBill Res_Bill;

	public ResOrder() {
		super();
	}

	public ResOrder(LocalDateTime date) {
		super();
		this.date = date;
	}

	public void setMenu_order_id(long menu_order_id) {
		this.menu_order_id = menu_order_id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setOrder_Menu_Item(Set<OrderMenuItem> order_Menu_Item) {
		this.order_Menu_Item = order_Menu_Item;
	}

	public void Res_Bill(ResBill res_Bill) {
		Res_Bill = res_Bill;
	}

	public long getMenu_order_id() {
		return menu_order_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Set<OrderMenuItem> getOrder_Menu_Item() {
		return order_Menu_Item;
	}

	public ResBill getRes_Bill() {
		return Res_Bill;
	}

	
	
	

}
