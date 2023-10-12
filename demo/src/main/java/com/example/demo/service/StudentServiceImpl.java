package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService  {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Optional<Student> getStudent(long Id) {
		Optional<Student> studentById = studentRepo.findById(Id);		
		return studentById;
	}

	@Override
	public List<Student> findAll() {
		List<Student> studentList = studentRepo.findAll();
		return studentList;
	}

	@Override
	public void deleteStudent(long Id) {
       studentRepo.deleteById(Id);
	}

	@Override
	public Student updateStudent(Student student ) throws Exception {
		Optional < Student > productDb = this.studentRepo.findById(student.getStudentId());

		 if (productDb.isPresent()) {
			 Student productUpdate = productDb.get();
			 productUpdate.setEmailId("prashanth@123");
	            studentRepo.save(productUpdate);
	            return productUpdate;
	        } else {
	            throw new Exception("student details not found");
	        }
	}

	@Override
	public Student saveStudent(Student student) {
		Student studentSave = studentRepo.save(student);
		return studentSave;
	}
	
	

}
