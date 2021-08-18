package com.restapplication.restws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restapplication.restws.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
