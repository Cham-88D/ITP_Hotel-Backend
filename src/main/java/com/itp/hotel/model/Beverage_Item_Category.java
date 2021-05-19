package com.itp.hotel.model;

import java.util.ArrayList;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name="beverage_item_category")



public class Beverage_Item_Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "b_Type",unique = true,nullable = false,length=32)
	private String b_Type;

	public Beverage_Item_Category() {
		super();
	}

	public Beverage_Item_Category(String b_Type) {
		super();
		
		this.b_Type = b_Type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getB_Type() {
		return b_Type;
	}

	public void setB_Type(String b_Type) {
		this.b_Type = b_Type;
	}
	
	
	

	
	
	
	
	
	
	
	

	
	

}
