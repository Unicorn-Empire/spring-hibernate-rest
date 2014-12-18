package com.emc.dpc.resources.employee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emc.dpc.resources.school.domain.Dept;
import com.emc.dpc.resources.school.domain.Designation;

@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	private int regNo;
	private String name;
	private Dept dept;
	private Designation designation;
	
		
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	} 
	
	

}
