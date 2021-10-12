package com.citysight.security.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CustomSecurityException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;
    

    public CustomSecurityException(CustomSecurityException e) {
        this.message = e.getMessage();
        this.httpStatus = e.getHttpStatus();
    }
}
