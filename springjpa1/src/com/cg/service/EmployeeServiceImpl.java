package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.EmployeeDao;
import com.cg.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Employee save(Employee employee) {
		employeeDao.save(employee);
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> loadAll() {
		employeeDao.loadAll();
		return employeeDao.loadAll();
	}

}
