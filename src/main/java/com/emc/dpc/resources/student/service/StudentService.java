package com.emc.dpc.resources.student.service;

import java.util.List;

import javax.transaction.Transactional;

import com.emc.dpc.resources.school.domain.Dept;
import com.emc.dpc.resources.student.domain.Student;

@Transactional
public interface StudentService {

	Student getStudent(int rollNo);
	List<Student> getStudents();
	void enrollStudent(Student student);
	void enrollStudents(List<Student> students);
	void updateStudent(Student student);
	List<Student> getStudents(Dept dept);
	List<Student> getStudents(Dept dept, int rollNo);
	void enrollStudents(List<Student> students, Dept dept);
	
}
