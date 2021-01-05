package com.example.prematurebabyandroid.POJOs;

import java.util.ArrayList;

public class Patient {
    private ArrayList<Integer> patient_id;
    private ArrayList<String> comment;
    private ArrayList<Double> glucose;
    private ArrayList<Double> lactate;
    private ArrayList<Double> sodium;
    private ArrayList<Double> potassium;
    private ArrayList<String> event_type;
    private ArrayList<String> time;


    public Patient(int patient_id, ArrayList<String> comment, ArrayList<Double> glucose, ArrayList<Double> lactate,
                   ArrayList<Double> sodium, ArrayList<Double> potassium, ArrayList<String> event_type, ArrayList<String> time) {

        this.comment = comment;
        this.glucose = glucose;
        this.lactate = lactate;
        this.sodium = sodium;
        this.potassium = potassium;
        this.event_type = event_type;
        this.time = time;

    }

    public ArrayList<Integer> getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(ArrayList<Integer> patient_id) {
        this.patient_id = patient_id;
    }

    public ArrayList<String> getComment() {
        return comment;
    }

    public void setComment(ArrayList<String> comment) {
        this.comment = comment;
    }

    public ArrayList<Double> getGlucose() {
        return glucose;
    }

    public void setGlucose(ArrayList<Double> glucose) {
        this.glucose = glucose;
    }

    public ArrayList<Double> getLactate() {
        return lactate;
    }

    public void setLactate(ArrayList<Double> lactate) {
        this.lactate = lactate;
    }

    public ArrayList<Double> getSodium() {
        return sodium;
    }

    public void setSodium(ArrayList<Double> sodium) {
        this.sodium = sodium;
    }

    public ArrayList<Double> getPotassium() {
        return potassium;
    }

    public void setPotassium(ArrayList<Double> potassium) {
        this.potassium = potassium;
    }

    public ArrayList<String> getEvent_type() {
        return event_type;
    }

    public void setEvent_type(ArrayList<String> event_type) {
        this.event_type = event_type;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public String getRow(int rowNum) {
        return "Patient{" +
                "patientID=" + patient_id.get(rowNum) +
                ", comment=" + comment +
                ", glucose=" + glucose.get(rowNum) +
                ", lactate=" + lactate.get(rowNum) +
                ", sodium=" + sodium.get(rowNum) +
                ", potassium=" + potassium.get(rowNum) +
                ", event_type=" + event_type.get(rowNum) +
                ", time=" + time.get(rowNum) +
                '}';
    }

    @Override
    public String toString() {
        return "AndroidPatient{" +
                "patientID=" + patient_id +
                ", comment=" + comment +
                ", glucose=" + glucose +
                ", lactate=" + lactate +
                ", sodium=" + sodium +
                ", potassium=" + potassium +
                ", event_type=" + event_type +
                ", time=" + time +
                '}';
    }
}
