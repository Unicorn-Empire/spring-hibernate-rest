package com.emc.dpc.resources.school.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.emc.dpc.resources.employee.domain.Employee;
import com.emc.dpc.resources.student.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class School {

	@Id
	@GeneratedValue
	private int id;
	@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Student> students;
	@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	@JsonIgnore
	private List<Employee> staff;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Employee> getStaff() {
		return staff;
	}
	public void setStaff(List<Employee> staff) {
		this.staff = staff;
	}
}
