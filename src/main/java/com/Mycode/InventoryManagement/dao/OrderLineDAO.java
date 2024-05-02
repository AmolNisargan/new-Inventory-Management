package com.Mycode.InventoryManagement.dao;

import java.util.List;

import com.Mycode.InventoryManagement.entity.OrderLine;

public interface OrderLineDAO {
	
	public List<OrderLine> getOrderLines();
	
	public void saveOrderLine(OrderLine theOrderLine);
	
	public List<OrderLine> getOrderLineByOrderHeaderID(int orderHeaderId);

	public void deleteOrderLine(int theId);
}
