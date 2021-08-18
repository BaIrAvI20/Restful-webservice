package com.restapplication.restws.service;

import java.util.List;

import com.restapplication.restws.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	List<Employee> allEmployeeDetails();
	Employee detailsById(long id);
	public Employee updateEmployeeDetails(Employee emp, long id);
	void deleteEmployeeDetails(long id);
}
