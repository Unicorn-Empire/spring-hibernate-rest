package com.emc.dpc.resources.school.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emc.dpc.resources.employee.domain.Employee;
import com.emc.dpc.resources.school.domain.Dept;
import com.emc.dpc.resources.school.domain.Designation;
import com.emc.dpc.resources.school.domain.Grade;
import com.emc.dpc.resources.school.domain.School;
import com.emc.dpc.resources.student.domain.Student;



@Repository
public class SchoolDAOImpl implements SchoolDAO{

	@Autowired private SessionFactory sessionfactory;

	
	@Override
	public School getSchoolDetails() {
		
		String query = "from School";
		List<School> schoolList = sessionfactory.getCurrentSession().createQuery(query).list();
		if(schoolList == null || !(schoolList.size()>0))
		{
			School school = new School();
			List<Student> students =  new ArrayList<Student>();
			List<Employee> staff  =  new LinkedList<Employee>(); 
		
			Student student = new Student();
			student.setRollNo(1);
			student.setName("x");
			student.setGrade(Grade.I);
			students.add(student);
			school.setStudents(students);
			Employee employee = new Employee();
			employee.setName("y");
			employee.setRegNo(6);
			employee.setDesignation(Designation.TGT);
			employee.setDept(Dept.HINDI);
			staff.add(employee);
			school.setStaff(staff);
			sessionfactory.getCurrentSession().save(school);
			return school;
		}
		else
		{
			return schoolList.get(0);
		}
	}

	@Override
	public void updateSchoolDetails(School school) {
		sessionfactory.getCurrentSession().merge(school);
	}
	
}
