package com.advices;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class SupplierNotFoundException extends Exception
{
	public SupplierNotFoundException(String message){
	        super(message);
	    }
}

