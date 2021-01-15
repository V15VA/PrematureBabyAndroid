package com.example.prematurebabyandroid.POJOs;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Patient implements Parcelable {
    private ArrayList<Integer> patient_id;
    private ArrayList<String> date;
    private ArrayList<String> time;
    private ArrayList<Double> potassium;
    private ArrayList<Double> sodium;
    private ArrayList<Double> lactate;
    private ArrayList<Double> glucose;
    private ArrayList<Double> potassium_input;
    private ArrayList<Double> sodium_input;
    private ArrayList<Double> lactate_input;
    private ArrayList<Double> glucose_input;
    private ArrayList<String> event_type;
    private ArrayList<String> comments;
    private ArrayList<String> presrcription;
    private ArrayList<String> filter_type;


//    public Patient(int patient_id, ArrayList<String> comments, ArrayList<Double> glucose, ArrayList<Double> lactate,
//                   ArrayList<Double> sodium, ArrayList<Double> potassium, ArrayList<String> event_type, ArrayList<String> time) {
//
//        this.comments = comments;
//        this.glucose = glucose;
//        this.lactate = lactate;
//        this.sodium = sodium;
//        this.potassium = potassium;
//        this.event_type = event_type;
//        this.time = time;
//
//    }

    public Patient(int patient_id, ArrayList<String> date, ArrayList<String> time,
                   ArrayList<Double> potassium, ArrayList<Double> sodium, ArrayList<Double> lactate,
                   ArrayList<Double> glucose, ArrayList<Double> potassium_input,
                   ArrayList<Double> sodium_input, ArrayList<Double> lactate_input,
                   ArrayList<Double> glucose_input, ArrayList<String> event_type,
                   ArrayList<String> comments, ArrayList<String> presrcription,
                   ArrayList<String> filter_type) {
        this.date = date;
        this.time = time;
        this.potassium = potassium;
        this.sodium = sodium;
        this.lactate = lactate;
        this.glucose = glucose;
        this.potassium_input = potassium_input;
        this.sodium_input = sodium_input;
        this.lactate_input = lactate_input;
        this.glucose_input = glucose_input;
        this.event_type = event_type;
        this.comments = comments;
        this.presrcription = presrcription;
        this.filter_type = filter_type;
    }



//    public ArrayList<Integer> getPatient_id() {
//        return patient_id;
//    }
//
//    public void setPatient_id(ArrayList<Integer> patient_id) {
//        this.patient_id = patient_id;
//    }
//
//    public ArrayList<String> getComments() {
//        return comments;
//    }
//
//    public void setComments(ArrayList<String> comments) {
//        this.comments = comments;
//    }
//
//    public ArrayList<Double> getGlucose() {
//        return glucose;
//    }
//
//    public void setGlucose(ArrayList<Double> glucose) {
//        this.glucose = glucose;
//    }
//
//    public ArrayList<Double> getLactate() {
//        return lactate;
//    }
//
//    public void setLactate(ArrayList<Double> lactate) {
//        this.lactate = lactate;
//    }
//
//    public ArrayList<Double> getSodium() {
//        return sodium;
//    }
//
//    public void setSodium(ArrayList<Double> sodium) {
//        this.sodium = sodium;
//    }
//
//    public ArrayList<Double> getPotassium() {
//        return potassium;
//    }
//
//    public void setPotassium(ArrayList<Double> potassium) {
//        this.potassium = potassium;
//    }
//
//    public ArrayList<String> getEvent_type() {
//        return event_type;
//    }
//
//    public void setEvent_type(ArrayList<String> event_type) {
//        this.event_type = event_type;
//    }
//
//    public ArrayList<String> getTime() {
//        return time;
//    }
//
//    public void setTime(ArrayList<String> time) {
//        this.time = time;
//    }


    protected Patient(Parcel in) {
        date = in.createStringArrayList();
        time = in.createStringArrayList();
        event_type = in.createStringArrayList();
        comments = in.createStringArrayList();
        presrcription = in.createStringArrayList();
        filter_type = in.createStringArrayList();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    public ArrayList<Integer> getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(ArrayList<Integer> patient_id) {
        this.patient_id = patient_id;
    }

    public ArrayList<String> getDate() {
        return date;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public ArrayList<Double> getPotassium() {
        return potassium;
    }

    public void setPotassium(ArrayList<Double> potassium) {
        this.potassium = potassium;
    }

    public ArrayList<Double> getSodium() {
        return sodium;
    }

    public void setSodium(ArrayList<Double> sodium) {
        this.sodium = sodium;
    }

    public ArrayList<Double> getLactate() {
        return lactate;
    }

    public void setLactate(ArrayList<Double> lactate) {
        this.lactate = lactate;
    }

    public ArrayList<Double> getGlucose() {
        return glucose;
    }

    public void setGlucose(ArrayList<Double> glucose) {
        this.glucose = glucose;
    }

    public ArrayList<Double> getPotassium_input() {
        return potassium_input;
    }

    public void setPotassium_input(ArrayList<Double> potassium_input) {
        this.potassium_input = potassium_input;
    }

    public ArrayList<Double> getSodium_input() {
        return sodium_input;
    }

    public void setSodium_input(ArrayList<Double> sodium_input) {
        this.sodium_input = sodium_input;
    }

    public ArrayList<Double> getLactate_input() {
        return lactate_input;
    }

    public void setLactate_input(ArrayList<Double> lactate_input) {
        this.lactate_input = lactate_input;
    }

    public ArrayList<Double> getGlucose_input() {
        return glucose_input;
    }

    public void setGlucose_input(ArrayList<Double> glucose_input) {
        this.glucose_input = glucose_input;
    }

    public ArrayList<String> getEvent_type() {
        return event_type;
    }

    public void setEvent_type(ArrayList<String> event_type) {
        this.event_type = event_type;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getPresrcription() {
        return presrcription;
    }

    public void setPresrcription(ArrayList<String> presrcription) {
        this.presrcription = presrcription;
    }

    public ArrayList<String> getFilter_type() {
        return filter_type;
    }

    public void setFilter_type(ArrayList<String> filter_type) {
        this.filter_type = filter_type;
    }

//    public String getRow(int rowNum) {
//        return "Patient{" +
//                "patientID=" + patient_id.get(rowNum) +
////                ", comment=" + comments.get(rowNum) +
//                ", glucose=" + glucose.get(rowNum) +
//                ", lactate=" + lactate.get(rowNum) +
//                ", sodium=" + sodium.get(rowNum) +
//                ", potassium=" + potassium.get(rowNum) +
//                ", event_type=" + event_type.get(rowNum) +
//                ", time=" + time.get(rowNum) +
//                '}';
//    }

    public int getLen(){
        return patient_id.size();
    }


    public String getRow(int rowNum) {
        return "Patient{" +
                "patient_id=" + patient_id.get(rowNum) +
                ", date=" + date.get(rowNum) +
                ", time=" + time.get(rowNum) +
                ", potassium=" + potassium.get(rowNum) +
                ", sodium=" + sodium.get(rowNum) +
                ", lactate=" + lactate.get(rowNum) +
                ", glucose=" + glucose.get(rowNum) +
                ", potassium_input=" + potassium_input.get(rowNum) +
                ", sodium_input=" + sodium_input.get(rowNum) +
                ", lactate_input=" + lactate_input.get(rowNum) +
                ", glucose_input=" + glucose_input.get(rowNum) +
                ", event_type=" + event_type.get(rowNum) +
                ", comments=" + comments.get(rowNum) +
//                ", presrcription=" + presrcription.get(rowNum) +
                ", filter_type=" + filter_type.get(rowNum) +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(date);
        dest.writeStringList(time);
        dest.writeStringList(event_type);
        dest.writeStringList(comments);
        dest.writeStringList(presrcription);
        dest.writeStringList(filter_type);
//        dest.writeList(glucose);
//        dest.writeTypedList(lactate);
    }


//    Allows the Patient class to implement the Parcelable method, so that it can be passed between
//    activities





}
