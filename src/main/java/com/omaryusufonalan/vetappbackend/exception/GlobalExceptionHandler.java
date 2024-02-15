package com.omaryusufonalan.vetappbackend.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleException(EntityNotFoundException e) {
        return new ResponseEntity<>(new ExceptionContainer(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VaccineInEffectException.class)
    public ResponseEntity<?> handleException(VaccineInEffectException e) {
        return new ResponseEntity<>(new ExceptionContainer(e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DoctorNotAvailableException.class)
    public ResponseEntity<?> handleException(DoctorNotAvailableException e) {
        return new ResponseEntity<>(new ExceptionContainer(e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }
}
