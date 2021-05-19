package com.itp.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BevOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="barroom_order_ID")
	private Barroom_Order barroom_Order;
	
	@ManyToOne
	@JoinColumn(name="bev_ID")
	private Beverage beverage;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="total")
	private float total;
	
	public BevOrder() {
		super();
	}
	
	public BevOrder(float discount,int quantity,float total,Barroom_Order barroom_Order,Beverage beverage) {
		this.barroom_Order =barroom_Order;
		this.beverage = beverage;
		this.quantity = quantity;
		this.discount = discount;
		this.total = total;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public Barroom_Order getBarroom_order() {
//		return barroom_order;
//	}
//
//	public void setBarroom_order(Barroom_Order barroom_order) {
//		this.barroom_order = barroom_order;
//	}

	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	public Barroom_Order getBarroom_Order() {
		return barroom_Order;
	}

	public void setBarroom_Order(Barroom_Order barroom_Order) {
		this.barroom_Order = barroom_Order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
