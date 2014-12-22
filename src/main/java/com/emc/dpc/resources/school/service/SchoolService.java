package com.emc.dpc.resources.school.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.emc.dpc.resources.school.domain.School;
import com.emc.dpc.resources.student.domain.Student;

@Transactional
public interface SchoolService {

	School getSchoolDetails();
	void updateSchoolDetails(School school);
	List<Student> getStudents();
}
