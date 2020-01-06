package com.okravtsiv.authservice.domain.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(handleException(HttpStatus.BAD_REQUEST, ex), HttpStatus.CREATED);
    }

    @ExceptionHandler(value = {CustomApiException.class})
    protected ResponseEntity<Object> handleCustomApiException(RuntimeException ex, WebRequest request) {
        HttpStatus httpStatus = ((CustomApiException) ex).getHttpStatus();
        return new ResponseEntity<>(handleException(httpStatus, ex), httpStatus);
    }

    private ExceptionDTO handleException(HttpStatus httpStatus, RuntimeException ex) {
        return new ExceptionDTO(httpStatus.value(), httpStatus.name(), ex.getMessage(), LocalDateTime.now(), httpServletRequest.getRequestURI());
    }
}
