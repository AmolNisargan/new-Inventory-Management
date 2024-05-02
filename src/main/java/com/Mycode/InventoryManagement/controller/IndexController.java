package com.Mycode.InventoryManagement.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Mmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Mycode.InventoryManagement.dto.OrderHeaderDTO;
import com.Mycode.InventoryManagement.dto.OrderLineDTO;
import com.Mycode.InventoryManagement.service.OrderHeaderService;
import com.Mycode.InventoryManagement.service.OrderLineService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private OrderHeaderService orderHeaderService;

	@Autowired
	private OrderLineService orderLineService;

	@GetMapping("/")
	public ModelAndView showHome1() {
//		
//		List<OrderLine>p=orderRepository.findAll();
//		System.out.println(p);
		List<OrderHeaderDTO> theOrderHeader = orderHeaderService.getAllOrders();

		List<OrderLineDTO> theOrderLine = orderLineService.getOrderLines();

//		System.out.println(theOrderLine + "*****");
		List<String> al = new ArrayList<String>();
		List<Integer> Q = new ArrayList<Integer>();
		List<Integer> P = new ArrayList<Integer>();
		List<Integer> T = new ArrayList<Integer>();
		Map<String, Integer> MT = new HashMap<String, Integer>();
		for (OrderLineDTO x : theOrderLine) {
			Q.add(x.getQuantity());
			P.add(x.getProduct().getProductId());
		}
		
		System.out.println(P);

		for (int i = 0; i < P.size(); i++) {
			int sum = Q.get(i);
			for (int j = i + 1; j < P.size(); j++) {
				if (P.get(i).equals(P.get(j)) && P.get(i) != -1) {
					sum = sum + Q.get(j);
					P.set(j, -1);
				}
			}
			if (P.get(i) != -1) {
				System.out.println(sum);
				T.add(sum);
			}
		}

		for (OrderLineDTO i : theOrderLine) {
			al.add(i.getProduct().getName());
		}
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 0; i < al.size(); i++) {
			int c = 1;
			for (int j = i + 1; j < al.size(); j++) {
				if (al.get(i).equals(al.get(j))) {
					c++;
					al.remove(j);

					j--;

				}

			}
			if (c != 0) {
//			System.out.println(al.get(i)+" "+c);
				m.put(al.get(i), c);
				MT.put(al.get(i), T.get(i));
			}
		}
		System.out.println(m);
		System.out.println(MT);

		List<String> orderStatusList = new ArrayList<String>();
		orderStatusList.clear();
		orderStatusList.add("Complete");
		ModelAndView model1 = new ModelAndView();
		model1.setViewName("index");
		model1.addObject("orderheader", theOrderHeader);
		model1.addObject("orderStatusList", orderStatusList);
		model1.addObject("abc", m);
		model1.addObject("mt", MT);

		return model1;
	}

	@GetMapping("/create")
	public String createOrder() {

		return "redirect:/homeController/load";
	}

}
