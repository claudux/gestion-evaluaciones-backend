package com.institucion;
//clase que engloba todo lo aprendido, revisa estado de evaluacion y se asegura que numero de copias sea menor que 50
import com.institucion.exception.EvaluationNotPublishedException;
import com.institucion.exception.InvalidCopyQuantityException;
import com.institucion.exception.InvalidEvaluationDateException;
import java.time.LocalDate;
public class EvaluationStatusPrinterService {
    private final NotificationService notificationService;

    public EvaluationStatusPrinterService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void requestPrintJob(Evaluation evaluation, int copies){
        //regla 1, evaluacion debe estar en Publicada
        if(!"Publicada".equals(evaluation.getStatus())){
            throw new EvaluationNotPublishedException("Cannot print an evaluation that is not published.");
        }

        //regla 2, la cantidad de copias >0 y <=50
        if (copies <=0 || copies >= 50){
            throw new InvalidCopyQuantityException("The number of copies must be greater than 0 and less than 50.");

        }

        //regla 3, la fecha debe ser el dia anterior
        if(!LocalDate.now().isBefore(evaluation.getEvaluationDate())){
            throw new InvalidEvaluationDateException("La impresión solo puede realizarse el dia anterior a la evaluación");
        }
        // si pasa las reglas, camino correcto
        String message = "Your printing job for evaluation " + evaluation.getId() + " with " + copies + " copies has been approved.";
        notificationService.sendAlert(evaluation.getStudentEmail(), message);
    }
}
