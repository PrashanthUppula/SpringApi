package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo; 

	@Override
	public Optional<Employee> getEmployee(Long Id) {
		Optional<Employee> employeeById = employeeRepo.findById(Id);
		return employeeById;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee employeeSave = employeeRepo.save(employee);
		return employeeSave;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employeeList = employeeRepo.findAll();
		return employeeList;
	}

	@Override
	public void deleteEmployee(Long Id) {
		employeeRepo.deleteById(Id);

	}

	@Override
	public Employee updateEmployee(Employee employee) throws Exception {
		Optional < Employee > productDb = this.employeeRepo.findById(employee.getEmpId());
		 if (productDb.isPresent()) {
			Employee productUpdate = productDb.get();
			 productUpdate.setEmpDept("construction");
			 employeeRepo.save(productUpdate);
			 return productUpdate;
		 }else {
	            throw new Exception("employee dept details not found");
		 }
	}

}
