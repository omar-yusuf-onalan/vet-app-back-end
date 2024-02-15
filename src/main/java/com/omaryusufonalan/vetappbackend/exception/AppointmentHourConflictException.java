package com.omaryusufonalan.vetappbackend.exception;

public class AppointmentHourConflictException extends RuntimeException {
    public AppointmentHourConflictException(String message) {
        super(message);
    }
}
