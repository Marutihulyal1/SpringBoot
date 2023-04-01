package com.jsp.SimpleSpringBootStudentCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.SimpleSpringBootStudentCRUD.dao.StudentDao;
import com.jsp.SimpleSpringBootStudentCRUD.dto.Student;
import com.jsp.SimpleSpringBootStudentCRUD.helper.ResponseStructure;

@Service
public class StudentService 
{
	@Autowired
	StudentDao dao;

	public ResponseStructure<Student> saveStudent(Student student) 
	{
		ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessege("Data saved Succesfully");
		structure.setData(dao.saveStudent(student));
		structure.setCode(HttpStatus.CREATED.value());
		return structure;
	}
	
	
	public ResponseStructure<List<Student>> saveStudents(List<Student> student) 
	{
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		structure.setMessege("Data saved Succesfully");
		structure.setData(dao.saveStudents(student));
		structure.setCode(HttpStatus.CREATED.value());
		return structure;
	}

	
	public ResponseStructure<Student> findById(int id) 
	{
		Student student=dao.findById(id);
		ResponseStructure<Student> structure=new ResponseStructure<>();
		if(student==null)
		{
			structure.setMessege("Data not found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			structure.setMessege("Data found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	
	public ResponseStructure<List<Student>> findAll() 
	{
		List<Student> list=dao.findAll();
		 ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		 if(list.isEmpty())
		 {
			 structure.setMessege("Data not fount");
			 structure.setData(null);
		     structure.setCode(HttpStatus.NOT_FOUND.value());
		 }
		 else
		 {
			 structure.setMessege("Data found");
			 structure.setData(list);
			 structure.setCode(HttpStatus.FOUND.value());
		 }
		return structure;
	}
	

	public ResponseStructure<Student> updateStudent(Student student) 
	{
		ResponseStructure<Student> structure=new ResponseStructure();
		structure.setMessege("Data updated successfully");
		structure.setData(dao.saveStudent(student));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}

	public ResponseStructure<Student> deleteById(int id) 
	{
		Student student=dao.findById(id);
		ResponseStructure<Student> structure=new ResponseStructure<>();
		if(student==null)
		{
		structure.setCode(HttpStatus.NOT_FOUND.value());
		structure.setMessege(" Data not found");
		structure.setData(null);
		}
		else
		{
			dao.deleteById(id);
			structure.setCode(HttpStatus.OK.value());
			structure.setMessege(" Data Deleted Successfully ");
			structure.setData(student);
			
		}
		return structure;
	}
}
