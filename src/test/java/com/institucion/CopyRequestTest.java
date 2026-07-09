package com.institucion;

import org.junit.jupiter.api.Test;
import com.institucion.exception.MaxCopiesExceededException;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CopyRequestTest {

    @Test
    public void testSetRequestedCopies_WhenCopiesAre50OrMore_ShouldThrowException() {
        // 1. ARRANGE (Preparar el estado inicial)
        CopyRequest request = new CopyRequest();
        int invalidCopies = 50; // Límite frontera no permitido por el negocio

        // 2. ACT & 3. ASSERT (Actuar y Verificar semánticamente)
        assertThrows(MaxCopiesExceededException.class, () -> {
            request.setRequestedCopies(invalidCopies);
        }, "Debería lanzar InvalidCopyQuantityException si las copias solicitadas son >= 50");
    }
}