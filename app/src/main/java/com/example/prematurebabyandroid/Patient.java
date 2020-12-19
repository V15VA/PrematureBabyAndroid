package com.example.prematurebabyandroid;

import com.google.gson.annotations.SerializedName;

public class Patient {
    @SerializedName("patient_id")
    private int patient_id;

    @SerializedName("time_")
    private String time_;

    @SerializedName("potassium")
    private float potassium;

    @SerializedName("sodium")
    private float sodium;

    @SerializedName("lactate")
    private float lactate;

    @SerializedName("glucose")
    private float glucose;

    public Patient(int patient_id, String time_, float potassium, float sodium, float lactate, float glucose) {
        this.patient_id = patient_id;
        this.time_ = time_;
        this.potassium = potassium;
        this.sodium = sodium;
        this.lactate = lactate;
        this.glucose = glucose;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getTime_() {
        return time_;
    }

    public void setTime_(String time_) {
        this.time_ = time_;
    }

    public float getPotassium() {
        return potassium;
    }

    public void setPotassium(float potassium) {
        this.potassium = potassium;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public float getLactate() {
        return lactate;
    }

    public void setLactate(float lactate) {
        this.lactate = lactate;
    }

    public float getGlucose() {
        return glucose;
    }

    public void setGlucose(float glucose) {
        this.glucose = glucose;
    }
}
