package com.dutchviking.iot.app.exceptions.custom;

public class CustomEntityNotFoundException extends RuntimeException{

    public CustomEntityNotFoundException(String message) {
        super(message);
    }
}
