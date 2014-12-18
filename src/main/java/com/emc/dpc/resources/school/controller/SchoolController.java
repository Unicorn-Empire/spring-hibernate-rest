package com.emc.dpc.resources.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.dpc.resources.school.domain.School;
import com.emc.dpc.resources.school.service.SchoolService;

@RestController
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	
    @RequestMapping("/school")
    public School getSchoolDetails()
    {
    	return schoolService.getSchoolDetails();
    	 	
    }

    @RequestMapping(value = "/school",method= RequestMethod.POST)
    public void updateSchoolDetails(@RequestBody School school)
    {
    	schoolService.updateSchoolDetails(school);
    }

}
