package com.springmvc.config.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.config.model.Employee;
import com.springmvc.config.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> getEmployees(){
		List<Employee> employees = employeeService.getEmployeeList();
		return employees;
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String saveEmployees(@ModelAttribute Employee employee ){
		int empId = employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
}
