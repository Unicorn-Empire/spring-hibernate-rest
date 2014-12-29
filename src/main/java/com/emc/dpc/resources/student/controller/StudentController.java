package com.emc.dpc.resources.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emc.dpc.resources.student.domain.Student;

@Controller
@RequestMapping("/student")
public class StudentController {


	@RequestMapping(method=RequestMethod.GET)
	public String getStudentPage(Model model)
	{
		model.addAttribute("student",new Student());
		return "student";
	}
}
