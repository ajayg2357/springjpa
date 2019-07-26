package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee save(Employee employee) {
		entityManager.persist(employee);
		entityManager.flush();
		return employee;
	}

	@Override
	public List<Employee> loadAll() {
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e",Employee.class);
		return query.getResultList();
	}

}
