package com.jsp.SimpleSpringBootStudentCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.SimpleSpringBootStudentCRUD.dto.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
