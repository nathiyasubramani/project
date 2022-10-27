package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Orders does not exist with that Oder ID")
public class OrdersNotFoundException extends EntityNotFoundException{
	public OrdersNotFoundException() {}
	public OrdersNotFoundException(String msg) {
		super(msg);
	}

}
