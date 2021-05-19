package com.itp.hotel.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cus_ID;

	private static final long serialVersionUID = 1L;
	
	@Column(name="nic", length=20, nullable=false)
	private String nic;

	@Column(name="fname", length=30, nullable=false)
	private String fName;

	@Column(name="lname", length=30, nullable=false)
	private String lName;
	
	
	@Column(name="phone", length=10, nullable=false)
	private String phoneNum;
	
	
	public Customer() {
		super();
	}

	public Customer(Long cus_ID, String nic, String fName, String lName, String phoneNum) {
		this.cus_ID = cus_ID;
		this.nic = nic;
		this.fName = fName;
		this.lName = lName;
		this.phoneNum = phoneNum;
	}

	public Long getCus_ID() {
		return cus_ID;
	}

	public void setCus_ID(Long cus_ID) {
		this.cus_ID = cus_ID;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}























/*import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "customer")
public class Customer  {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cus_ID;
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List <Reservation> reservation;
	@JsonIgnore
	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL) 
    private List <Payment> payment;

	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL) 
    private List <Booking> booking;
	
	
	@Column(name="nic", length=20, nullable=false)
	private String nic;

	@Column(name="fname", length=30, nullable=false)
	private String fName;

	@Column(name="lname", length=30, nullable=false)
	private String lName;
	
	
	@Column(name="phone", length=10, nullable=false)
	private String phoneNum;
	
	
	public Customer() {
		super();
	}


	public Customer(
			List<Reservation> reservation, List<Payment> payment, List<Booking> booking, String nic, String fName,
			String lName, String phoneNum) {
	//	this.reservation = reservation;
		this.payment = payment;
		this.booking = booking;
		this.nic = nic;
		this.fName = fName;
		this.lName = lName;
		this.phoneNum = phoneNum;
	}

	public void setCus_ID(Long cus_ID) {
		this.cus_ID = cus_ID;
	}

	/*public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

/*
	public List<Reservation> getReservation() {
		return reservation;
	}


	public List<Payment> getPayment() {
		return payment;
	}


	public List<Booking> getBooking() {
		return booking;
	}


	public String getNic() {
		return nic;
	}


	public String getfName() {
		return fName;
	}


	public String getlName() {
		return lName;
	}


	public String getPhoneNum() {
		return phoneNum;
	}
	

}*/
