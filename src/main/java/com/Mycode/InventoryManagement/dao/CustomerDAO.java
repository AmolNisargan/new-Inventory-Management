package com.Mycode.InventoryManagement.dao;

import java.util.List;

import com.Mycode.InventoryManagement.entity.Customer;

public interface CustomerDAO  {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
	public Customer getCustomer(String email);

	public void deleteCustomer(int theId);

}
