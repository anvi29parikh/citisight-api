package com.citysight.dto;

public class ErrorDto {
    private final String status;
    private final String message;
    
    // Getters
	public String getStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}


	/**
	 * @param status
	 * @param message
	 */
	public ErrorDto(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
    
    
}
