package com.Mycode.InventoryManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Mycode.InventoryManagement.dao.OrderLineDAO;
import com.Mycode.InventoryManagement.dto.OrderLineDTO;
import com.Mycode.InventoryManagement.entity.OrderLine;
import com.Mycode.InventoryManagement.service.OrderLineService;
import com.Mycode.InventoryManagement.service.mapper.OrderLineMapper;

@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

	@Autowired
	OrderLineDAO orderLineDAO;

	@Autowired
	OrderLineMapper orderLineMapper;

	@Override
	public List<OrderLineDTO> getOrderLines() {
		List<OrderLine> orderLines = orderLineDAO.getOrderLines();

		List<OrderLineDTO> orderLineDTOList = new ArrayList<OrderLineDTO>();

		for (OrderLine ol : orderLines) {
			orderLineDTOList.add(orderLineMapper.mapToDTO(ol));
		}

		return orderLineDTOList;
	}

	@Override
	public void saveOrderLine(OrderLineDTO theOrderLine) {
		OrderLine orderLine = orderLineMapper.mapToEntity(theOrderLine);
		orderLineDAO.saveOrderLine(orderLine);
	}

	@Override
	public List<OrderLineDTO> getOrderLinesbyOrderHeaderID(int orderHeaderID) {
		List<OrderLine> orderLines = orderLineDAO.getOrderLineByOrderHeaderID(orderHeaderID);
		List<OrderLineDTO> orderLineDTOList = new ArrayList<OrderLineDTO>();

		for (OrderLine ol : orderLines) {
			orderLineDTOList.add(orderLineMapper.mapToDTO(ol));
		}

		return orderLineDTOList;
	}
	
	public void deleteOrderLine(int theId) {
		orderLineDAO.deleteOrderLine(theId);

		
	}
	
}
