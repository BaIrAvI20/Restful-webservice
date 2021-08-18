package com.restapplication.restws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapplication.restws.model.Employee;
import com.restapplication.restws.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;


	// Build createEmployee restAPI
	@PostMapping()
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	//All employee details
	@GetMapping
	public List<Employee> employeeDetails(){
		return employeeService.allEmployeeDetails();
	}

	//Get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> employeeById(@PathVariable long id) {
		return new ResponseEntity<Employee>(employeeService.detailsById(id),HttpStatus.OK);
	}
	
	//Update employee details
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id,@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(employeeService.updateEmployeeDetails(emp, id),HttpStatus.OK);
	}
	
	//Delete employee details
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable long id) {
		employeeService.deleteEmployeeDetails(id);
		return new ResponseEntity<String>("Employee deleted successfully!!",HttpStatus.OK);
	}

		

}
