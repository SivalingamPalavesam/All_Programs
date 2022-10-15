package com.liqubase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.liqubase.model.Student;
import com.liqubase.repo.StudentRepo;
@RestController
public class StudentController
{	
	@Autowired
	private StudentRepo studentRepository;

	@PostMapping("/student")
	public String createStudent(@RequestBody Student student) 
	{
		studentRepository.save(student);
		return "Successfully";
	}

	@GetMapping("/get")
	public List<Student> getAllStudents() {
		return  (List<Student>) studentRepository.findAll();
	}

}

