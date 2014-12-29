package com.emc.dpc.resources.student.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emc.dpc.resources.school.domain.Dept;
import com.emc.dpc.resources.school.domain.Grade;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue
	@JsonIgnore
	private int id;

	private int enrollNo;
	private int rollNo;
	private String name;
	private Grade grade;
	private Dept dept ; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEnrollNo() {
		return enrollNo;
	}
	public void setEnrollNo(int enrollNo) {
		this.enrollNo = enrollNo;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
