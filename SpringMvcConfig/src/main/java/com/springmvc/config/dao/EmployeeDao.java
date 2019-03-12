package com.springmvc.config.dao;

import java.util.List;

import com.springmvc.config.model.Employee;

public interface EmployeeDao {

	List<Employee> getEmployees();

	int saveEmployee(Employee employee);

}
