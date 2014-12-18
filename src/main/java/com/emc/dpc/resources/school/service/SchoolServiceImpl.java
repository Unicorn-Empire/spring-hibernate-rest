package com.emc.dpc.resources.school.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.emc.dpc.resources.employee.domain.Employee;
import com.emc.dpc.resources.school.dao.SchoolDAO;
import com.emc.dpc.resources.school.domain.Dept;
import com.emc.dpc.resources.school.domain.Designation;
import com.emc.dpc.resources.school.domain.Grade;
import com.emc.dpc.resources.school.domain.School;
import com.emc.dpc.resources.student.domain.Student;


@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	SchoolDAO schoolDao;
	
	@Override
	public School getSchoolDetails() {
		
		School school = schoolDao.getSchoolDetails();
		List<Student> students = school.getStudents();
		List<Employee> staff  = school.getStaff(); 
		
		if(students == null)
		{
			students = new ArrayList<Student>();
			Student student = new Student();
			student.setRollNo(1);
			student.setName("x");
			student.setGrade(Grade.I);
			students.add(student);
			school.setStudents(students);
			updateSchoolDetails(school);
		}
		if(staff == null)
		{
			staff = new LinkedList<Employee>();
			Employee employee = new Employee();
			employee.setName("y");
			employee.setRegNo(6);
			employee.setDesignation(Designation.TGT);
			employee.setDept(Dept.HINDI);
			staff.add(employee);
			school.setStaff(staff);
			updateSchoolDetails(school);
		}
		return school;
	}

	@Override
	public void updateSchoolDetails(School school) {
		schoolDao.updateSchoolDetails(school);
	}
	

	
}
