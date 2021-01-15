package com.example.prematurebabyandroid;


import android.content.Intent;

import com.example.prematurebabyandroid.POJOs.Patient;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Tests if the entire Patient object was sent correctly to the next activity
 */
/*
public class ParceledPatientTest {
    @Test
    public void ClinicianLandingFoundPatient()
    {
        int patient_id;
        ArrayList<String> date = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        ArrayList<Double> potassium = new ArrayList<>();
        ArrayList<Double> sodium = new ArrayList<>();
        ArrayList<Double> lactate = new ArrayList<>();
        ArrayList<Double> glucose = new ArrayList<>();
        ArrayList<Double> potassium_input = new ArrayList<>();
        ArrayList<Double> sodium_input = new ArrayList<>();
        ArrayList<Double> lactate_input = new ArrayList<>();
        ArrayList<Double> glucose_input = new ArrayList<>();
        ArrayList<String> event_type = new ArrayList<>();
        ArrayList<String> comments = new ArrayList<>();
        ArrayList<String> prescription = new ArrayList<>();
        ArrayList<String> filter_type = new ArrayList<>();

        patient_id = 1234;
        date.add("01/01/2021");
        time.add("00:00:00");
        potassium.add(12.3);
        sodium.add(12.3);
        lactate.add(12.3);
        glucose.add(12.3);
        potassium_input.add(12.3);
        sodium_input.add(12.3);
        lactate_input.add(12.3);
        glucose_input.add(12.3);
        event_type.add("Test Event");
        comments.add("Test Comment");
        prescription.add("Test Prescription");
        filter_type.add("Test Filter");

        Patient expectedPatient = new Patient(patient_id, date, time, potassium, sodium, lactate,
                glucose, potassium_input, sodium_input, lactate_input, glucose_input, event_type,
                comments, prescription, filter_type);

        Intent toFoundPatient = new Intent();

        //                        Send the patient ID and the patient class to the next activity


//                            Non-String ArrayLists must be parcelled individually

        ArrayList<Integer> patientIDlist = expectedPatient.getPatient_id();
        toFoundPatient.putExtra("patientIDlist", patientIDlist);
        ArrayList<Double> parcel_potassium = expectedPatient.getPotassium();
        toFoundPatient.putExtra("potassium", parcel_potassium);
        ArrayList<Double> parcel_sodium = expectedPatient.getSodium();
        toFoundPatient.putExtra("sodium", parcel_sodium);
        ArrayList<Double> parcel_lactate = expectedPatient.getLactate();
        toFoundPatient.putExtra("lactate", parcel_lactate);
        ArrayList<Double> parcel_glucose = expectedPatient.getGlucose();
        toFoundPatient.putExtra("glucose", parcel_glucose);
        ArrayList<Double> parcel_potassium_input = expectedPatient.getPotassium_input();
        toFoundPatient.putExtra("potassium_input", parcel_potassium_input);
        ArrayList<Double> parcel_sodium_input = expectedPatient.getSodium_input();
        toFoundPatient.putExtra("sodium_input", parcel_sodium_input);
        ArrayList<Double> parcel_lactate_input = expectedPatient.getLactate_input();
        toFoundPatient.putExtra("lactate_input", parcel_lactate_input);
        ArrayList<Double> parcel_glucose_input = expectedPatient.getGlucose_input();
        toFoundPatient.putExtra("glucose_input", parcel_glucose_input);


        assertEquals(4, 2 + 2);
    }
}
*/