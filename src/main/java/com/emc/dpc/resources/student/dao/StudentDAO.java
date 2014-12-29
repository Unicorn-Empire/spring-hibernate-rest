package com.emc.dpc.resources.student.dao;

import java.util.List;

import com.emc.dpc.resources.school.domain.Dept;
import com.emc.dpc.resources.student.domain.Student;

public interface StudentDAO {

	Student getStudent(int rollNo);
	List<Student> getStudents();
	void enrollStudent(Student student);
	void enrollStudents(List<Student> students);
	void updateStudent(Student student);
	List<Student> getStudents(Dept dept);
	List<Student> getStudents(Dept dept, int rollNo);
	
}
