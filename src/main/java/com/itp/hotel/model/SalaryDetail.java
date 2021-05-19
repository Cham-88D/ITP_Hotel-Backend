package com.itp.hotel.model;




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
@Table(name="salary_Detail")
public class SalaryDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long salaryId;
	
	
	
	@OneToOne
    @JoinColumn(name = "emp_Id", referencedColumnName = "emp_Id")
    private Employee employee;

	
	
	
	
	
	@Column(name="Role", length=30)
	private String role;
	
	@Column(name="OT_Rate")
	private double ot_rate;
	
	@Column(name="ETF")
	private double ETF;
	
	@Column(name="EPF")
	private double EPF;
	
	@Column(name="Allowance")
	private double allowance;
	
	@Column(name="Basic")
	private double basic;
	
	public SalaryDetail() {
		super();
	}


	public SalaryDetail(long salaryId, Employee employee, String role, double ot_rate, double eTF, double ePF,
			double allowance, double basic) {
		super();
		this.salaryId = salaryId;
		this.employee = employee;
		this.role = role;
		this.ot_rate = ot_rate;
		ETF = eTF;
		EPF = ePF;
		this.allowance = allowance;
		this.basic=basic;
	}


	public double getBasic() {
		return basic;
	}


	public void setBasic(double basic) {
		this.basic = basic;
	}


	public void setSalaryId(long salaryId) {
		this.salaryId = salaryId;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setOt_rate(double ot_rate) {
		this.ot_rate = ot_rate;
	}


	public void setETF(double eTF) {
		ETF = eTF;
	}


	public void setEPF(double ePF) {
		EPF = ePF;
	}


	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}


	public long getSalaryId() {
		return salaryId;
	}


	public Employee getEmployee() {
		return employee;
	}


	public String getRole() {
		return role;
	}


	public double getOt_rate() {
		return ot_rate;
	}


	public double getETF() {
		return ETF;
	}


	public double getEPF() {
		return EPF;
	}


	public double getAllowance() {
		return allowance;
	}
	
	
	
}