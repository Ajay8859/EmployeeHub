package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long emp_Id;

	@NotEmpty
	@Size(min = 3, message = "Name should be atleast 3 character")
	String emp_Name;

	Date emp_Dod;

	@NotEmpty
	String emp_Designation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_Id", referencedColumnName = "address_Id")
	private EmployeeAddress employeeAddress;

	public long getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(long emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public Date getEmp_Dod() {
		return emp_Dod;
	}

	public void setEmp_Dod(Date emp_Dod) {
		this.emp_Dod = emp_Dod;
	}

	public String getEmp_Designation() {
		return emp_Designation;
	}

	public void setEmp_Designation(String emp_Designation) {
		this.emp_Designation = emp_Designation;
	}

	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

}
