package com.institucion;

import com.institucion.exception.MaxCopiesExceededException;
//clase para verificar que el numero de copias sea menor que 50
public class CopyRequest {

    private int requestedCopies;

    public CopyRequest() {
        this.requestedCopies = 0;
    }

    public void setRequestedCopies(int copies) {
        if (copies >= 50) {
            throw new MaxCopiesExceededException("El número de copias solicitadas debe ser inferior a 50.");
        }
        this.requestedCopies = copies;
    }

    public int getRequestedCopies() {
        return this.requestedCopies;
    }
}