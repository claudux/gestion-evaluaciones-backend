package com.institucion;

import com.institucion.exception.InvalidEvaluationDateException;
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
}