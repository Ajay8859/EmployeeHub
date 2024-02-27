package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmpService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private EmpService empService;

	@PostMapping("/create-emp")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Employee emp = empService.addEmployee(employee);

		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@GetMapping("/get-all")
	public ResponseEntity<?> getAllList(@RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "0", required = false) int pageSize) {

		List<Employee> allEmployees = empService.getAllEmployees(pageNo, pageSize);
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable long id) {

		Employee employee = empService.getEmployee(id);

		if (employee == null) {
			return new ResponseEntity<String>("Id is not present", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delEmployee(@PathVariable long id) {

		boolean status = empService.delEmployee(id);

		if (status == false) {
			return new ResponseEntity<String>("Id is not present", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Record delete!", HttpStatus.OK);
	}

	@PatchMapping
	public ResponseEntity<?> updateRecord(@RequestBody Employee employee) {

		Employee updateRecord = empService.updateRecord(employee);

		return new ResponseEntity<Employee>(updateRecord, HttpStatus.OK);
	}

}
