package com.example.micro2.domian.exceptions;

public class ErrorBadRequest extends RuntimeException {
    public ErrorBadRequest(String mensaje) {
        super(mensaje);
    }
}
