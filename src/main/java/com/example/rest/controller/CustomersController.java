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
import com.example.rest.dto.CustomersDTO;
import com.example.service.CustomersService;


@RestController
public class CustomersController {
	
	@Autowired
	private CustomersService service;
	
	@PostMapping("/addCustomers")
	public CustomersDTO addCustomers(@RequestBody Customers cust) {
		return service.addCustomers(cust);
	}
	@GetMapping("/allCustomers")
	public List<CustomersDTO> getAllCustomers(){
		return service.getAllCustomers();
	}
//	@PutMapping("/updateCustomers/{cust_id}")
//	public CustomersDTO updateCustomers(@PathVariable int cust_id, @RequestBody cust_firstname,) {
//		return service.updateCustomers(cust_id, band);
//}	
}