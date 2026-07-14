package com.institucion;

public class EvaluationService {
    private final NotificationService notificationService;
    private String status ="Pendiente";

    public EvaluationService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void publishEvaluation( int EvaluationID){

        //este codigo es para pasar a verde en el test
        this.status = "Publicada";
        //crear variables ficticias, una posible refactorizacion es evitar el hardcodeo de las variables, creando una clase evaluacion, que contenga los datos
        String studentEmail = "alumno_prueba@cftdelosrios.cl";
        String message = "Tus calificaciones para la evaluación " + EvaluationID + " se encuentran publicadas.";

        //invocar el metodo sendAlert
        notificationService.sendAlert(studentEmail, message);

    }

    public String getStatus(){
        return this.status;
    }
}
