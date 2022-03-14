package com.powerminas.bookstore.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = -6775897693462296938L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}

}
