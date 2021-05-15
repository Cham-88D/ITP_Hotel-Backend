package com.itp.hotel.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiscountPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "min_bill_amount")
	private float min_bill_amount;
	
	@Column(name = "discount")
	private float discount;

	public DiscountPolicy() {
		super();
	}
	
	public DiscountPolicy(String name, String description, float min_bill_amount, float discount) {
		this.name = name;
		this.description = description;
		this.min_bill_amount = min_bill_amount;
		this.discount = discount;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getMin_bill_amount() {
		return min_bill_amount;
	}

	public void setMin_bill_amount(float min_bill_amount) {
		this.min_bill_amount = min_bill_amount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
}
