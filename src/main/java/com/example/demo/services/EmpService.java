package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmpService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees(int pageNo, int pageSize);

	public Employee getEmployee(long id);

	public boolean delEmployee(long id);

	public Employee updateRecord(Employee employee);
}