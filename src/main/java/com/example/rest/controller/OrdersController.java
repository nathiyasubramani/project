package com.example.rest.controller;

import java.util.List;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Customers;
import com.example.persistence.domain.Orders;
import com.example.rest.dto.OrdersDTO;
import com.example.service.CustomersService;
import com.example.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService service;
	
	@PostMapping("/addOrders")
	public OrdersDTO addOrder(@RequestBody Orders order) {
		return service.addOrders(order);
	}
}