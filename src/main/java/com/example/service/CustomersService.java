package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.exception.CustomersNotFoundException;
import com.example.persistence.domain.Customers;
import com.example.persistence.repository.CustomersRepository;
import com.example.rest.dto.CustomersDTO;


@Service

public class CustomersService {
	
    @Autowired
	private CustomersRepository custRepo;
    
    @Autowired
    private ModelMapper mapper;

  	private CustomersDTO mapToDTO(Customers customers) {
		return this.mapper.map(customers, CustomersDTO.class);
	}
	
	public CustomersDTO addCustomers(Customers cust) {
		Customers saved = this.custRepo.save(cust);
		return this.mapToDTO(saved);
	}
	public List<CustomersDTO> getAllCustomers() {
		return this.custRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public CustomersDTO updateCustomers(int cust_id, Customers customers) {
		Optional<Customers> tempCustomers = Optional.of(this.custRepo.findById((long) cust_id).orElseThrow(CustomersNotFoundException::new));
		
		Customers existing = tempCustomers.get();
		existing.setCust_firstname(customers.getCust_firstname());
		existing.setOrders(customers.getOrders());
		
		Customers updated = this.custRepo.save(existing);
		return this.mapToDTO(updated);
	}
}