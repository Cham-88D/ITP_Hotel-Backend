package com.itp.hotel.model;


import java.time.LocalDate;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchased_item_detail")

public class PurchasedItemDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int InvoiceNo;
	
	@JoinColumn(name = "user_Id")
	@ManyToOne
    private Employee employee ;
	
	
	@Column(name = "S_Id")
	private int Sid;
	
	@Column(name = "Item_Code")
	private int Category;
	
	@Column(name = "Payment")
	private long payment;
	
	@Column(name= "Date")
	private LocalDate Date;
	
	@Column(name= "It_Category")
	private String It_Category;
	

	public PurchasedItemDetail() {
		
	}


	public PurchasedItemDetail(int invoiceNo, Employee employee, int sid, int category, long payment, LocalDate date,
			String it_Category) {
		super();
		InvoiceNo = invoiceNo;
		this.employee = employee;
		Sid = sid;
		Category = category;
		this.payment = payment;
		Date = date;
		It_Category = it_Category;
	}


	public void setInvoiceNo(int invoiceNo) {
		InvoiceNo = invoiceNo;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public void setSid(int sid) {
		Sid = sid;
	}


	public void setCategory(int category) {
		Category = category;
	}


	public void setPayment(long payment) {
		this.payment = payment;
	}


	public void setDate(LocalDate date) {
		Date = date;
	}


	public void setIt_Category(String it_Category) {
		It_Category = it_Category;
	}


	public int getInvoiceNo() {
		return InvoiceNo;
	}


	public Employee getEmployee() {
		return employee;
	}


	public int getSid() {
		return Sid;
	}


	public int getCategory() {
		return Category;
	}


	public long getPayment() {
		return payment;
	}


	public LocalDate getDate() {
		return Date;
	}


	public String getIt_Category() {
		return It_Category;
	}

	

	
	

}
