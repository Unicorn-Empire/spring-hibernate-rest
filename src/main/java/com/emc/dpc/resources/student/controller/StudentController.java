package com.emc.dpc.resources.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.dpc.resources.student.domain.Student;
import com.emc.dpc.resources.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student")
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}
	
	@RequestMapping(value = "enroll/student", method= RequestMethod.POST)
	public void enrollStudents(@RequestBody Student student)
	{
		studentService.enrollStudent(student);
	}

	@RequestMapping(value = "enroll/students", method= RequestMethod.POST)
	public void enrollStudents(@RequestBody List<Student> students)
	{
		studentService.enrollStudents(students);
	}
}
