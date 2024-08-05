package com.subrutin.lingkar.catalog.exception;


public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 104821845L;

    public ResourceNotFoundException(String message) {
		super(message);
	}

}
