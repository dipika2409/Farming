package com.advices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class FarmerNotFoundException  extends Exception{

	public static final long serialVersionUID =1L;
	
	public FarmerNotFoundException(String message)
	{
		super (message);
	}
}