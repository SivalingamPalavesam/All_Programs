package com.client2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client2.model.Employee;
import com.client2.repo.EmployeeRepo;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeRepo employeeRepo;


	public Employee insertData(Employee emp) {
		
	return	employeeRepo.save(emp);		
	}


	public List<Employee> getData() {
		 return employeeRepo.findAll();
	}
}
