package com.springmvc.config.daoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.config.dao.EmployeeDao;
import com.springmvc.config.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		return criteria.list();
	}

	public int saveEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(employee);
		tr.commit();
		
		return 1;
	}
	

}
