package com.client2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client2.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> 
{

}
