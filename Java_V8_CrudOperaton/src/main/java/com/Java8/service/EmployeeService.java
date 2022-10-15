package com.Java8.service;

import java.util.List;
import java.util.Optional;

import com.Java8.model.Employee;

public interface EmployeeService
{
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	Optional<Employee> getEmployeeById(int id);
	
	public Employee updateEmployee(Employee updatedEmployee);
	
    public void deleteEmployee(int id);
}
