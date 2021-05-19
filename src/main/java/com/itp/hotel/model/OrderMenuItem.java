package com.itp.hotel.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_menu_item")
public class OrderMenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_item_id;
	
	@Column(name = "menu_item_name")
	private String menuItemName;
	
	@Column(name = "menu_item_type")
	private String menuItemType;
	
	@Column(name = "Quantity")
	private int qty;

	
	@Column(name = "discount")
	private float discount;
	
	@Column(name = "total")
	private float total;
	
	@JoinColumn(name = "menu_Order_Id" ,nullable=false)
	@ManyToOne
	private ResOrder rest;
	
	@JoinColumn(name = "menu_Item_Id" ,nullable=false)
	@ManyToOne
	private ResMenuItem res;

	public OrderMenuItem() {
		super();
	}

	public OrderMenuItem( String menuItemName, String menuItemType, int qty,
			ResOrder rest, ResMenuItem res,float discount,float total) {
		super();
		this.menuItemName = menuItemName;
		this.menuItemType = menuItemType;
		this.qty = qty;
		this.discount = discount;
		this.rest = rest;
		this.res = res;
		this.total = total;
	}

	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void setOrder_item_id(long order_item_id) {
		this.order_item_id = order_item_id;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public void setMenuItemType(String menuItemType) {
		this.menuItemType = menuItemType;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	

	public void setRest(ResOrder rest) {
		this.rest = rest;
	}

	public void setRes(ResMenuItem res) {
		this.res = res;
	}

	public long getOrder_item_id() {
		return order_item_id;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public String getMenuItemType() {
		return menuItemType;
	}

	public int getQty() {
		return qty;
	}

	public ResOrder getRest() {
		return rest;
	}

	public ResMenuItem getRes() {
		return res;
	}


}