package com.citysight.exception;

import com.citysight.dto.AwErrorDto;
import com.citysight.enums.ErrorEnum;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.ServiceUnavailable;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {
    //TODO Implement more Exceptions
    // priority: 5

    //handle CUSTOM exceptions
    @ExceptionHandler(CustomException.class)
    protected AwErrorDto handleCustomException(HttpServletResponse response, CustomException e) throws IOException {
        response.setStatus(e.getHttpStatus().value());
        return new AwErrorDto(e.getErrorEnum().getErrorCode(), e.getErrorEnum().getMessage());
    }

    // handle BAD_REQUEST 400 exceptions
    @ExceptionHandler(BadRequest.class)
    public AwErrorDto handleBadRequest(HttpServletResponse response, BadRequest e) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new AwErrorDto(ErrorEnum.BAD_REQUEST.getErrorCode(), ErrorEnum.BAD_REQUEST.getMessage());
    }

    // handle UNAUTHORIZED 401 exceptions
    @ExceptionHandler(AccessDeniedException.class)
    protected AwErrorDto handleAccessDenied(HttpServletResponse response, AccessDeniedException e) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return new AwErrorDto(ErrorEnum.ACCESS_DENIED.getErrorCode(), ErrorEnum.ACCESS_DENIED.getMessage());
    }

    // handle NOT_FOUND 404 exception
    @ExceptionHandler(NotFoundException.class)
    protected AwErrorDto handleNotFound(HttpServletResponse response, NotFoundException e) throws IOException {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new AwErrorDto(ErrorEnum.NOT_FOUND.getErrorCode(), ErrorEnum.NOT_FOUND.getMessage());
    }

    // handle ILLEGAL_ARGUMENT 409 exception
    @ExceptionHandler(IllegalArgumentException.class)
    protected AwErrorDto handleIllegalArgument(HttpServletResponse response, IllegalArgumentException e) throws IOException {
        response.setStatus(HttpStatus.CONFLICT.value());
        return new AwErrorDto(ErrorEnum.CONFLICT.getErrorCode(), ErrorEnum.CONFLICT.getMessage());
    }

    // handle SERVICE_UNAVAILABLE 503(for all 5XX) exception
    @ExceptionHandler(ServiceUnavailable.class)
    protected AwErrorDto handleServiceUnavailable(HttpServletResponse response, ServiceUnavailable e) throws IOException {
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        return new AwErrorDto(ErrorEnum.SERVICE_UNAVAILABLE.getErrorCode(), ErrorEnum.SERVICE_UNAVAILABLE.getMessage());
    }

    // Handle all kinds of UNHANDLED exceptions
    @ExceptionHandler(Exception.class)
    protected AwErrorDto handleException(HttpServletResponse response, Exception e) throws IOException {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new AwErrorDto(ErrorEnum.METHOD_LOGIC_ERROR.getErrorCode(), ErrorEnum.METHOD_LOGIC_ERROR.getMessage());
    }
}