package com.institucion;

import com.institucion.exception.InvalidCopyQuantityException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluationPrinterTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 50, 100}) // Valores fuera del rango permitido (rango válido: 1 a 49)
    @DisplayName("Debería lanzar InvalidCopyQuantityException si las copias no están entre 1 y 49")
    public void testValidarCantidad_WhenValuesAreOutsideRange_ShouldThrowException(int invalidCopies) {
        // 1. ARRANGE
        EvaluationPrinterService service = new EvaluationPrinterService();

        // 2. ACT & 3. ASSERT
        assertThrows(InvalidCopyQuantityException.class, () -> {
            service.validarCantidad(invalidCopies);
        }, "Falló el bloqueo para el valor inválido: " + invalidCopies);
    }
}