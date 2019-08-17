package com.duoermei.healthmanage.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ResourceException {

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
