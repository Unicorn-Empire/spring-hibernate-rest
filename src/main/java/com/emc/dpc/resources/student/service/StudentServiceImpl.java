package com.emc.dpc.resources.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.dpc.resources.student.dao.StudentDAO;
import com.emc.dpc.resources.student.domain.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDAO studentDao;
	
	
	@Override
	public Student getStudent(int rollNo) {
		
		return studentDao.getStudent(rollNo);
	}

	@Override
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	@Override
	public void enrollStudent(Student student) {
		studentDao.enrollStudent(student);
	}

	@Override
	public void enrollStudents(List<Student> students) {
		
		studentDao.enrollStudents(students);
	}

}
