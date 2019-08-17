package com.duoermei.healthmanage.exception;

import org.springframework.http.HttpStatus;

public abstract class ResourceException extends RuntimeException {

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getHttpStatus();
}
