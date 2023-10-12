package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {
 
	Optional<Employee> getEmployee(Long Id);
	Employee saveEmployee(Employee employee);
	List<Employee> findAll();
	void deleteEmployee(Long Id);
	Employee updateEmployee(Employee employee)throws Exception;
	
}
