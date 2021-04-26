package com.itp.hotel.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "barroom_Bill")
public class Barroom_Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bill_Id;
	
	
	
	
	//@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private LocalDateTime date = LocalDateTime.now();


	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "tot_Amount")
	private double tot_Amount;
	
	
	
	
	@ManyToOne
	private Bev_Order bev;
	
	
	
	
	public Barroom_Bill() {
			super();
	}
	
	


	public Barroom_Bill(LocalDateTime date, double discount, double tot_Amount) {
		super();
		this.date = date;
		this.discount = discount;
		this.tot_Amount = tot_Amount;
		
	}




	public Long getBill_Id() {
		return bill_Id;
	}


	public void setBill_Id(Long bill_Id) {
		this.bill_Id = bill_Id;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getTot_Amount() {
		return tot_Amount;
	}


	public void setTot_Amount(double tot_Amount) {
		this.tot_Amount = tot_Amount;
	}


	
	
	

	
	

}
