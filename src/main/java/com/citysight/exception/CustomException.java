package com.citysight.exception;

import  com.citysight.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private ErrorEnum errorEnum;
    private HttpStatus httpStatus;

    public CustomException(CustomException e) {
        this.errorEnum = e.getErrorEnum();
        this.httpStatus = e.getHttpStatus();
    }
}
