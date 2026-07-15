package com.institucion;

//interfaz para enviar mensaje al estudiante cuando cambie el estado de su evaluación.
public interface NotificationService {
    void sendAlert(String studentEmail, String message);
}
