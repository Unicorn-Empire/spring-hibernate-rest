package com.emc.dpc.resources.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.dpc.resources.school.domain.Dept;
import com.emc.dpc.resources.school.service.SchoolService;
import com.emc.dpc.resources.student.domain.Student;
import com.emc.dpc.resources.student.service.StudentService;


@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	SchoolService schoolService;
	@Autowired
	StudentService studentService;

	@RequestMapping(method=RequestMethod.GET)
	public Dept[] getDept() 
	{
		return Dept.values();
	}
	
	@RequestMapping("/{dept}/students")
	public List<Student> getStudentsFromDept(@PathVariable Dept dept) 
	{
		return studentService.getStudents(dept);
	}
	
	@RequestMapping("/{dept}/students/{rollNo}")
	public List<Student> getStudentFromDept(@PathVariable Dept dept,@PathVariable int rollNo) 
	{
		return studentService.getStudents(dept,rollNo);
	}
	
	@RequestMapping(value="/{dept}/students",method = RequestMethod.POST)
	public void setStudentsInDept(@PathVariable Dept dept,@RequestBody List<Student> students) 
	{
		 studentService.enrollStudents(students, dept);
	}
}
