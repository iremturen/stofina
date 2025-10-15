package com.stofina.app.commondata.exception;

import org.springframework.http.HttpStatus;


public class TooManyRequestsException extends ApiException {
    public TooManyRequestsException(String message) {
        super(message, HttpStatus.TOO_MANY_REQUESTS);
    }
}