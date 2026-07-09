package com.institucion.exception;

public class MaxCopiesExceededException extends RuntimeException {
    public MaxCopiesExceededException(String message) {
        super(message);
    }
}