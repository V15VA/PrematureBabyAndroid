package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prematurebabyandroid.POJOs.Patient;

import java.util.ArrayList;

public class ClinicianFoundPatientActivity extends AppCompatActivity {

    EditText patientIDinput;
    TextView searchedFor;
    private int patientID;
    Patient patient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_clinician_found_patient);

        patientID = getIntent().getIntExtra("EXTRA_PATIENT_ID", 0);
//        OLD_Character OLDCharacter = getIntent().getParcelableExtra("EXTRA_PATIENT");
        patient = getIntent().getParcelableExtra("EXTRA_PATIENT");

        patient.setPatient_id((ArrayList<Integer>) getIntent().getSerializableExtra("patientIDlist"));
        patient.setPotassium((ArrayList<Double>) getIntent().getSerializableExtra("potassium"));
        patient.setSodium((ArrayList<Double>) getIntent().getSerializableExtra("sodium"));
        patient.setLactate((ArrayList<Double>) getIntent().getSerializableExtra("lactate"));
        patient.setGlucose((ArrayList<Double>) getIntent().getSerializableExtra("glucose"));
        patient.setPotassium_input((ArrayList<Double>) getIntent().getSerializableExtra("potassium_input"));
        patient.setSodium_input((ArrayList<Double>) getIntent().getSerializableExtra("sodium_input"));
        patient.setLactate_input((ArrayList<Double>) getIntent().getSerializableExtra("lactate_input"));
        patient.setGlucose_input((ArrayList<Double>) getIntent().getSerializableExtra("glucose_input"));

//        System.out.println("PATIENT AS FOLLOWS");
//        System.out.println(patient.getRow(5));



        searchedFor = (TextView) findViewById(R.id.searched_for);
//        String message = "Showing data for patient " + OLDCharacter.getName() + " with ID " + OLDCharacter.getID();
//        searchedFor.setText(message);

    }


    // Called when the user taps the View Diary button in found_patient.xml

    public void enterDiary(View view) {

        // Do something in response to button

        Intent toDiary = new Intent(getApplicationContext(), ClinicainDiaryActivity.class);
        toDiary.putExtra("EXTRA_PATIENT", patient);

//      Non-String arraylists must be sent separately due to limitations of the
//      Parcelable class

        ArrayList<Integer> patientIDlist = patient.getPatient_id();
        toDiary.putExtra("patientIDlist", patientIDlist);
        ArrayList<Double> potassium = patient.getPotassium();
        toDiary.putExtra("potassium", potassium);
        ArrayList<Double> sodium = patient.getSodium();
        toDiary.putExtra("sodium", sodium);
        ArrayList<Double> lactate = patient.getLactate();
        toDiary.putExtra("lactate", lactate);
        ArrayList<Double> glucose = patient.getGlucose();
        toDiary.putExtra("glucose", glucose);
        ArrayList<Double> potassium_input = patient.getPotassium_input();
        toDiary.putExtra("potassium_input", potassium_input);
        ArrayList<Double> sodium_input = patient.getSodium_input();
        toDiary.putExtra("sodium_input", sodium_input);
        ArrayList<Double> lactate_input = patient.getLactate_input();
        toDiary.putExtra("lactate_input", lactate_input);
        ArrayList<Double> glucose_input = patient.getGlucose_input();
        toDiary.putExtra("glucose_input", glucose_input);
        startActivity(toDiary);
    }


    // Called when the user taps the View Summary button in found_patient.xml

    public void enterSummary(View view) {

        // Do something in response to button

        Intent toSummary = new Intent(getApplicationContext(), SummaryActivity.class);
        toSummary.putExtra("EXTRA_PATIENT", patient);

//      Non-String arraylists must be sent separately due to limitations of the
//      Parcelable class

        ArrayList<Integer> patientID = patient.getPatient_id();
        toSummary.putExtra("patientID", patientID);
        ArrayList<Double> potassium = patient.getPotassium();
        toSummary.putExtra("potassium", potassium);
        ArrayList<Double> sodium = patient.getSodium();
        toSummary.putExtra("sodium", sodium);
        ArrayList<Double> lactate = patient.getLactate();
        toSummary.putExtra("lactate", lactate);
        ArrayList<Double> glucose = patient.getGlucose();
        toSummary.putExtra("glucose", glucose);
        ArrayList<Double> potassium_input = patient.getPotassium_input();
        toSummary.putExtra("potassium_input", potassium_input);
        ArrayList<Double> sodium_input = patient.getSodium_input();
        toSummary.putExtra("sodium_input", sodium_input);
        ArrayList<Double> lactate_input = patient.getLactate_input();
        toSummary.putExtra("lactate_input", lactate_input);
        ArrayList<Double> glucose_input = patient.getGlucose_input();
        toSummary.putExtra("glucose_input", glucose_input);
        startActivity(toSummary);
    }


    // Called when the user taps the Enter Measurement button in found_patient.xml

    public void enterMeasurement(View view) {

        // Do something in response to button

        Intent toNewMeasurement = new Intent(getApplicationContext(), ClinicianNewMeasurementActivity.class);
//      Send the patient ID to the next activity
        toNewMeasurement.putExtra("EXTRA_PATIENT_ID", patientID);
        startActivity(toNewMeasurement);
    }




}