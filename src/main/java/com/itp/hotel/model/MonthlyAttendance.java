package com.itp.hotel.model;



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
@Table(name="monthly_attendance")
public class MonthlyAttendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long attendanceId;
	
	
//	@JoinColumn(name = "user_Id" ,nullable=false)
//	@OneToOne
//    private Employee employee ;
   
	
	@Column(name="Total_Attendance",nullable=false )
	private int totalAttendance;
	
	@Column(name="Total_OT_Hours")
	private int totalOt;
	
	@Column(name="Total_Leave")
	private int totalLeave;
	
	@Column(name="Total_Absents")
	private int totalAbsent;
	
	@Column(name="Total_Half_Day")
	private int totalHalfDay;
	
	@Column(name="Total_Quater_Day")
	private int totalQuaterDay;
	
	@Column(name="Employee_ID")
	private long employeeId;
	
	public MonthlyAttendance() {
		super();
	}


	public MonthlyAttendance(long attendanceId, int totalAttendance, int totalOt, int totalLeave,
			int totalAbsent, int totalHalfDay, int totalQuaterDay,long employeeId) {
		super();
		this.attendanceId = attendanceId;
		this.employeeId = employeeId;
		this.totalAttendance = totalAttendance;
		this.totalOt = totalOt;
		this.totalLeave = totalLeave;
		this.totalAbsent = totalAbsent;
		this.totalHalfDay = totalHalfDay;
		this.totalQuaterDay = totalQuaterDay;
	}


	public void setAttendanceId(long attendanceId) {
		this.attendanceId = attendanceId;
	}


	

	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public void setTotalAttendance(int totalAttendance) {
		this.totalAttendance = totalAttendance;
	}


	public void setTotalOt(int totalOt) {
		this.totalOt = totalOt;
	}


	public void setTotalLeave(int totalLeave) {
		this.totalLeave = totalLeave;
	}


	public void setTotalAbsent(int totalAbsent) {
		this.totalAbsent = totalAbsent;
	}


	public void setTotalHalfDay(int totalHalfDay) {
		this.totalHalfDay = totalHalfDay;
	}


	public void setTotalQuaterDay(int totalQuaterDay) {
		this.totalQuaterDay = totalQuaterDay;
	}


	public long getAttendanceId() {
		return attendanceId;
	}


	

	public int getTotalAttendance() {
		return totalAttendance;
	}


	public int getTotalOt() {
		return totalOt;
	}


	public int getTotalLeave() {
		return totalLeave;
	}


	public int getTotalAbsent() {
		return totalAbsent;
	}


	public int getTotalHalfDay() {
		return totalHalfDay;
	}


	public int getTotalQuaterDay() {
		return totalQuaterDay;
	}
	
	
}