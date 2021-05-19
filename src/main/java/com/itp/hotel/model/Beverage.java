package com.itp.hotel.model;

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
import javax.persistence.Table;

@Entity
@Table(name = "beverages")


public class Beverage {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long bev_ID;
	
	@Column(name = "b_Type")
	private String b_Type;
	
	@Column(name = "b_Name")
	private String b_Name;
	
	@Column(name = "unit_price")
	private double unit_Price;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "description")
	private String  description;
	
//	@OneToMany(mappedBy = "best")
//	private List<Barroom_Order> barroom_Orders;
	@OneToMany(mappedBy = "beverage", cascade = CascadeType.ALL)
	private Set<BevOrder> bevOrders = new HashSet();

	public Beverage() {
		super();
	}
	
	public Beverage(double unit_Price, String b_Name, String b_Type, double discount, String available_Status,
			String description, List<Barroom_Order> barroom_Orders) {
		super();
		
		this.b_Type = b_Type;
		this.b_Name = b_Name;
		
		this.unit_Price = unit_Price;
		this.discount = discount;
		
		this.description = description;
		//this.barroom_Orders = barroom_Orders;
	}

	public long getBev_ID() {
		return bev_ID;
	}
	public void setBev_ID(long bev_ID) {
		this.bev_ID = bev_ID;
	}
	
	public String getB_Type() {
		return b_Type;
	}
	public void setB_Type(String b_Type) {
		this.b_Type = b_Type;
	}
	public String getB_Name() {
		return b_Name;
	}
	public void setB_Name(String b_Name) {
		this.b_Name = b_Name;
	}
	
	public double getUnit_Price() {
		return unit_Price;
	}
	public void setUnit_Price(double unit_Price) {
		this.unit_Price = unit_Price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<BevOrder> getBevOrders() {
		return bevOrders;
	}

	public void setBevOrders(Set<BevOrder> bevOrders) {
		this.bevOrders = bevOrders;
	}
//	public List<Barroom_Order> getBarroom_Orders() {
//		return barroom_Orders;
//	}


//	public void setBarroom_Orders(List<Barroom_Order> barroom_Orders) {
//		this.barroom_Orders = barroom_Orders;
//	}

	
	
}

