package com.okravtsiv.authservice.domain.exception;

import org.springframework.http.HttpStatus;

public class CustomApiException extends RuntimeException {

    private HttpStatus httpStatus;

    public CustomApiException() {
    }

    public CustomApiException(String message) {
        super(message);
    }

    public CustomApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
