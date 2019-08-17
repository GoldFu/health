package com.duoermei.healthmanage.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ResourceException {

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
