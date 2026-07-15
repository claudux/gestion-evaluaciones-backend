package com.institucion.exception;

//segunda excepcion creada, para comprobar que el numero de copias sea menor que 50
public class MaxCopiesExceededException extends RuntimeException {
    public MaxCopiesExceededException(String message) {
        super(message);
    }
}