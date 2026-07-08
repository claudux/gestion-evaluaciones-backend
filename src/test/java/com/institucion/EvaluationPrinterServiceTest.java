package com.institucion;

import com.institucion.exception.InvalidEvaluationDateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EvaluationPrinterServiceTest {

    // REFACTOR: Usamos un MethodSource para probar muchas fechas incorrectas
    // sin repetir código, centralizando los datos de prueba.
    static Stream<LocalDate> fechasInvalidasProvider() {
        return Stream.of(
                LocalDate.now(),                // Hoy (inválido, debe ser mañana)
                LocalDate.now().minusDays(1),   // Ayer
                LocalDate.now().plusDays(2)     // Pasado mañana
        );
    }

    @ParameterizedTest
    @MethodSource("fechasInvalidasProvider")
    @DisplayName("Debería lanzar excepción si la fecha no es mañana")
    public void validarFechaImpresion_conFechasInvalidas_deberiaLanzarExcepcion(LocalDate fechaInvalida) {
        EvaluationPrinterService service = new EvaluationPrinterService();

        assertThrows(InvalidEvaluationDateException.class, () -> {
            service.validarFechaImpresion(fechaInvalida);
        });
    }
}
