package com.Java8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException
{
 String s;

public ResourceNotFoundException(String s) {
	super();
	this.s = s;
}
 
}
