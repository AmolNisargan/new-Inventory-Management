package com.Mycode.InventoryManagement.service;

import java.util.List;

import com.Mycode.InventoryManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
