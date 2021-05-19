package com.itp.hotel.model;

import java.time.LocalDateTime;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "barroom_Order")

public class Barroom_Order {

	/*
	 * @EmbeddedId
	 * 
	 * private Barroom_Order_comp id;
	 */

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long barroom_order_ID;

//	@Column(name="unit_price")
//	private double unit_price;

//	@Column(name="bev_name")
//	private String bev_name;

//	@Column(name="bev_type")
//	private String bev_type;

//	@Column(name="quantity")
//	private double quantity;

	// @Temporal(TemporalType.DATE)
	@Column(name = "orderDate")
	private String orderDate;

	@Column(name = "status")
	private String status;

//	@ManyToOne
//	private Bev_Order bevo;
//	
//	@ManyToOne
//	private Beverage best;

	@OneToMany(mappedBy = "barroom_Order", cascade = CascadeType.ALL)
	private Set<BevOrder> bevOrders = new HashSet();

	@OneToOne(mappedBy = "barroom_Order")
    private Bill bill;
	
	public Barroom_Order() {
		super();
	}

	public Barroom_Order(String orderDate, String status) {
		super();
		this.orderDate = orderDate;
		this.status = status;
		// this.unit_price = unit_price;
		// this.bev_name = bev_name;
		// this.bev_type = bev_type;
		// this.quantity = quantity;
		// this.date = date;
		// this.bevo = bevo;
		// this.best = best;
	}

//	public Set<BevOrder> getBevOrders() {
//		return bevOrders;
//	}
//
//	public void setBevOrders(Set<BevOrder> bevOrders) {
//		this.bevOrders = bevOrders;
//	}

	public long getBarroom_order_ID() {
		return barroom_order_ID;
	}

	public void setBarroom_order_ID(long barroom_order_ID) {
		this.barroom_order_ID = barroom_order_ID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public long getBar_ID() {
//		return bar_ID;
//	}

//	public void setBar_ID(long bar_ID) {
//		this.bar_ID = bar_ID;
//	}

//	public double getUnit_price() {
//		return unit_price;
//	}

//	public void setUnit_price(double unit_price) {
//		this.unit_price = unit_price;
//	}

//	public String getBev_name() {
//		return bev_name;
//	}

//	public void setBev_name(String bev_name) {
//		this.bev_name = bev_name;
//	}

//	public String getBev_type() {
//		return bev_type;
//	}

//	public void setBev_type(String bev_type) {
//		this.bev_type = bev_type;
//	}

//	public double getQuantity() {
//		return quantity;
//	}

//	public void setQuantity(double quantity) {
//		this.quantity = quantity;
//	}

//	public LocalDateTime getDate() {
//		return date;
//	}

//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}

//	public Bev_Order getBevo() {
//		return bevo;
//	}

//	public void setBevo(Bev_Order bevo) {
//		this.bevo = bevo;
//	}

//	public Beverage getBest() {
//		return best;
//	}

//	public void setBest(Beverage best) {
//		this.best = best;
//	}

}
