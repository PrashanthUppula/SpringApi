package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Student;

public interface StudentService {
	
	Optional<Student> getStudent(long Id);
	Student saveStudent(Student student);
	List<Student> findAll();
	void deleteStudent(long Id);
	Student updateStudent(Student student) throws Exception;

}
