package com.jsp.SimpleSpringBootStudentCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SimpleSpringBootStudentCRUD.dto.Student;
import com.jsp.SimpleSpringBootStudentCRUD.helper.ResponseStructure;
import com.jsp.SimpleSpringBootStudentCRUD.service.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	StudentService service;
	
	@PostMapping("student")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student)
	{
		return service.saveStudent(student);	
	}
	
	
	
	@PostMapping("students")
	public ResponseStructure<List<Student>> saveStudents(@RequestBody List<Student> student)
	{
		return service.saveStudents(student);
	}
	
	
	
	@GetMapping("stdid")
	 public ResponseStructure<Student> findById(@RequestParam int id)
	{
		return service.findById(id);
	}
	
	@GetMapping("fetchall")
	public ResponseStructure<List<Student>> findAll()
	{
		return service.findAll();
	}
	
	
	
	@PutMapping("update")
	 public ResponseStructure<Student> updateStudent(@RequestBody Student student)
		{
			return service.updateStudent(student);
		}
	
	
	
	@DeleteMapping("delete/{id}")
	public ResponseStructure<Student> deleteId(@PathVariable int id)
	{
		return service.deleteById(id);
	}
}
