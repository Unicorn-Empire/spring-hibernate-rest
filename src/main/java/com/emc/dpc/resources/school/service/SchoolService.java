package com.emc.dpc.resources.school.service;

import org.springframework.transaction.annotation.Transactional;

import com.emc.dpc.resources.school.domain.School;

@Transactional
public interface SchoolService {

	School getSchoolDetails();
	void updateSchoolDetails(School school);
}
