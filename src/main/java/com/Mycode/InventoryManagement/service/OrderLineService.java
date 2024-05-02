package com.Mycode.InventoryManagement.service;

import java.util.List;

import com.Mycode.InventoryManagement.dto.OrderLineDTO;

public interface OrderLineService {

	public List<OrderLineDTO> getOrderLines();

	public void saveOrderLine(OrderLineDTO theOrderLine);

	List<OrderLineDTO> getOrderLinesbyOrderHeaderID(int orderHeaderID);
	
	public void deleteOrderLine(int theId);
	
	
}
