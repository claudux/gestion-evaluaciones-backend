package com.institucion;
//clase que permite crear objetos Evaluation, para encapsular datos y evitar hardcoreo.
public class Evaluation {
    private final int id;
    private final String studentEmail;
    private String status;

    public Evaluation(int id, String studentEmail){
        this.id = id;
        this. studentEmail = studentEmail;
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
}
