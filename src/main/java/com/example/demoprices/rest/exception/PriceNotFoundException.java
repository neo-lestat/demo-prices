package com.example.demoprices.rest.exception;

public class PriceNotFoundException  extends RuntimeException {
    public PriceNotFoundException(String message) {
        super(message);
    }
}
