package com.itp.hotel.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "bev_order")

public class Bev_Order {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bev_order_id;
	
	@Column(name = "date")
	private LocalDateTime dateTime=LocalDateTime.now();
	
	
	@OneToMany(mappedBy = "bev")
	private List<Barroom_Bill> Barroom_Bill;
	
	
	@OneToMany(mappedBy = "bevo")
	private List<Barroom_Order> baroom_order;
	
	
	
	
	
	
	public Bev_Order() {
		
		
	}
	
	






	public Bev_Order(LocalDateTime dateTime, List<com.itp.hotel.model.Barroom_Bill> barroom_Bill,
			List<Barroom_Order> baroom_order) {
		super();
		this.dateTime = dateTime;
		Barroom_Bill = barroom_Bill;
		this.baroom_order = baroom_order;
	}








	public long getBev_order_id() {
		return bev_order_id;
	}






	public void setBev_order_id(long bev_order_id) {
		this.bev_order_id = bev_order_id;
	}






	public LocalDateTime getDateTime() {
		return dateTime;
	}






	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}






	public List<Barroom_Bill> getBarroom_Bill() {
		return Barroom_Bill;
	}






	public void setBarroom_Bill(List<Barroom_Bill> barroom_Bill) {
		Barroom_Bill = barroom_Bill;
	}






	public List<Barroom_Order> getBaroom_order() {
		return baroom_order;
	}






	public void setBaroom_order(List<Barroom_Order> baroom_order) {
		this.baroom_order = baroom_order;
	}
	
	
	
	
	
	

}
