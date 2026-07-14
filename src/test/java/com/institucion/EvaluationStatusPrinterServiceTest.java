package com.institucion;

import com.institucion.exception.EvaluationNotPublishedException;
import com.institucion.exception.InvalidCopyQuantityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvaluationStatusPrinterServiceTest {
    //dummy para aislar notificacion
    private static class DummyNotificationStatusService implements NotificationService{
    @Override
    public void sendAlert(String email, String message){
        //de momento no hace nada, solo cascara
    }
    }
    @Test
    public void shouldThrowExceptionWhenEvaluationIsNotPublished(){
        //arrange
        NotificationService dummyNotifier = new DummyNotificationStatusService();
        EvaluationStatusPrinterService printerService = new EvaluationStatusPrinterService(dummyNotifier);
        Evaluation evaluation = new Evaluation(2345, "cduran@cftdelosrios.cl");//estado inicial pendiente

        //act assert
        assertThrows(EvaluationNotPublishedException.class, () -> {
            printerService.requestPrintJob(evaluation, 10);
        }, "Should throw EvaluationNotPublishedException if evaluation status is PENDING");

    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 50, 100})
    public void shouldThrowExceptionWhenCopyQuantityIsInvalid(int invalidCopies){
        //arrange
        NotificationService dummyNotifier = new DummyNotificationStatusService();
        EvaluationStatusPrinterService printerService = new EvaluationStatusPrinterService(dummyNotifier);
        Evaluation evaluation = new Evaluation(4565, "claudio.duran@cftdelosrios.cl");
        evaluation.publish();//cambiar estado a Publicado

        //act assert
        assertThrows(InvalidCopyQuantityException.class, () ->{
            printerService.requestPrintJob(evaluation, invalidCopies);
        }, "Should throw InvalidCopyQuantityException for copy amount: " + invalidCopies);
    }
}
