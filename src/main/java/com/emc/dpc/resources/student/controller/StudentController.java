package com.emc.dpc.resources.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.dpc.resources.student.domain.Student;
import com.emc.dpc.resources.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}
	
	@RequestMapping(value="/{rollNo}")
	public Student getStudent(@PathVariable("rollNo") int rollNo)
	{
		return studentService.getStudent(rollNo);
	}
	
	
	@RequestMapping(method= RequestMethod.POST)
	public void enrollStudents(@RequestBody List<Student> students)
	{
		studentService.enrollStudents(students);
	}
	
	@RequestMapping(method= RequestMethod.PATCH)
	public void updateStudent(@RequestBody Student student)
	{
		studentService.updateStudent(student);
	}
}
