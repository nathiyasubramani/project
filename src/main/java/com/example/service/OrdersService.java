package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CustomersNotFoundException;
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
    	
    	public OrdersDTO updateOrders(Long order_id, Orders orders) {
    		
    		Optional<Orders> tempOrders = Optional.of(this.orderRepo.findById((Long) order_id).orElseThrow(OrdersNotFoundException::new));
    		
    		Orders existing = tempOrders.get();
    		existing.setProd_qty(orders.getProd_qty());
    		existing.setProd_discount(orders.getProd_discount());
    		existing.setProd_price(orders.getProd_price());
    		existing.setTotal_amount(orders.getTotal_amount());
    		existing.setSaving_amount(orders.getSaving_amount());
    		existing.setTotal_qty(orders.getTotal_qty());
    		
    		Orders updated = this.orderRepo.save(existing);
    		return this.mapToDTO(updated);
    	}
    	
    	public boolean deleteOrders(Long id) {
    		this.orderRepo.findById(id).orElseThrow(OrdersNotFoundException::new);
    		this.orderRepo.deleteById(id);
    		boolean exists = this.orderRepo.existsById(id);
    		return !exists;
    	}
    	
    	public OrdersDTO readById(Long id) {
            Orders found = this.orderRepo.findById(id).orElseThrow(OrdersNotFoundException::new);
            return this.mapToDTO(found);
        }
    	
    	public List<OrdersDTO> getAllOrders() {
    		return this.orderRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    	}
   }