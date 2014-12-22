package com.emc.dpc.resources.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.dpc.resources.school.domain.School;
import com.emc.dpc.resources.school.service.SchoolService;
import com.emc.dpc.resources.student.domain.Student;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	
	@RequestMapping
    public School getSchoolDetails()
    {
    	return schoolService.getSchoolDetails();
    }

    @RequestMapping(method= RequestMethod.POST)
    public void updateSchoolDetails(@RequestBody School school)
    {
    	schoolService.updateSchoolDetails(school);
    }
    
    @RequestMapping("/students")
    public List<Student> getStudents()
    {
    	return schoolService.getStudents();
    }
}
