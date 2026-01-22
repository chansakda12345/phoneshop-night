package com.sakda.java.school.phoneshop_night.exception;

import org.springframework.http.HttpStatus;

import com.sakda.java.school.phoneshop_night.entity.Brand;

public class ResourceNotFoundException extends ApiException{
	/*
	public ResourceNotFoundException(HttpStatus status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}
	*/
	public ResourceNotFoundException(String resourceName, Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s with id = %d",resourceName,id));
	}

}
