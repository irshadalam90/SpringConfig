package com.springmvc.config.service;

import java.util.List;

import com.springmvc.config.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployeeList();

	int saveEmployee(Employee employee);

}
