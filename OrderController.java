package com.sg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sg.entity.Order;
import com.sg.entity.Product;
import com.sg.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping()
	public @ResponseBody List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@PostMapping()
	public @ResponseBody Order addProduct(@RequestBody Order o) {
		orderService.placeOrder(o);
		return o;
	}


}
