package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee_Entity;
import com.example.demo.service.Employee_Service;

//import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

 
//import jakarta.servlet.http.HttpSession;

@Controller
public class Employee_Controller {
	
	@Autowired
	private Employee_Service service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee_Entity> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemployee")
    public String addEmpForm() {
	return "add_employee";
    }
	
	@PostMapping("/register")
	public String registerForm(@ModelAttribute Employee_Entity e, HttpSession session) {
		//System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "New Employee Added Successfully...");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		//int newId=Integer.parseInt(id);
		Employee_Entity e=service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee_Entity e,HttpSession session ) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee Data Update Successfully");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session) {
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee Data deleted Successfully");
		return "redirect:/";
	}
}

