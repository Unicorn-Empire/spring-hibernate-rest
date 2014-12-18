package com.emc.dpc.resources.school.dao;

import com.emc.dpc.resources.school.domain.School;


public interface SchoolDAO {

	School getSchoolDetails();
	void updateSchoolDetails(School school);
	
}
