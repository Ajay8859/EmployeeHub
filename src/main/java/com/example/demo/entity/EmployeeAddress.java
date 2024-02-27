package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "emp_address")
public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int address_Id;

	int pincode;

	@NotEmpty
	@Size(min = 4)
	String emp_Add;

	public int getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(int address_Id) {
		this.address_Id = address_Id;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getEmp_Add() {
		return emp_Add;
	}

	public void setEmp_Add(String emp_Add) {
		this.emp_Add = emp_Add;
	}

}
