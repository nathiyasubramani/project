package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.OrdersNotFoundException;
import com.example.persistence.domain.Customers;
import com.example.persistence.domain.Orders;
import com.example.persistence.repository.CustomersRepository;
import com.example.persistence.repository.OrdersRepository;
import com.example.rest.dto.CustomersDTO;
import com.example.rest.dto.OrdersDTO;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository orderRepo;
	
    @Autowired
    private ModelMapper mapper;

    private OrdersDTO mapToDTO(Orders orders) {
		return this.mapper.map(orders, OrdersDTO.class);
	}
    	public OrdersDTO addOrders(Orders order){
    		Orders saved = this.orderRepo.save(order);
    		return this.mapToDTO(saved);
    	}
    	
    	public List<Orders> readAll() {
    	return this.orderRepo.findAll();

    	}
    	
   }