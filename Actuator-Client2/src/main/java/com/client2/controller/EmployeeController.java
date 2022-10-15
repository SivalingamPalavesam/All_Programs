package com.client2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.client2.model.Employee;
import com.client2.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
   
	@PostMapping(value = "/insertData")
    public Employee insertData(@RequestBody Employee emp){
       return employeeService.insertData(emp);
    }

	@GetMapping(value = "/getData")
    public List<Employee> getData()
	{
       return  employeeService.getData();
    }
}
