package com.huba.shceduling.exception;

public abstract class APIException extends RuntimeException{

    public APIException(String message) {
        super(message);
    }
}
