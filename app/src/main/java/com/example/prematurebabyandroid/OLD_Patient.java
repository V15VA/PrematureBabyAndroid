package com.example.prematurebabyandroid;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;

public class OLD_Patient {
    @SerializedName("patient_id")
    private String patient_id;

    @SerializedName("time_")
    private Time time_;

    @SerializedName("potassium")
    private double potassium;

    @SerializedName("sodium")
    private double sodium;

    @SerializedName("lactate")
    private double lactate;

    @SerializedName("glucose")
    private double glucose;

//    public Patient(String patient_id, String time_, float potassium, float sodium, float lactate, float glucose) {
//        this.patient_id = patient_id;
//        this.time_ = time_;
//        this.potassium = potassium;
//        this.sodium = sodium;
//        this.lactate = lactate;
//        this.glucose = glucose;
//    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public Time getTime_() {
        return time_;
    }

    public void setTime_(Time time_) {
        this.time_ = time_;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(float potassium) {
        this.potassium = potassium;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public double getLactate() {
        return lactate;
    }

    public void setLactate(float lactate) {
        this.lactate = lactate;
    }

    public double getGlucose() {
        return glucose;
    }

    public void setGlucose(float glucose) {
        this.glucose = glucose;
    }
}
