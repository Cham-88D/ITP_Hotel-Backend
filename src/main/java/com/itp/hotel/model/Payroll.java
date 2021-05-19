package com.itp.hotel.model;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payroll")
public class Payroll {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long payId;
	
	

	private String employeeId;
	
	private String basicSalary;
	
	
	@Column(name="Total_Salary")
	private String totalSalary;
	
	@Column(name="Month")
	private String month;
	
	
	private String totalEran;
	
	private String totalDeduction;
	
	
	
	
	public Payroll() {
		super();
	}




	public Payroll(long payId, String employeeId, String basicSalary, String totalSalary, String month,
			String totalEran, String totalDeduction) {
		super();
		this.payId = payId;
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.totalSalary = totalSalary;
		this.month = month;
		this.totalEran = totalEran;
		this.totalDeduction = totalDeduction;
	}




	public long getPayId() {
		return payId;
	}




	public void setPayId(long payId) {
		this.payId = payId;
	}




	public String getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}




	public String getBasicSalary() {
		return basicSalary;
	}




	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}




	public String getTotalSalary() {
		return totalSalary;
	}




	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}




	public String getMonth() {
		return month;
	}




	public void setMonth(String month) {
		this.month = month;
	}




	public String getTotalEran() {
		return totalEran;
	}




	public void setTotalEran(String totalEran) {
		this.totalEran = totalEran;
	}




	public String getTotalDeduction() {
		return totalDeduction;
	}




	public void setTotalDeduction(String totalDeduction) {
		this.totalDeduction = totalDeduction;
	}





}