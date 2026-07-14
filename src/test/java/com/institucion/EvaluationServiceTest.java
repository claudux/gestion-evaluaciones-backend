package com.institucion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EvaluationServiceTest {
    //dummy para aislar el test
    private static class DummyNotificationService implements NotificationService{
        @Override
        public void sendAlert(String studentEmail, String message){

        }
    }

    @Test
    public void publicarEvaluacionCambiarEstadoaPublicada(){
        //arrange
        NotificationService dummyNotifier = new DummyNotificationService();
        EvaluationService evaluationService = new EvaluationService(dummyNotifier);
        int evaluationID = 2536;

        //act
        evaluationService.publishEvaluation(evaluationID);

        //assert
        assertEquals("Publicada", evaluationService.getStatus(),"El estado de la evaluación deberia cambiar a Publicada");
    }
}
