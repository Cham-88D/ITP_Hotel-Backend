package com.itp.hotel.model;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="daily_Attendance")
public class DailyAttendance {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY )
		private long attendanceId;
		
		
		
		@OneToOne
	    @JoinColumn(name = "emp_Id", referencedColumnName = "emp_Id")
	    private Employee employee;

		
		
		@Column(name="In_Time")
		private String in_Time;
		
		@Column(name="Out_Time")
		private String out_Time;
		
		@Column(name="OT_Hours")
		private float otHours;
		
		@Column(name="Atte_Type", length=30)
		private String atte_type;
		
		@Column(name="Date")
		private LocalDate date= LocalDate.now();
		
		public DailyAttendance() {
			super();
		}

		public DailyAttendance(long attendanceId, Employee employee, String in_Time, String out_Time,
				float otHours, String atte_type, LocalDate date) {
			super();
			this.attendanceId = attendanceId;
			this.employee = employee;
			this.in_Time = in_Time;
			this.out_Time = out_Time;
			this.otHours = otHours;
			this.atte_type = atte_type;
			this.date = date;
		}

		public void setAttendanceId(long attendanceId) {
			this.attendanceId = attendanceId;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public void setIn_Time(String in_Time) {
			this.in_Time = in_Time;
		}

		public void setOut_Time(String out_Time) {
			this.out_Time = out_Time;
		}

		public void setOtHours(float otHours) {
			this.otHours = otHours;
		}

		public void setAtte_type(String atte_type) {
			this.atte_type = atte_type;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public long getAttendanceId() {
			return attendanceId;
		}

		public Employee getEmployee() {
			return employee;
		}

		public String getIn_Time() {
			return in_Time;
		}

		public String getOut_Time() {
			return out_Time;
		}

		public float getOtHours() {
			return otHours;
		}

		public String getAtte_type() {
			return atte_type;
		}

		public LocalDate getDate() {
			return date;
		}

		
		
		
	


}
