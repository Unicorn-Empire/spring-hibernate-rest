package com.emc.dpc.resources.student.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emc.dpc.resources.school.domain.Grade;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue
	private int id;
	private int rollNo;
	private String name;
	private Grade grade;
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
}
