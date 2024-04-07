package com.techymeet.taskMonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techymeet.taskMonitoring.bo.LoginBo;
import com.techymeet.taskMonitoring.bo.StudentBo;
import com.techymeet.taskMonitoring.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;

@Controller 

public class StudentController {
	@Autowired
	TaskService service;
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	@GetMapping("/login")
	public String getLoginPage(HttpServletRequest request,Model model) {
		LoginBo login=new LoginBo();
		try {
			model.addAttribute("login", login);
			if(null!=request.getParameter("successMessage")) {
				request.setAttribute("successMessage", request.getParameter("successMessage"));
			}
			request.setAttribute("errorMessage", request.getParameter("errorMessage"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("login") LoginBo login ,ModelAndView model) {
		login=service.loginCheck(login);
		if(login!=null) {
			if(login.getUserType().equalsIgnoreCase("student")) {
			model.addObject("message", "Login Success");
			model.setViewName("student_home");
			return model;
			}
			else if(login.getUserType().equalsIgnoreCase("admin")) {
				model.addObject("message", "Login Success");
				model.setViewName("admin_home");
				return model;
			}
		}
		model.addObject("message","Login Failed");
		model.setViewName("index");
		return model;
	}
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute("student") StudentBo student,ModelAndView model) {
		try{
			student=service.saveUser(student);
		
		if(null!=student) {
			model.addObject("message", "Registered Successfully");
			model.setViewName("index");
			return model;
		}
		else {
			model.addObject("message", "Registration Failed");
			model.setViewName("index");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	
}
