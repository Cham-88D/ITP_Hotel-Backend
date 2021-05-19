package com.itp.hotel.model;

import java.time.LocalDate;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee",uniqueConstraints = { 
		@UniqueConstraint(columnNames = "nic"),
		@UniqueConstraint(columnNames = "phone") 
	})

public class Employee  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_Id")
	private Long eid;
	

	@Column(name="nic", length=20)
	private String nic;

	@Column(name="fname", length=30)
	private String fName;

	@Column(name="lname", length=30)
	private String lName;
	
	
	@Column(name="address", length=30)
	private String address;
	
	@Column(name="dob", length=15)
	private  LocalDate dateOfBirth;
	
	
	@Column(name="start_date", length=15)
	private  LocalDate startDate;
    

	@Column(name="phone", length=10)
	private  String  phone;

    

	@ManyToOne()
	@JoinColumn(name="role_id", referencedColumnName = "id")    
	private Role roles;
	
	@OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	
	public Employee() {
		super();
	}


	public Employee(Long eid, String nic, String fName, String lName, String address, LocalDate dateOfBirth,
			LocalDate startDate, String phone) {
		super();
		this.eid = eid;
		this.nic = nic;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.startDate = startDate;
		this.phone = phone;
	}


	public void setEid(Long eid) {
		this.eid = eid;
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


	public void setAddress(String address) {
		this.address = address;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Long getEid() {
		return eid;
	}


	public String getNic() {
		return nic;
	}


	public String getfName() {
		return fName;
	}

	public void setUser(User u) {
		this.user = u;
	}
	
	

	public String getlName() {
		return lName;
	}


	public String getAddress() {
		return address;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public String getPhone() {
		return phone;
	}
	
	
	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}
	
	public User getUser() {
		return user;
	}

	
	
	
	
}
	


	
	
	

	


	












