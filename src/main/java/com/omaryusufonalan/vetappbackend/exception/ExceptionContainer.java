package com.omaryusufonalan.vetappbackend.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ExceptionContainer {
    private String message;
    private LocalDateTime timeStamp;

    public ExceptionContainer(String message) {
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}
