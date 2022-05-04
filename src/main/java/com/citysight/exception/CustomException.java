package com.citysight.exception;

import  com.citysight.enums.ErrorEnum;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorEnum errorEnum;
    private HttpStatus httpStatus;

    public CustomException(CustomException e) {
        this.errorEnum = e.getErrorEnum();
        this.httpStatus = e.getHttpStatus();
    }

	public ErrorEnum getErrorEnum() {
		return errorEnum;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param errorEnum
	 * @param httpStatus
	 */
	public CustomException(ErrorEnum errorEnum, HttpStatus httpStatus) {
		super();
		this.errorEnum = errorEnum;
		this.httpStatus = httpStatus;
	}
    
    
	
}
