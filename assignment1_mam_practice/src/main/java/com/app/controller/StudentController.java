package com.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

	public StudentController() {
		System.out.println(" in StudentController constr");
	}

	@GetMapping("/admit")
	public String showStudentAdmitForm(Student s) {// model -- >view

		System.out.println(" in showStudentAdmitForm method  " + " " + s);
		return "/students/admit";
	}

	@PostMapping("/admit")                       // view --> model
	public String processStudentAdmitForm(@Valid Student s,BindingResult result) {
              //chk if there any presentation logic error 
		if(result.hasErrors()) {
			System.out.println("PL erroor : "+result);
			// in case of PL error simply forward clnt to view layer
			return "/students/admit";
		}
		System.out.println(" in showStudentAdmitForm method  " + " " + s);
		return "/students/list";
	}
}
