package com.example.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
//	@Query("select o from Orders o where o.order_id=?1")
//	Optional<List<Orders>> ordersById(int order_id);

}
