package com.Mycode.InventoryManagement.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Mycode.InventoryManagement.dto.OrderLineDTO;
import com.Mycode.InventoryManagement.entity.OrderLine;


@Component
public class OrderLineMapper extends Mapper<OrderLineDTO, OrderLine> {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public OrderLineDTO mapToDTO(OrderLine e) {
		OrderLineDTO dto = new OrderLineDTO();
		
		dto.setProduct(productMapper.mapToDTO(e.getProduct()));
		dto.setOrderLineId(e.getOrderLineId());
		dto.setQuantity(e.getQuantity());
		dto.setTotal(e.getTotal());
		
		
		return dto;
	}

	@Override
	public OrderLine mapToEntity(OrderLineDTO theOrderLine) {
		OrderLine orderLine = new OrderLine();	
		orderLine.setOrderLineId(theOrderLine.getOrderLineId());
		orderLine.setQuantity(theOrderLine.getQuantity());
		orderLine.setTotal(theOrderLine.getTotal());
	
		return orderLine;

	}

}
