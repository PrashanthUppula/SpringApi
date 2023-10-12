package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/Employee/{Id}")
	public Optional<Employee> getEmployee(@PathVariable Long Id) {
		Optional<Employee> employeeGet = employeeService.getEmployee(Id);
		return employeeGet;
	}
	
	@GetMapping("/EmployeeList")
	public List<Employee> findAllEmployees() {
		List<Employee> listOfEmployees = employeeService.findAll();
		return listOfEmployees;
	}	
		
	@DeleteMapping("/Employee/{Id}")
	public void deleteEmployee(@PathVariable long Id) {
			employeeService.deleteEmployee(Id);	
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
		return employeeService.updateEmployee(employee);
	}
	
	@PostMapping("/createEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	
	
	

}
