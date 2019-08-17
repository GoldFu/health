package com.duoermei.healthmanage.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ResourceException {

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
