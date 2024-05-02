package com.Mycode.InventoryManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Mycode.InventoryManagement.dao.CustomerDAO;
import com.Mycode.InventoryManagement.dto.CustomerDTO;
import com.Mycode.InventoryManagement.entity.Customer;
import com.Mycode.InventoryManagement.service.CustomerService;
import com.Mycode.InventoryManagement.service.mapper.CustomerMapper;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerMapper customerMapper;

	public List<CustomerDTO> getCustomer() {

		List<Customer> customers = customerDAO.getCustomers();

		List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
		for (Customer c : customers) {
			customerDTOList.add(customerMapper.mapToDTO(c));
		}
		return customerDTOList;
	}

	

	@Override
	public void saveCustomer(CustomerDTO theCustomer) {
		Customer customer = customerMapper.mapToEntity(theCustomer);
		customerDAO.saveCustomer(customer);
	}

	
	

	@Override
	public CustomerDTO getCustomer(int theId) {
		Customer customer = customerDAO.getCustomer(theId);
		
		return customerMapper.mapToDTO(customer);

	}

	@Override
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

}