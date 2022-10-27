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
	
    public CustomersService(CustomersRepository custRepo, ModelMapper mapper) {
		super();
		this.custRepo = custRepo;
		this.mapper = mapper;
	}
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
	
	public CustomersDTO updateCustomers(Long cust_id, Customers customers) {
		
		Optional<Customers> tempCustomers = Optional.of(this.custRepo.findById((Long) cust_id).orElseThrow(CustomersNotFoundException::new));
		
		Customers existing = tempCustomers.get();
		existing.setCust_firstname(customers.getCust_firstname());
		existing.setCust_lastname(customers.getCust_lastname());
		existing.setCust_address(customers.getCust_address());
		existing.setCust_city(customers.getCust_city());
		existing.setCust_countrycode(customers.getCust_countrycode());
		existing.setCust_zipcode(customers.getCust_zipcode());
		existing.setCust_dob(customers.getCust_dob());
		existing.setCust_mobileno(customers.getCust_mobileno());
		existing.setCust_emailid(customers.getCust_emailid());
		existing.setOrders(customers.getOrders());
		
		Customers updated = this.custRepo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteCustomers(Long id) {
		this.custRepo.findById(id).orElseThrow(CustomersNotFoundException::new);
		this.custRepo.deleteById(id);
		boolean exists = this.custRepo.existsById(id);
		return !exists;
	}
	
	public CustomersDTO readById(Long id) {
        Customers found = this.custRepo.findById(id).orElseThrow(CustomersNotFoundException::new);
        return this.mapToDTO(found);
    }
}