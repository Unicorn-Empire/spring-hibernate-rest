package com.emc.dpc.resources.school.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.dpc.resources.school.domain.Grade;


@RestController
@RequestMapping("/grade")
public class GradeController {

	@RequestMapping(method=RequestMethod.GET)
	public Grade[] getGrades()
	{
		return Grade.values();
	}
	
	
}
