package com.example.persistence.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.persistence.domain.Customers;


@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long>{
	
	@Query("select c from Customers c where c.cust_firstname=?1")
	Optional<Customers> customersByName(String cust_firstname);
}