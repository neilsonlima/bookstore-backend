package com.powerminas.bookstore.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7362438706734655919L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

}
