package com.institucion;

import java.time.LocalDate;

//clase que permite crear objetos Evaluation, para encapsular datos y evitar hardcoreo.
public class Evaluation {
    private final int id;
    private final String studentEmail;
    private final LocalDate evaluationDate;
    private String status;

    public Evaluation(int id, String studentEmail, LocalDate evaluationDate){
        this.id = id;
        this. studentEmail = studentEmail;
        this.evaluationDate = evaluationDate;
        this.status = "Pendiente";
    }

    public void publish(){
        this.status = "Publicada";
    }

    public int getId(){
        return id;
    }

    public String getStudentEmail(){
        return studentEmail;
    }

    public String getStatus(){
        return status;
    }

    public LocalDate getEvaluationDate(){
        return evaluationDate;
    }
}
