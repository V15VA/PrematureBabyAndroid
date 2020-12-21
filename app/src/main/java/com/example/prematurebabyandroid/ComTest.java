package com.example.prematurebabyandroid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComTest {
    @SerializedName("patientID")
    @Expose
    private String patientID;

    @SerializedName("dataRequested")
    @Expose
    private String dataRequested;

    public String getPatientID() {return patientID;}
    public String getDataRequested() {return dataRequested;}
}

//{
//  "patientID": "1234",
//  "dataRequested": "abcd"
//  }

//patientID (string), time (time), comment (string)