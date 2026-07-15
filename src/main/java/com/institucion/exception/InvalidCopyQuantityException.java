package com.institucion.exception;

//tercera excepcion creada, para comprobar que numero de copias sea mayor que 0
public class InvalidCopyQuantityException extends RuntimeException {
    public InvalidCopyQuantityException(String message) {
        super(message);
    }
}