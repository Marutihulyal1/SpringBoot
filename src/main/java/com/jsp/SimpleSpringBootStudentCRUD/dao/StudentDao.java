package com.jsp.SimpleSpringBootStudentCRUD.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.SimpleSpringBootStudentCRUD.Repository.StudentRepository;
import com.jsp.SimpleSpringBootStudentCRUD.dto.Student;
import com.jsp.SimpleSpringBootStudentCRUD.helper.ResponseStructure;

@Component
public class StudentDao 
{
	@Autowired
	StudentRepository repository;
	
	public Student saveStudent(Student student) 
	{
		return repository.save(student);
	}
	
	
	public List<Student> saveStudents(List<Student> student)
	{
		return repository.saveAll(student);	
	}

	
	public Student findById(int id) 
	{
		Optional<Student> op=repository.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		return null;
	}

	
	public List<Student> findAll() 
	{
		return repository.findAll();
	}

	
	public void deleteById(int id) 
	{
		repository.deleteById(id);
		
	}
}
