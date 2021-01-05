package com.example.prematurebabyandroid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Time;

public class OLD_Request {
    @SerializedName("_type")
//    @Expose
    private String _type;

    @SerializedName("patientID")
    @Expose
    private String patientID;

    @SerializedName("comment")
    private String comment;

    @SerializedName("glucose_manual")
    @Expose
    private Double glucose_manual;

    @SerializedName("lactate_manual")
    private Double lactate_manual;

    @SerializedName("sodium_manual")
    private Double sodium_manual;

    @SerializedName("potassium_manual")
    private Double potassium_manual;

    @SerializedName("event_type")
    private String event_type;

    @SerializedName("time")
    private Time time;

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public Double getGlucose_manual() {
        return glucose_manual;
    }

    public void setGlucose_manual(Double glucose_manual) {
        this.glucose_manual = glucose_manual;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public Double getLactate_manual() {
        return lactate_manual;
    }

    public void setLactate_manual(Double lactate_manual) {
        this.lactate_manual = lactate_manual;
    }

    public Double getSodium_manual() {
        return sodium_manual;
    }

    public void setSodium_manual(Double sodium_manual) {
        this.sodium_manual = sodium_manual;
    }

    public Double getPotassium_manual() {
        return potassium_manual;
    }

    public void setPotassium_manual(Double potassium_manual) {
        this.potassium_manual = potassium_manual;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type='" + _type + '\'' +
                ", patientID='" + patientID + '\'' +
                ", comment='" + comment + '\'' +
                ", glucose_manual=" + glucose_manual +
                ", lactate_manual=" + lactate_manual +
                ", sodium_manual=" + sodium_manual +
                ", potassium_manual=" + potassium_manual +
                ", event_type='" + event_type + '\'' +
                ", time=" + time +
                '}';
    }
}
