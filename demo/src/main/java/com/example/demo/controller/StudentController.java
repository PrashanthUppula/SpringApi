package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/Student/{Id}")
	public Optional<Student> getStudent(@PathVariable long Id) {
		Optional<Student> studentGet = studentService.getStudent(Id);
		return studentGet;
	}

	@GetMapping("/StudentList")
	public List<Student> findAllStudents() {
		List<Student> listOfStudents = studentService.findAll();
		return listOfStudents;
	}

	@DeleteMapping("Student/{Id}")
	public void deleteStudent(@PathVariable long Id) {
		studentService.deleteStudent(Id);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) throws Exception {
		return studentService.updateStudent(student);
	}
	@PostMapping("/createStudent")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
}
