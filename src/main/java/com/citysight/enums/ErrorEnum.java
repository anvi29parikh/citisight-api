package com.citysight.enums;


public enum ErrorEnum {
    // ENUMS
    METHOD_LOGIC_ERROR("101", "An error occurred while executing the Logic"),
    BAD_REQUEST("400", "bad request"),
    ACCESS_DENIED("401", "Access Denied."),
    FORBIDDEN("403", "Access Denied."),
    NOT_FOUND("404", "File not found"),
    CONFLICT("409", "Conflict with the data"),
    SERVICE_UNAVAILABLE("503", "Service not available"),
    //TODO add here

    ;
    // properties
    private final String errorCode;
    private final String message;
    
    // Getters
	public String getErrorCode() {
		return errorCode;
	}
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param errorCode
	 * @param message
	 */
	private ErrorEnum(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
}
