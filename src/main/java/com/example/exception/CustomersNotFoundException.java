package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customers does not exist with that Customer ID")
public class CustomersNotFoundException extends EntityNotFoundException{
	public CustomersNotFoundException() {}
	public CustomersNotFoundException(String msg) {
		super(msg);
	}

}
