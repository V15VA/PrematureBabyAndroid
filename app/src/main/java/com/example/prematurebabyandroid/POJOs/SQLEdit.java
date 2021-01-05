package com.example.prematurebabyandroid.POJOs;

public class SQLEdit extends SQLQuery {
    //fields
    protected int patientID;

    public SQLEdit(int patientID){
        super();
        this.patientID = patientID;
    }
    public int getPatientID(){
        return patientID;
    }
}
