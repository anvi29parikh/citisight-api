package com.citysight.security.exceptions;

import org.springframework.http.HttpStatus;

public class CustomSecurityException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message;
    private final HttpStatus httpStatus;
    

    public CustomSecurityException(CustomSecurityException e) {
        this.message = e.getMessage();
        this.httpStatus = e.getHttpStatus();
    }


	public String getMessage() {
		return message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	/**
	 * @param message
	 * @param httpStatus
	 */
	public CustomSecurityException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
    
    
}
