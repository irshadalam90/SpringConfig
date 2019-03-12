package com.springmvc.config.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.config.dao.EmployeeDao;
import com.springmvc.config.model.Employee;
import com.springmvc.config.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao empDao;
	
	public List<Employee> getEmployeeList() {
		
		return empDao.getEmployees();
	}

	public int saveEmployee(Employee employee) {
		
		return empDao.saveEmployee(employee);
	}

}
