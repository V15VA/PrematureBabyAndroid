package com.example.prematurebabyandroid.POJOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLEdit extends SQLQuery implements Executeable {
    //edited
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
