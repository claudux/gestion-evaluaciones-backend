package com.institucion;

import com.institucion.exception.InvalidEvaluationDateException;
import com.institucion.exception.InvalidCopyQuantityException;
import java.time.LocalDate;

public class EvaluationPrinterService {

    public void validarFechaImpresion(LocalDate fechaEvaluacion) throws InvalidEvaluationDateException {
        // buscar la fecha de mañana
        LocalDate manana = LocalDate.now().plusDays(1);


        //esta parte es para pasar a green
        if (!fechaEvaluacion.equals(manana)) {
            throw new InvalidEvaluationDateException("La fecha no corresponde a mañana.");
        }
    }
    public void validarCantidad(int cantidad) {
        // Si es menor o igual a 0 O si es mayor o igual a 50, se rechaza.
        if (cantidad <= 0 || cantidad >= 50) {
            throw new InvalidCopyQuantityException("La cantidad de copias debe ser mayor a 0 y menor a 50.");
        }
    }
}