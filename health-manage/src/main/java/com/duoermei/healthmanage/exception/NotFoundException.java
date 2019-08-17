package com.duoermei.healthmanage.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ResourceException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
