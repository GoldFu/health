package com.duoermei.healthmanage.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ResourceException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
