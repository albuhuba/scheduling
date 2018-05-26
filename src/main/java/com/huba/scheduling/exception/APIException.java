package com.huba.scheduling.exception;

public abstract class APIException extends RuntimeException{

    public APIException() {
    }

    public APIException(String message) {
        super(message);
    }
}
