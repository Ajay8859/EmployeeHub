package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repositories.Repo;
import com.example.demo.services.EmpService;

@Service
class Emp_Services implements EmpService {

	@Autowired
	private Repo repo;

	@Override
	public Employee addEmployee(Employee employee) {

		return repo.save(employee);

	}

	@Override
	public List<Employee> getAllEmployees(int pageNo, int pageSize) {

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		org.springframework.data.domain.Page<Employee> findAll = repo.findAll(pageRequest);
		List<Employee> content = findAll.getContent();
		return content;
	}

	@Override
	public Employee getEmployee(long id) {

		Employee employee = repo.findById(id).orElse(null);

		return employee;

	}

	@Override
	public boolean delEmployee(long id) {

		if (!repo.existsById(id)) {
			return false;
		}

		repo.deleteById(id);
		return true;
	}

	@Override
	public Employee updateRecord(Employee employee) {

		return repo.save(employee);
	}

}
