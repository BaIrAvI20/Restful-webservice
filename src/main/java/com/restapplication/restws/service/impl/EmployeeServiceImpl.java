package com.restapplication.restws.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restapplication.restws.exception.ResourceNotFoundException;
import com.restapplication.restws.model.Employee;
import com.restapplication.restws.repository.EmployeeRepository;
import com.restapplication.restws.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
	System.out.println(employee.getName());
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> allEmployeeDetails() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee detailsById(long id) {
		Optional<Employee> emp = employeeRepo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee updateEmployeeDetails(Employee emp, long id) {
		Optional<Employee> existing = employeeRepo.findById(id);
		if(existing.isPresent()) {
			Employee previous =existing.get();
			previous.setName(emp.getName());
			previous.setEmail(emp.getEmail());
			employeeRepo.save(previous);
			return previous;
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public void deleteEmployeeDetails(long id) {
		Optional<Employee> existing = employeeRepo.findById(id);
		if(existing.isPresent()) {
			employeeRepo.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	
}
