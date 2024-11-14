package com.example.micro2.infraestructura.exceptions;

import com.example.micro2.domian.exceptions.ErrorBadRequest;
import com.example.micro2.domian.exceptions.RegisterNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegisterNotFound.class)
    public ResponseEntity<String> registerNotFoundException(RegisterNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ErrorBadRequest.class)
    public ResponseEntity<String> errorBadRequestException(ErrorBadRequest ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
