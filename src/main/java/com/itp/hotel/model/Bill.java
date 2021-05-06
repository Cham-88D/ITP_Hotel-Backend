package com.itp.hotel.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "barroom_order_ID")
	private Barroom_Order barroom_Order;

	@Column(name="discount_per_order")
	private float discount_per_order;
	
	@Column(name="discounted_price")
	private float discounted_price;
	
	@Column(name="total_after_discount")
	private float total_after_discount;
	
	public Bill() {
		super();
	}
	
	public Bill(Barroom_Order barroom_Order,float discount_per_order, float discounted_price,float total_after_discount) {
		this.barroom_Order=barroom_Order;
		this.discount_per_order = discount_per_order;
		this.discounted_price = discounted_price;
		this.total_after_discount = total_after_discount;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Barroom_Order getBarroom_Order() {
		return barroom_Order;
	}

	public void setBarroom_Order(Barroom_Order barroom_Order) {
		this.barroom_Order = barroom_Order;
	}

	public float getDiscount_per_order() {
		return discount_per_order;
	}

	public void setDiscount_per_order(float discount_per_order) {
		this.discount_per_order = discount_per_order;
	}

	public float getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(float discounted_price) {
		this.discounted_price = discounted_price;
	}

	public float getTotal_after_discount() {
		return total_after_discount;
	}

	public void setTotal_after_discount(float total_after_discount) {
		this.total_after_discount = total_after_discount;
	}
	
}
