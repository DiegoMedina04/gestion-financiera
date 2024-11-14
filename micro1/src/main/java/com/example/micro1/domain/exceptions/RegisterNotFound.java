package com.example.micro1.domain.exceptions;

public class RegisterNotFound extends RuntimeException{
    public RegisterNotFound(String message) {
        super(message);
    }
}
