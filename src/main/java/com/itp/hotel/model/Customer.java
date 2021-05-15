package com.itp.hotel.model;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(referencedColumnName="user_Id")

public class Customer extends  User {

	private static final long serialVersionUID = 1L;
	
	
//	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL ) 
//    private List <Reservation> reservation;
//	
//	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL ) 
//    private List <Payment> payment;
//	
//	
//	@OneToMany(targetEntity=Booking.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER) 
//	@JsonBackReference
//    private List <Booking> booking;
//	
	
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


	public Customer(Long userId, String username, String email, String password, String role,
			/*List<Reservation> reservation, List<Payment> payment, List<Booking> booking,*/ String nic, String fName,
			String lName, String phoneNum) {
		super(userId, username, email, password, role);
		this.nic = nic;
		this.fName = fName;
		this.lName = lName;
		this.phoneNum = phoneNum;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
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
