package com.institucion.exception;


//prinera excepcion creada, para ejercicio de comprobar fecha de evaluacion.
public class InvalidEvaluationDateException extends Exception {
    public InvalidEvaluationDateException(String message) {
        super(message);
    }
}
